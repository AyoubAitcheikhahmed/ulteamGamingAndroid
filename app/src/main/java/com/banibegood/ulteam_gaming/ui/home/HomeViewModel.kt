package com.banibegood.ulteam_gaming.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.repository.GamesRepository
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

enum class GameApiStatus { LOADING, ERROR, DONE }

class HomeViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val _status = MutableLiveData<GameApiStatus>()
    val status: LiveData<GameApiStatus>
        get() = _status

    private val database = GameDatabase.getInstance(application.applicationContext)
    private val gamesRepository = GamesRepository(database)

    val games = gamesRepository.games

    init {
        viewModelScope.launch {
            _status.value = GameApiStatus.LOADING
            gamesRepository.refreshGames()
            _status.value = GameApiStatus.DONE
        }
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
