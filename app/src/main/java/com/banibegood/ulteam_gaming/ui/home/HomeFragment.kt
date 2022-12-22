package com.banibegood.ulteam_gaming.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import com.banibegood.ulteam_gaming.domain.Game

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var home_recycler : RecyclerView
    private var layoutManager : RecyclerView.LayoutManager? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    lateinit var binding :FragmentHomeBinding
    lateinit var viewModel : HomeViewModel
    lateinit var adapter: GameAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //setup the db connection
        val application = requireNotNull(this.activity).application
        val dataSource = GameDatabase.getInstance(application).gameDatabaseDao
        //filling the list: joke adapter
        adapter = GameAdapter( GamesListener{
                gameId ->
            Toast.makeText(context, "${gameId}", Toast.LENGTH_SHORT).show()
        })
//        binding.gamesList.adapter = adapter
//        binding.gamesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//
       //
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        home_recycler = binding.gamesList
        home_recycler.layoutManager = layoutManager
        home_recycler.adapter = adapter
        //
        //viewmodel
        val viewModelFactory = HomeViewModelFactory(application, adapter)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)

        //databinding
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.games.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })




//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

//        _binding = FragmentHomeBinding.inflate(inflater, container, false)


//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}