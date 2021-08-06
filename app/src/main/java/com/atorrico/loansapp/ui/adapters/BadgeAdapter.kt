package com.atorrico.loansapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.atorrico.loansapp.R
import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.databinding.ItemBadgeBinding

class BadgeAdapter(private val item: LoanItem) :
    RecyclerView.Adapter<BadgeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BadgeViewHolder {
        val binding: ItemBadgeBinding =
            ItemBadgeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BadgeViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: BadgeViewHolder, position: Int) =
        holder.bind(item)
}

class BadgeViewHolder(private val itemBinding: ItemBadgeBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(item: LoanItem) = with(itemBinding) {
        when (item.loan?.level) {
            BLUE_BADGE -> {
                ivBadge.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_blue_badge_large))
            }
            BRONZE_BADGE -> {
                ivBadge.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_bronze_badge_large))
            }
            SILVER_BADGE -> {
                ivBadge.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_silver_badge_large))
            }
            GOLD_BADGE -> {
                ivBadge.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_gold_badge_large))
            }
        }
    }

    companion object{
        private const val BLUE_BADGE = "blue"
        private const val BRONZE_BADGE = "bronze"
        private const val SILVER_BADGE = "silver"
        private const val GOLD_BADGE = "gold"
    }
}