package com.banibegood.ulteam_gaming.ui.login;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001eH\u0002J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0011R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/banibegood/ulteam_gaming/ui/login/LoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/banibegood/ulteam_gaming/databinding/FragmentLoginBinding;", "account", "Lcom/auth0/android/Auth0;", "binding", "getBinding", "()Lcom/banibegood/ulteam_gaming/databinding/FragmentLoginBinding;", "loggedIn", "", "loggedInText", "Landroid/widget/TextView;", "viewModel", "Lcom/banibegood/ulteam_gaming/ui/login/LoginViewModel;", "checkIfToken", "", "loginWithBrowser", "logout", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "setLoggedInText", "name", "", "showUserProfile", "accessToken", "switchEn", "switchFr", "app_debug"})
public final class LoginFragment extends androidx.fragment.app.Fragment {
    private com.banibegood.ulteam_gaming.databinding.FragmentLoginBinding _binding;
    private com.auth0.android.Auth0 account;
    private android.widget.TextView loggedInText;
    private boolean loggedIn = false;
    private com.banibegood.ulteam_gaming.ui.login.LoginViewModel viewModel;
    private java.util.HashMap _$_findViewCache;
    
    public LoginFragment() {
        super();
    }
    
    private final com.banibegood.ulteam_gaming.databinding.FragmentLoginBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void checkIfToken() {
    }
    
    private final void setLoggedInText(java.lang.String name, com.banibegood.ulteam_gaming.ui.login.LoginViewModel viewModel) {
    }
    
    private final void loginWithBrowser() {
    }
    
    private final void logout() {
    }
    
    private final void showUserProfile(java.lang.String accessToken) {
    }
    
    public final void switchEn() {
    }
    
    public final void switchFr() {
    }
}