package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemNoteBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.Note

class NoteAdapter(
    private val notes: List<Note>,
    private val listener: OnNoteClickListener
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

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
        holder.bind(note, position)
    }

    inner class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, position: Int) {
            binding.tvTitle.text = note.title
            binding.tvDes.text = note.des

            binding.root.setOnClickListener {
                listener.onClickNote(note)
            }

            binding.root.setOnLongClickListener {
                listener.onLongClickNote(note)
                return@setOnLongClickListener false
            }
        }
    }
}

