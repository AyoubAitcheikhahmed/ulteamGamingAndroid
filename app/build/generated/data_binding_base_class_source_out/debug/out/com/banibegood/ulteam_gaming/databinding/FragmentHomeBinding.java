// Generated by data binding compiler. Do not edit!
package com.banibegood.ulteam_gaming.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.banibegood.ulteam_gaming.R;
import com.banibegood.ulteam_gaming.ui.home.HomeViewModel;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class FragmentHomeBinding extends ViewDataBinding {
  @NonNull
  public final TextView freeRowText;

  @NonNull
  public final RecyclerView gamesList;

  @NonNull
  public final TextInputLayout inputSearch;

  @NonNull
  public final LinearLayout linearLayoutUsername;

  @NonNull
  public final TextView name;

  @NonNull
  public final LottieAnimationView notOnline;

  @NonNull
  public final ImageView photo;

  @NonNull
  public final TextView skill;

  @NonNull
  public final SwipeRefreshLayout swipeRefreshLayout;

  @NonNull
  public final SwipeRefreshLayout swipeRefreshLayoutError;

  @NonNull
  public final LinearLayout topInfo;

  @Bindable
  protected HomeViewModel mViewModel;

  protected FragmentHomeBinding(Object _bindingComponent, View _root, int _localFieldCount,
      TextView freeRowText, RecyclerView gamesList, TextInputLayout inputSearch,
      LinearLayout linearLayoutUsername, TextView name, LottieAnimationView notOnline,
      ImageView photo, TextView skill, SwipeRefreshLayout swipeRefreshLayout,
      SwipeRefreshLayout swipeRefreshLayoutError, LinearLayout topInfo) {
    super(_bindingComponent, _root, _localFieldCount);
    this.freeRowText = freeRowText;
    this.gamesList = gamesList;
    this.inputSearch = inputSearch;
    this.linearLayoutUsername = linearLayoutUsername;
    this.name = name;
    this.notOnline = notOnline;
    this.photo = photo;
    this.skill = skill;
    this.swipeRefreshLayout = swipeRefreshLayout;
    this.swipeRefreshLayoutError = swipeRefreshLayoutError;
    this.topInfo = topInfo;
  }

  public abstract void setViewModel(@Nullable HomeViewModel viewModel);

  @Nullable
  public HomeViewModel getViewModel() {
    return mViewModel;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.fragment_home, null, false, component)
   */
  @NonNull
  @Deprecated
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<FragmentHomeBinding>inflateInternal(inflater, R.layout.fragment_home, null, false, component);
  }

  public static FragmentHomeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static FragmentHomeBinding bind(@NonNull View view, @Nullable Object component) {
    return (FragmentHomeBinding)bind(component, view, R.layout.fragment_home);
  }
}
