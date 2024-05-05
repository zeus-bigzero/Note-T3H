package edu.t3h.note.adapter

import android.icu.text.SimpleDateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemEventsBinding
import java.util.Date
import java.util.Locale

class EventsAdapter():RecyclerView.Adapter<EventsAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val binding = ItemEventsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventViewHolder(binding)
    }

    override fun getItemCount(): Int = 8

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind()
    }

    inner class EventViewHolder(private val binding : ItemEventsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind() {
            val dateFormater = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
            val weekDaysFormater = SimpleDateFormat("EEEE", Locale.ENGLISH)
            val date = Date()
            val currentDate = dateFormater.format(date)
            val currentWeekdays = weekDaysFormater.format(date)
            binding.date.text = currentDate
            binding.weekdays.text = currentWeekdays
        }
    }
}