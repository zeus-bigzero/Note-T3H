package edu.t3h.note.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import edu.t3h.note.databinding.ItemNoteRvBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.Note

class NotesAdapter(private val list: List<Note>, private val listener: OnNoteClickListener) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(private val binding: ItemNoteRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, position: Int) {
            binding.tvTitle.text = note.title
            binding.tvContent.text = note.content
            binding.itemNote.setBackgroundColor(
                ContextCompat.getColor(
                    binding.root.context,
                    note.color
                )
            )
            binding.root.setOnClickListener {
                listener.onNoteClick(note)
//                it.background = ContextCompat.getDrawable(binding.root.context, R.drawable.rectangle7)
//                Toast.makeText(binding.root.context, "OnClick: $position", Toast.LENGTH_SHORT).show()
            }
            binding.root.setOnLongClickListener {
                listener.onNoteLongClick(note)
                return@setOnLongClickListener true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(list[position], position)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 4 == 0 || position % 4 == 1) {
            0
        } else {
            1
        }
    }
}

