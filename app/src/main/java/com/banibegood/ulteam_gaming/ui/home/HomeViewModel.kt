package com.banibegood.ulteam_gaming.ui.home

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.*
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding
import com.banibegood.ulteam_gaming.domain.GamePicture
import com.banibegood.ulteam_gaming.repository.GamesRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.io.IOException

enum class GameApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val _pictures = MutableLiveData<GamePicture>()
    val pictures: MutableLiveData<GamePicture> = _pictures

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _status = MutableLiveData<GameApiStatus>()
    val status: LiveData<GameApiStatus>
        get() = _status

    private val database = GameDatabase.getInstance(application.applicationContext)
    private val gamesRepository = GamesRepository(database)

    val games = gamesRepository.games

     init {
         if (connectivityIntercepter(application.applicationContext)){
             viewModelScope.launch {
                 _status.value = GameApiStatus.LOADING
                 gamesRepository.refreshGames()
                 _status.value = GameApiStatus.DONE
             } }
    }

    /**
     * Synchronize UI elements with the internet connectivity
     * @param binding
     *
     */
    private fun onInternetOffline(binding : FragmentHomeBinding){
        binding.swipeRefreshLayout.visibility = View.GONE
        binding.swipeRefreshLayoutError.visibility = View.VISIBLE
    }
    private fun onInternetOnline(binding : FragmentHomeBinding){
        binding.swipeRefreshLayout.visibility = View.VISIBLE
        binding.swipeRefreshLayoutError.visibility = View.GONE
    }

    /**
     * initblock to to be called if the internet is offline
     *
     * @author: Banibegood
     * @param application
     *
     */
    public fun initBlock(application: Application){
        if (connectivityIntercepter(application.applicationContext)){
            viewModelScope.launch {
                _status.value = GameApiStatus.LOADING
                gamesRepository.refreshGames()
                _status.value = GameApiStatus.DONE
            }
        }
    }

    /**
     * Check if the device is connected to the internet
     *
     * @author: Banibegood
     *
     * @param context
     * @return true if connected, false otherwise
     */
    fun connectivityIntercepter(context: Context) : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    /**
     * Get the username from the shared preferences
     *
     * @author: Banibegood
     * @param context the context of the application
     *
     *
     */
    public fun manageDisplayOnConnectivity(context: Context,binding : FragmentHomeBinding){
        if (connectivityIntercepter(context)){
            onInternetOnline(binding)
        }else if (!connectivityIntercepter(context)){
            onInternetOffline(binding)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

    fun setUsername(username: String?) {
        _username.value = username

    }

    /**
     * factory for the HomeViewModel
     * @param application
     * @author: Banibegood
     * @return HomeViewModel
     * @exception IOException
     */
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return HomeViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }


}
