package com.banibegood.ulteam_gaming.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.banibegood.ulteam_gaming.databinding.GameCardItemBinding
import com.banibegood.ulteam_gaming.domain.Game
import timber.log.Timber

class GameAdapter(val clickListener : GamesListener) : ListAdapter<Game, ViewHolder>(GameDiffCallback()){
    //taken care of by ListAdapter
    /*var data = listOf<Joke>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }*/

    /*
    override fun getItemCount(): Int {
        return data.size
    }*/

    //fill up the item you need (e.g. set texts and images)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.tag("Filling").i("filling------------------------------")

        val item = getItem(position)
        holder.bind(clickListener, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

}

//class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

class ViewHolder(val binding: GameCardItemBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(clickListener: GamesListener, item: Game) {
        binding.gameTitle.text = item.title
        binding.gameDetails.text = item.shortDescription

        binding.game =item
        binding.clickListener = clickListener
        binding.executePendingBindings()

    }

    //this way the viewHolder knows how to inflate.
    //better than having this in the adapter.
    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = GameCardItemBinding.inflate(layoutInflater, parent, false)
            return ViewHolder(binding)
        }
    }
}

class GameDiffCallback: DiffUtil.ItemCallback<Game>(){
    override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
        return oldItem == newItem
        //works perfectly because it's a dataclass.
    }
}

class GamesListener(val clickListener: (gameID: Long)->Unit){
    fun onClick(game: Game) = clickListener(game.id)
}