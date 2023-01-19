package com.banibegood.ulteam_gaming.database.game

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface GameDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg games: GameEntity)

    @Insert
    fun insert(game: GameEntity)

    @Update
    fun update(game: GameEntity)

    @Query("SELECT * FROM games_table ORDER BY id DESC LIMIT 10")
    fun getAllGamesLive(): LiveData<List<GameEntity>>

    @Query("SELECT * FROM games_table ORDER BY id DESC")
    fun getGreater20GamesLive(): LiveData<List<GameEntity>>

    // get the number of jokes present
    @Query("SELECT COUNT(*) FROM games_table")
    fun numberOfGames(): Int
}
