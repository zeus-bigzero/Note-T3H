package edu.t3h.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemNoteBinding
import edu.t3h.note.model.Note

class NoteAdapter(
    private val notes: List<Note>
) : RecyclerView.Adapter<NoteViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding: ItemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.tvTitle.text = note.title
        holder.binding.tvDes.text = note.des
    }
}

class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)