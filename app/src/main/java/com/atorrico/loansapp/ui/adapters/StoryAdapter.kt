package com.atorrico.loansapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.atorrico.loansapp.R
import com.atorrico.loansapp.databinding.ItemStoryBinding

class StoryAdapter : RecyclerView.Adapter<StoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding: ItemStoryBinding =
            ItemStoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) =
        holder.bind()
}

class StoryViewHolder(private val itemBinding: ItemStoryBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind() {
        itemBinding.ivStatus.setImageDrawable(
            ContextCompat.getDrawable(itemBinding.root.context, R.drawable.img_story_card_mx)
        )
    }
}