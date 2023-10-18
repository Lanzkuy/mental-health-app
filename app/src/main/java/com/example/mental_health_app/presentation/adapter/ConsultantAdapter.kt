package com.example.mental_health_app.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mental_health_app.databinding.ItemConsultantBinding
import com.example.mental_health_app.model.Consultant

class ConsultantAdapter(
    private val consultants: List<Consultant>
) : RecyclerView.Adapter<ConsultantAdapter.ViewHolder>(
) {
    private lateinit var listener: AdapterListener

    interface AdapterListener {
        fun onClick(position: Int)
    }

    fun setItemClick(listener: AdapterListener) {
        this.listener = listener
    }

    class ViewHolder(val binding: ItemConsultantBinding, listener: AdapterListener) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                listener.onClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemConsultantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding, listener)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(consultants[position]) {
            holder.binding.tvName.text = name
            holder.binding.ivProfilePicture.setImageResource(profilePicture)
            holder.binding.tvRole.text = if (role == 1) "Psikolog" else "Psikiater"
            holder.binding.tvRating.text = rating.toString()
            if (status == 1) {
                holder.binding.tvStatus.setTextColor(Color.parseColor("#FF52BF2D"))
                holder.binding.tvStatus.text = "Available"
            } else {
                holder.binding.tvStatus.setTextColor(Color.parseColor("#FFCE272C"))
                holder.binding.tvStatus.text = "Unavailable"
            }
        }
    }

    override fun getItemCount(): Int = consultants.size
}