package com.banibegood.ulteam_gaming.network


import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.PrimaryKey
import com.banibegood.ulteam_gaming.database.game.GameEntity
import com.banibegood.ulteam_gaming.domain.Game
import com.squareup.moshi.Json
import kotlinx.coroutines.Deferred

/*ApiJoke: this is a DataTransferObject
* it's goal is to get network data into our model data, the Joke
*/

/*Container helps us parse the body into multiple jokes*/
data class ApiGameContainer (
    @Json(name = "body")
    val apiGames: List<ApiGame>
)

/*ApiJoke, representing a joke from the network*/
data class ApiGame(
    val developer: String,

    @Json(name="freetogameProfileUrl")
    val freetogameProfileUrl: String,

    @Json(name="game_url")
    val gameUrl: String,

    val genre: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val platform: String,

    val publisher: String,

    @Json(name="release_date")
    val releaseDate: String,

    @Json(name="short_description")
    val shortDescription: String,

    val thumbnail: String,

    val title: String
)

/*
* Convert network results into Domain jokes
* */
fun ApiGameContainer.asDomainModel(): List<Game>{
    return apiGames.map {
        Game(
            developer = it.developer,
            freetogameProfileUrl = it.freetogameProfileUrl,
            gameUrl = it.developer,
            genre = it.genre,
            id = it.id,
            platform = it.platform,
            publisher = it.developer,
            releaseDate = it.freetogameProfileUrl,
            shortDescription = it.shortDescription,
            thumbnail = it.thumbnail,
            title = it.title
        )
    }
}

/*
* Convert network result into Database jokes
*
* returns an array that can be used in the insert call as vararg
* */
fun ApiGameContainer.asDatabaseModel(): Array<GameEntity>{
    return apiGames.map{
        GameEntity(
            developer = it.developer,
            freetogameProfileUrl = it.freetogameProfileUrl,
            gameUrl = it.developer,
            genre = it.genre,
            id = it.id,
            platform = it.platform,
            publisher = it.developer,
            releaseDate = it.freetogameProfileUrl,
            shortDescription = it.shortDescription,
            thumbnail = it.thumbnail,
            title = it.title)
    }.toTypedArray()
}

/*
* Convert a single api joke to a database joke
* */
fun ApiGame.asDatabaseJoke(): GameEntity{
    return GameEntity(
        developer = developer,
        freetogameProfileUrl = freetogameProfileUrl,
        gameUrl = developer,
        genre = genre,
        id = id,
        platform = platform,
        publisher = developer,
        releaseDate = freetogameProfileUrl,
        shortDescription = shortDescription,
        thumbnail = thumbnail,
        title = title
    )
}