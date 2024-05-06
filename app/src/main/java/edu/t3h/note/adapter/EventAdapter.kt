package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemEventRvBinding

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {
    inner class EventViewHolder(private val binding: ItemEventRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.day.text = "Sunday"
            binding.date.text = "22 December, 2021"
            binding.addEventTxt.text = "Create New Event"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = 10

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(position)
    }
}