package com.banibegood.ulteam_gaming.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/banibegood/ulteam_gaming/login/CredentialsManager;", "", "()V", "ACCESS_TOKEN", "", "editor", "Landroid/content/SharedPreferences$Editor;", "getAccessToken", "context", "Landroid/content/Context;", "saveCredentials", "", "credentials", "Lcom/auth0/android/result/Credentials;", "app_debug"})
public final class CredentialsManager {
    @org.jetbrains.annotations.NotNull()
    public static final com.banibegood.ulteam_gaming.login.CredentialsManager INSTANCE = null;
    private static final java.lang.String ACCESS_TOKEN = "access_token";
    private static android.content.SharedPreferences.Editor editor;
    
    private CredentialsManager() {
        super();
    }
    
    public final void saveCredentials(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.auth0.android.result.Credentials credentials) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getAccessToken(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}