package com.atorrico.loansapp.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.atorrico.loansapp.R
import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.databinding.ItemStatusBinding
import kotlinx.android.synthetic.main.item_status.view.*

class StatusAdapter(private val item: LoanItem,
                    private val listener: StatusListener) :
    RecyclerView.Adapter<StatusViewHolder>() {

    interface StatusListener {
        fun onClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusViewHolder {
        val binding: ItemStatusBinding =
            ItemStatusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StatusViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: StatusViewHolder, position: Int) =
        holder.bind(item)
}

class StatusViewHolder(private val itemBinding: ItemStatusBinding,
                       private val listener: StatusAdapter.StatusListener,) :
    RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener  {

    init {
        itemBinding.cvStatus.setOnClickListener(this)
    }


    fun bind(item: LoanItem) = with(itemBinding) {
        when (item.loan?.status) {
            APPROVE_STATUS -> {
                ivStatus.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_loan_status_approved))
                tvTitleStatus.text = root.resources.getString(R.string.status_title_approve)
                tvDetailStatus.text = root.resources.getString(R.string.status_detail_approve, item.loan.approved.toString())
                btnStatus.text = root.resources.getString(R.string.status_button_approve)
            }
            PAID_STATUS -> {
                ivStatus.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_loan_status_paidoff))
                tvTitleStatus.text = root.resources.getString(R.string.status_title_paid)
                tvDetailStatus.text = root.resources.getString(R.string.status_detail_paid)
                btnStatus.text = root.resources.getString(R.string.status_button_paid)
            }
            DUE_STATUS -> {
                tvTitleStatus.text = root.resources.getString(R.string.status_title_due)
                tvDetailStatus.text = root.resources.getString(R.string.status_detail_due, item.loan.due.toString())
                btnStatus.text = root.resources.getString(R.string.status_button_due)
            }
            APPLY_STATUS -> {
                ivStatus.setImageDrawable(ContextCompat.getDrawable(root.context, R.drawable.img_loan_status_apply))
                tvTitleStatus.text = root.resources.getString(R.string.status_title_apply)
                tvDetailStatus.text = root.resources.getString(R.string.status_detail_apply)
                btnStatus.text = root.resources.getString(R.string.status_button_apply)
            }
        }
    }

    override fun onClick(v: View?) {
        listener.onClick()
    }

    companion object{
        private const val DUE_STATUS = "due"
        private const val APPROVE_STATUS = "approved"
        private const val PAID_STATUS = "paid"
        private val APPLY_STATUS = null
    }
}