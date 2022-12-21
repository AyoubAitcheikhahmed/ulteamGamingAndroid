package com.banibegood.ulteam_gaming.repository

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.banibegood.ulteam_gaming.database.game.GameDatabase
import com.banibegood.ulteam_gaming.database.game.asDomainModel
import com.banibegood.ulteam_gaming.domain.Game
import com.banibegood.ulteam_gaming.network.ApiGame
import com.banibegood.ulteam_gaming.network.GameApi
import com.banibegood.ulteam_gaming.network.GameApi.mockPutGame
import com.banibegood.ulteam_gaming.network.asDatabaseJoke
import com.banibegood.ulteam_gaming.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GamesRepository(private val database: GameDatabase) {

    /*
    * What if the jokes list depends on query params?
    * --> The livedata source from the db will change!
    * */

    /* -- Solution 1 -- */
    /*MediatorLiveData
    * Hold a reference to the livedata instances, and switch them when needed
    * */

    /* -- Solution 2 -- */
    /*SwitchMap
    * Helper function for livedata (uses a MediatorLiveData object in the background)
    * */

    //Network call
    //get jokes from the database, but transform them with map
    val games = MediatorLiveData<List<Game>>()


    //keep a reference to the original livedata
    private var changeableLiveData = Transformations.map(database.gameDatabaseDao.getAllGamesLive()){
        it.asDomainModel()
    }

    //add the data to the mediator
    init {
        games.addSource(
            changeableLiveData
        ){
            games.setValue(it)
        }
    }

    //filter is now less complex
//    fun addFilterSolution2(filter: String?){
//        //remove the original source
//        this.filter.value = filter
//    }


    //Database call
    suspend fun refreshGames(){
        //switch context to IO thread
        withContext(Dispatchers.IO){
            val games = GameApi.retrofitService.getGames().await()
            //'*': kotlin spread operator.
            //Used for functions that expect a vararg param
            //just spreads the array into separate fields
            database.gameDatabaseDao.insertAll(*games.asDatabaseModel())
//            Timber.i("end suspend")
        }
    }


    //create a new joke + return the resulting joke
    suspend fun createJoke(newGame: Game): Game {
        //create a Data Transfer Object (Dto)
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
        //use retrofit to put the joke.
        //a put function usually returns the object that was put

        //val checkApiJoke = JokeApi.retrofitService.putJoke(newApiJoke).await()
        val checkApiGame = GameApi.retrofitService.mockPutGame(newApiGame)

        //the put results in a JokeApi object
        //when the put is done, update the local db as well
        database.gameDatabaseDao.insert(checkApiGame.asDatabaseJoke())
        //the returned joke can be used to pass as save arg to the next fragment (e.g)
        return newGame
    }





}