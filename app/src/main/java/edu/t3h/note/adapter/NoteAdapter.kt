package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemNoteBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.NoteModel

class NoteAdapter(
    private val notes: List<NoteModel>,
    private val listener: OnNoteClickListener
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (position == 0 || position == 1) {0} else {1}
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
        fun bind(note: NoteModel, position: Int) {
            binding.tvTitle.text = note.title
            binding.tvDes.text = note.des

            binding.root.setOnClickListener {
                listener.onClickNote(note)
            }

            binding.root.setOnLongClickListener {
                listener.onLongClickNote(note)
                true
            }
        }
    }
}

