package com.banibegood.ulteam_gaming.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0003H\'\u00a8\u0006\b"}, d2 = {"Lcom/banibegood/ulteam_gaming/network/GameApiService;", "", "getGamesAsync", "Lkotlinx/coroutines/Deferred;", "Lcom/banibegood/ulteam_gaming/network/ApiGameContainer;", "getGamesListAsync", "", "Lcom/banibegood/ulteam_gaming/network/ApiGame;", "app_debug"})
public abstract interface GameApiService {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "games")
    public abstract kotlinx.coroutines.Deferred<com.banibegood.ulteam_gaming.network.ApiGameContainer> getGamesAsync();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "games")
    public abstract kotlinx.coroutines.Deferred<java.util.List<com.banibegood.ulteam_gaming.network.ApiGame>> getGamesListAsync();
}