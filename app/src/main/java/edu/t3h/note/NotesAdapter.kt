package edu.t3h.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemNoteRvBinding
import edu.t3h.note.model.Note

class NotesAdapter(private val list: List<Note>) : RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = list[position]
        holder.binding.tvTitle.text = note.title
        holder.binding.tvContent.text = note.content
    }
}

class NoteViewHolder(val binding: ItemNoteRvBinding) : RecyclerView.ViewHolder(binding.root)