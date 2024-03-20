package edu.t3h.note

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        val binding: ItemNoteBinding =
            ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.bind(note, position)
    }

    inner class NoteViewHolder(private val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note, position: Int) {
            binding.tvTitle.text = note.title
            binding.tvDes.text = note.des

            binding.root.setOnClickListener {
                listener.onClickNote(note)
            }
            binding.root.setOnLongClickListener {
                listener.onLongClickNote(note)
                return@setOnLongClickListener true
            }
        }
    }
}

//có những bài toán, sẽ có nhiều file layout.
//=> Cách giải quyết:
//- Các bạn tạo nhiều file viewHolder:
//Mỗi 1 class ViewHolder === 1 file item_view

