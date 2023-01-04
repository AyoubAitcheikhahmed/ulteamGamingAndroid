package com.banibegood.ulteam_gaming.ui.home

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import androidx.core.net.toUri
import androidx.lifecycle.*
import com.banibegood.ulteam_gaming.database.game.GameDatabase
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
    public fun initBlock(application: Application){
        Timber.tag("called INITBLOCK").i("______________________")
        if (connectivityIntercepter(application.applicationContext)){
            viewModelScope.launch {
                _status.value = GameApiStatus.LOADING
                gamesRepository.refreshGames()
                _status.value = GameApiStatus.DONE
            } }
    }

    public fun connectivityIntercepter(context: Context) : Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }

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
