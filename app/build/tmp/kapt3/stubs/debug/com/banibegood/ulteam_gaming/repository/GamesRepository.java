package com.banibegood.ulteam_gaming.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/banibegood/ulteam_gaming/repository/GamesRepository;", "", "database", "Lcom/banibegood/ulteam_gaming/database/game/GameDatabase;", "(Lcom/banibegood/ulteam_gaming/database/game/GameDatabase;)V", "changeableLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/banibegood/ulteam_gaming/domain/Game;", "kotlin.jvm.PlatformType", "games", "Landroidx/lifecycle/MediatorLiveData;", "getGames", "()Landroidx/lifecycle/MediatorLiveData;", "createGame", "newGame", "(Lcom/banibegood/ulteam_gaming/domain/Game;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshGames", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GamesRepository {
    private final com.banibegood.ulteam_gaming.database.game.GameDatabase database = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.banibegood.ulteam_gaming.domain.Game>> games = null;
    private androidx.lifecycle.LiveData<java.util.List<com.banibegood.ulteam_gaming.domain.Game>> changeableLiveData;
    
    public GamesRepository(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.database.game.GameDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.banibegood.ulteam_gaming.domain.Game>> getGames() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshGames(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createGame(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.domain.Game newGame, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.banibegood.ulteam_gaming.domain.Game> continuation) {
        return null;
    }
}