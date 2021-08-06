package com.atorrico.loansapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.atorrico.loansapp.databinding.ItemExtrasBinding

class ExtrasAdapter(private val icon: Int, private val text: Int) : RecyclerView.Adapter<ExtrasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtrasViewHolder {
        val binding: ItemExtrasBinding =
            ItemExtrasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ExtrasViewHolder(binding)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: ExtrasViewHolder, position: Int) =
        holder.bind(icon, text)
}

class ExtrasViewHolder(private val itemBinding: ItemExtrasBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(icon: Int, text: Int) = with(itemBinding) {
        itemBinding.ivExtra.setImageDrawable(ContextCompat.getDrawable(itemBinding.root.context, icon))
        itemBinding.tvExtras.text = root.resources.getString(text)
    }
}