package com.banibegood.ulteam_gaming.ui.home

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.banibegood.ulteam_gaming.R
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import timber.log.Timber


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var home_recycler: RecyclerView
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var loggedInText: TextView

    // This property is only valid between onCreateView and
    // onDestroyView.
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // setup the db connection
        val application = requireNotNull(this.activity).application
        val dataSource = GameDatabase.getInstance(application).gameDatabaseDao

        // filling the list: joke adapter
        adapter = GameAdapter(
            GamesListener { gameId,gameLink ->
                var webpage = Uri.parse(gameLink)
                if (!gameLink.startsWith("http://") && !gameLink.startsWith("https://")) {
                    webpage = Uri.parse("http://$gameLink")
                }
                val intent = Intent(Intent.ACTION_VIEW, webpage)
                startActivity(intent) },
            application.applicationContext
        )

        binding.gamesList.adapter = adapter
        val viewModelFactory = HomeViewModelFactory(application, adapter)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        // databinding
        binding.viewModel = viewModel

        home_recycler = binding.gamesList

        val swipeRefreshLayout = binding.swipeRefreshLayout

        swipeRefreshLayout.setOnRefreshListener {
            viewModel.manageDisplayOnConnectivity(application.applicationContext,binding)
            swipeRefreshLayout.isRefreshing = false
        }

        val swipeRefreshLayoutError = binding.swipeRefreshLayoutError

        swipeRefreshLayoutError.setOnRefreshListener {
            viewModel.manageDisplayOnConnectivity(application.applicationContext,binding)
            swipeRefreshLayout.isRefreshing = false
        }

        viewModel.games.observe(
            viewLifecycleOwner,
            Observer {
                viewModel.manageDisplayOnConnectivity(application.applicationContext,binding)
                adapter.submitList(it)
            }
        )

        //

        //setting username
        viewModel.username.observe(
            viewLifecycleOwner,
            Observer {
                binding.name.text = it
            }
        )

        binding.inputSearch.visibility = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) View.GONE else View.VISIBLE
        return binding.root
    }

}
