package com.banibegood.ulteam_gaming.ui.home

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.banibegood.ulteam_gaming.R
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import com.banibegood.ulteam_gaming.login.CredentialsManager
import com.banibegood.ulteam_gaming.repository.GamesRepository
import okhttp3.internal.notify
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
            GamesListener { gameId -> Toast.makeText(context, "$gameId", Toast.LENGTH_SHORT).show() },
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
            printState()
            if(viewModel.connectivityIntercepter(application.applicationContext)){
                connectElements()
                viewModel.initBlock(application)
            }else{
                disconnectElements()
            }
            printState()

//            if(viewModel.connectivityIntercepter(application.applicationContext)) {
//                adapter.notify()
//            }else{
//                disconnectElements()
//            }
            swipeRefreshLayout.isRefreshing = false
        }

        val swipeRefreshLayoutError = binding.swipeRefreshLayoutError
        swipeRefreshLayoutError.setOnRefreshListener {
            printState()
            if(viewModel.connectivityIntercepter(application.applicationContext)){
                connectElements()
                viewModel.initBlock(application)
            }else{
                disconnectElements()
            }
            printState()

//            if(viewModel.connectivityIntercepter(application.applicationContext)) {
//                adapter.notify()
//            }else{
//                disconnectElements()
//            }
            swipeRefreshLayout.isRefreshing = false
        }

        viewModel.games.observe(
            viewLifecycleOwner,
            Observer {
                if(viewModel.connectivityIntercepter(application.applicationContext)){
                    connectElements()
                    adapter.submitList(it)
                }else{
                    disconnectElements()
                }
            }
        )

        binding.inputSearch.visibility = if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) View.GONE else View.VISIBLE
        return binding.root
    }

    fun disconnectElements(){
        binding.swipeRefreshLayout.visibility = View.GONE
        binding.swipeRefreshLayoutError.visibility = View.VISIBLE

    }

    fun connectElements(){
        binding.swipeRefreshLayout.visibility = View.VISIBLE
        binding.swipeRefreshLayoutError.visibility = View.GONE

    }


    fun addRefreshOnScrollListener(recyclerView: RecyclerView) {
        recyclerView
    }

    fun printState(){
        if(binding.swipeRefreshLayout.visibility == View.VISIBLE){
            Timber.tag("VISIBILITY GAMELIST ").i("_VISIBLE")
        }else if (binding.swipeRefreshLayout.visibility == View.GONE){
            Timber.tag("VISIBILITY GAMELIST ").i("_INVISIBLE")
        }
        if(binding.swipeRefreshLayoutError.visibility == View.VISIBLE){
            Timber.tag("VISIBILITY ERROR ").i("_VISIBLE")
        }else if (binding.swipeRefreshLayoutError.visibility == View.GONE){
            Timber.tag("VISIBILITY ERROR ").i("_INVISIBLE")
        }
    }



}
