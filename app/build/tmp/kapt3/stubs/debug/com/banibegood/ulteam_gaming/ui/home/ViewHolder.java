package com.banibegood.ulteam_gaming.ui.home;

import java.lang.System;

/**
 * ViewHolder for Game items. All work is done by data binding.
 *
 * @param binding
 */
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lcom/banibegood/ulteam_gaming/ui/home/ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/banibegood/ulteam_gaming/databinding/GameCardItemBinding;", "(Lcom/banibegood/ulteam_gaming/databinding/GameCardItemBinding;)V", "getBinding", "()Lcom/banibegood/ulteam_gaming/databinding/GameCardItemBinding;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "bind", "", "clickListener", "Lcom/banibegood/ulteam_gaming/ui/home/GamesListener;", "item", "Lcom/banibegood/ulteam_gaming/domain/Game;", "Companion", "app_debug"})
public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    @org.jetbrains.annotations.NotNull()
    private final com.banibegood.ulteam_gaming.databinding.GameCardItemBinding binding = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.banibegood.ulteam_gaming.ui.home.ViewHolder.Companion Companion = null;
    
    public ViewHolder(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.databinding.GameCardItemBinding binding) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.banibegood.ulteam_gaming.databinding.GameCardItemBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    /**
     * Bind function that binds data from item into the items of the list
     * uses Glide lib to get image from Given URL into the image view
     *
     * @param clickListener    listener for the click on the item
     * @param  item             item to be binded
     */
    public final void bind(@org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.ui.home.GamesListener clickListener, @org.jetbrains.annotations.NotNull()
    com.banibegood.ulteam_gaming.domain.Game item) {
    }
    
    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Game]
     * has been updated.
     */
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/banibegood/ulteam_gaming/ui/home/ViewHolder$Companion;", "", "()V", "from", "Lcom/banibegood/ulteam_gaming/ui/home/ViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.banibegood.ulteam_gaming.ui.home.ViewHolder from(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent) {
            return null;
        }
    }
}