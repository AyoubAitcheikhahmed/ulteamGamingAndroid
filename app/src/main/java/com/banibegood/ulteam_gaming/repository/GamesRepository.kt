package com.banibegood.ulteam_gaming.repository

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.database.game.asDomainModel
import com.banibegood.ulteam_gaming.domain.Game
import com.banibegood.ulteam_gaming.network.*
import com.banibegood.ulteam_gaming.network.GameApi.mockPutGame
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GamesRepository(private val database: GameDatabase) {


    val games = MediatorLiveData<List<Game>>()

    private var changeableLiveData =
        Transformations.map(database.gameDatabaseDao.getAllGamesLive()) {
            it.asDomainModel()
        }

    /**
     * INIT method to be called from the ViewModel, to start the process of getting the games
     * from the network and storing them in the database
     *
     *@author Banibegood
     *
     */
    init {
        games.addSource(
            changeableLiveData
        ) {
            games.setValue(it)
        }
    }

    /**
     * Refresh the games stored in the offline cache.
     *
     * This function uses the IO dispatcher to ensure the database insert database operation
     * happens on the IO dispatcher. By switching to the IO dispatcher using `withContext` this
     * function is now safe to call from any thread including the Main thread.
     *
     * @author: Banibegood- Ayoub ait cheikh ahmed
     */
    suspend fun refreshGames() {
        withContext(Dispatchers.IO) {
            val games = GameApi.retrofitService.getGamesListAsync().await()
            val apiGameContainer = ApiGameContainer(games)
            database.gameDatabaseDao.insertAll(*apiGameContainer.asDatabaseModel())
        }
    }

    /**
     * Create an instance of create Game and use retrofit to put the game.
     * when the put is done, update the local db as well
     *
     * @author: Banibegood
     * @return: Game that was inserted to db
     *
     */
    suspend fun createGame(newGame: Game): Game {
        // create a Data Transfer Object (Dto)
        val newApiGame = ApiGame(
            developer = newGame.developer,
            freetogameProfileUrl = newGame.freetogameProfileUrl,
            gameUrl = newGame.gameUrl,
            genre = newGame.genre,
            id = newGame.id,
            platform = newGame.platform,
            publisher = newGame.publisher,
            releaseDate = newGame.releaseDate,
            shortDescription = newGame.shortDescription,
            thumbnail = newGame.thumbnail,
            title = newGame.title
        )
        val checkApiGame = GameApi.retrofitService.mockPutGame(newApiGame)
        database.gameDatabaseDao.insert(checkApiGame.asDatabase())
        return newGame
    }
}

