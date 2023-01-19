package com.banibegood.ulteam_gaming.database.game;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\'J!\u0010\n\u001a\u00020\b2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\f\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\'J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\'\u00a8\u0006\u0011"}, d2 = {"Lcom/banibegood/ulteam_gaming/database/game/GameDatabaseDao;", "", "getAllGamesLive", "Landroidx/lifecycle/LiveData;", "", "Lcom/banibegood/ulteam_gaming/database/game/GameEntity;", "getGreater20GamesLive", "insert", "", "game", "insertAll", "games", "", "([Lcom/banibegood/ulteam_gaming/database/game/GameEntity;)V", "numberOfGames", "", "update", "app_debug"})
public abstract interface GameDatabaseDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.database.game.GameEntity... games);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.database.game.GameEntity game);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.database.game.GameEntity game);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM games_table ORDER BY id DESC LIMIT 10")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.banibegood.ulteam_gaming.database.game.GameEntity>> getAllGamesLive();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM games_table ORDER BY id DESC")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.banibegood.ulteam_gaming.database.game.GameEntity>> getGreater20GamesLive();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM games_table")
    public abstract int numberOfGames();
}