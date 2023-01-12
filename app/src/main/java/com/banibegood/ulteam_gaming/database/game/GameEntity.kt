package com.banibegood.ulteam_gaming.database.game

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.banibegood.ulteam_gaming.domain.Game
import com.squareup.moshi.Json

@Entity(tableName = "games_table")
data class GameEntity(
    val developer: String,

    @Json(name = "freetogameProfileUrl")
    val freetogameProfileUrl: String,

    @Json(name = "game_url")
    val gameUrl: String,

    val genre: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long,

    val platform: String,

    val publisher: String,

    @Json(name = "release_date")
    val releaseDate: String,

    @Json(name = "short_description")
    val shortDescription: String,

    val thumbnail: String,

    val title: String
)

fun List<GameEntity>.asDomainModel(): List<Game> {
    return map {
        Game(
            developer = it.developer,
            freetogameProfileUrl = it.freetogameProfileUrl,
            gameUrl = it.gameUrl,
            genre = it.genre,
            id = it.id,
            platform = it.platform,
            publisher = it.publisher,
            releaseDate = it.releaseDate,
            shortDescription = it.shortDescription,
            thumbnail = it.thumbnail,
            title = it.title
        )
    }
}
