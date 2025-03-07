package com.yousef.mysight00.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yousef.mysight00.databinding.ItemDayBinding

class DaysAdapter(private val daysList: List<String>, private val onClick: (String) -> Unit) :
    RecyclerView.Adapter<DaysAdapter.DayViewHolder>() {

    class DayViewHolder(private val binding: ItemDayBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(day: String, onClick: (String) -> Unit) {
            binding.tvDay.text = day
            binding.root.setOnClickListener { onClick(day) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayViewHolder {
        val binding = ItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.bind(daysList[position], onClick)
    }

    override fun getItemCount(): Int = daysList.size
}
