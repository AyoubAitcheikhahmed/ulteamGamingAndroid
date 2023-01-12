package com.banibegood.ulteam_gaming.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.Coil
import coil.load
import com.banibegood.ulteam_gaming.databinding.GameCardItemBinding
import com.banibegood.ulteam_gaming.domain.AppGlideModule
import com.banibegood.ulteam_gaming.domain.Game
import com.bumptech.glide.Glide
import timber.log.Timber

/**
 * Adapter for the [RecyclerView] in [HomeFragment] to display the list of games.
 *
 *
 * @param context Context of the fragment
 * @param onClickListener Listener for when a game is clicked
 */
class GameAdapter(val clickListener: GamesListener, val context: Context) : ListAdapter<Game, ViewHolder>(GameDiffCallback()) {

    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent an item.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     *
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }
}

/**
 * ViewHolder for Game items. All work is done by data binding.
 *
 * @param binding
 */
class ViewHolder(val binding: GameCardItemBinding) : RecyclerView.ViewHolder(binding.root) {

    val context: Context = this.itemView.context

    /**
     * Bind function that binds data from item into the items of the list
     * uses Glide lib to get image from Given URL into the image view
     *
     * @param clickListener    listener for the click on the item
     *@param  item             item to be binded
     *
     */
    fun bind(clickListener: GamesListener, item: Game) {

        //GLIDE
        val imageView: ImageView = binding.roundedImageView
        val currentUrl: String = item.thumbnail

        Glide.with(context)
            .load(currentUrl)
            .into(imageView)

        binding.gameTitle.text = item.title
        binding.gameDetails.text = item.shortDescription

        binding.game = item
        binding.clickListener = clickListener
        binding.executePendingBindings()
    }

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [Game]
     * has been updated.
     */
    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GameCardItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}

class GameDiffCallback : DiffUtil.ItemCallback<Game>() {
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
    }
}

/**
 * Custom listener that handles clicks on [RecyclerView] items.  Passes the [Game]
 * associated with the current item to the [onClick] function.
 * @param clickListener lambda that will be called with the current [Game]
 *@author Banibegood
 *
 */
class GamesListener(val clickListener: (gameID: Long,gameLink : String) -> Unit) {

    fun onClick(game: Game) {
        clickListener(game.id,game.gameUrl)}
}
