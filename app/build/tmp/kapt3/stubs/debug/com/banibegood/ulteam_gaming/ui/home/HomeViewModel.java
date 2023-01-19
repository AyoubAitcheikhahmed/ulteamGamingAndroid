package com.banibegood.ulteam_gaming.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\'\u001a\u00020&2\u0006\u0010#\u001a\u00020$2\u0006\u0010(\u001a\u00020)J\b\u0010*\u001a\u00020&H\u0014J\u000e\u0010+\u001a\u00020&2\u0006\u0010(\u001a\u00020)J\u0010\u0010,\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010-\u001a\u00020&2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c8F\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/banibegood/ulteam_gaming/ui/home/HomeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_pictures", "Landroidx/lifecycle/MutableLiveData;", "Lcom/banibegood/ulteam_gaming/domain/GamePicture;", "_status", "Lcom/banibegood/ulteam_gaming/ui/home/GameApiStatus;", "_username", "", "database", "Lcom/banibegood/ulteam_gaming/database/game/GameDatabase;", "games", "Landroidx/lifecycle/MediatorLiveData;", "", "Lcom/banibegood/ulteam_gaming/domain/Game;", "getGames", "()Landroidx/lifecycle/MediatorLiveData;", "gamesRepository", "Lcom/banibegood/ulteam_gaming/repository/GamesRepository;", "pictures", "getPictures", "()Landroidx/lifecycle/MutableLiveData;", "setPictures", "(Landroidx/lifecycle/MutableLiveData;)V", "status", "Landroidx/lifecycle/LiveData;", "getStatus", "()Landroidx/lifecycle/LiveData;", "username", "getUsername", "connectivityIntercepter", "", "context", "Landroid/content/Context;", "initBlock", "", "manageDisplayOnConnectivity", "binding", "Lcom/banibegood/ulteam_gaming/databinding/FragmentHomeBinding;", "onCleared", "onInternetOffline", "onInternetOnline", "setUsername", "Factory", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.AndroidViewModel {
    private final androidx.lifecycle.MutableLiveData<com.banibegood.ulteam_gaming.domain.GamePicture> _pictures = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<com.banibegood.ulteam_gaming.domain.GamePicture> pictures;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _username = null;
    private final androidx.lifecycle.MutableLiveData<com.banibegood.ulteam_gaming.ui.home.GameApiStatus> _status = null;
    private final com.banibegood.ulteam_gaming.database.game.GameDatabase database = null;
    private com.banibegood.ulteam_gaming.repository.GamesRepository gamesRepository;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.banibegood.ulteam_gaming.domain.Game>> games = null;
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.banibegood.ulteam_gaming.domain.GamePicture> getPictures() {
        return null;
    }
    
    public final void setPictures(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.banibegood.ulteam_gaming.domain.GamePicture> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.banibegood.ulteam_gaming.ui.home.GameApiStatus> getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.banibegood.ulteam_gaming.domain.Game>> getGames() {
        return null;
    }
    
    /**
     * Synchronize UI elements with the internet connectivity
     * @param binding
     */
    public final void onInternetOffline(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding binding) {
    }
    
    private final void onInternetOnline(com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding binding) {
    }
    
    /**
     * initblock to to be called if the internet is offline
     *
     * @author: Banibegood
     * @param application
     */
    public final void initBlock(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
    }
    
    /**
     * Check if the device is connected to the internet
     *
     * @author: Banibegood
     *
     * @param context
     * @return true if connected, false otherwise
     */
    public final boolean connectivityIntercepter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Get the username from the shared preferences
     *
     * @author: Banibegood
     * @param context the context of the application
     */
    public final void manageDisplayOnConnectivity(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.databinding.FragmentHomeBinding binding) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public final void setUsername(@org.jetbrains.annotations.Nullable()
    java.lang.String username) {
    }
    
    /**
     * factory for the HomeViewModel
     * @param application
     * @author: Banibegood
     * @return HomeViewModel
     * @exception IOException
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lcom/banibegood/ulteam_gaming/ui/home/HomeViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "getApp", "()Landroid/app/Application;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final android.app.Application app = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        android.app.Application app) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.app.Application getApp() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}