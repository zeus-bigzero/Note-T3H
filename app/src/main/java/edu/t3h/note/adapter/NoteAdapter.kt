package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.Note
import edu.t3h.note.databinding.ItemGridViewBinding

class NoteAdapter(
    private val notes: List<Note>
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemGridViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    inner class NoteViewHolder(private val binding: ItemGridViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.tvTitle.text = note.title
            binding.tvDes.text = note.des
        }
    }
}