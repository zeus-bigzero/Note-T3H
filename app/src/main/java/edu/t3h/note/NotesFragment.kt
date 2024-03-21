package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import edu.t3h.note.databinding.FragmentNotesBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.Note

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding get() = requireNotNull(_binding)

    private val notes = arrayListOf<Note>()
    private val adapter: NotesAdapter by lazy {
        NotesAdapter(notes, object : OnNoteClickListener {
            override fun onNoteClick(note: Note) {
                Toast.makeText(binding.root.context, "OnClick: ${note.title}", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onNoteLongClick(note: Note) {
                Toast.makeText(
                    binding.root.context,
                    "OnLongClick: ${note.title}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        notes.addAll(getList())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.noteRv) {
            layoutManager = GridLayoutManager(context, 2).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return when (adapter?.getItemViewType(position)) {
                            0 -> 1
                            else -> 2
                        }
                    }
                }
            }
            adapter = this@NotesFragment.adapter
        }

        binding.allnotes.setOnClickListener {
            for (note in notes) {
                note.color = R.color.allNotes
            }
            adapter.notifyDataSetChanged()
        }


        binding.favourite.setOnClickListener {
            for (note in notes) {
                note.color = R.color.favorites
            }
            adapter.notifyDataSetChanged()
        }


        binding.hidden.setOnClickListener {
            for (note in notes) {
                note.color = R.color.hidden
            }
            adapter.notifyDataSetChanged()
        }


        binding.trash.setOnClickListener {
            for (note in notes) {
                note.color = R.color.trash
            }
            adapter.notifyDataSetChanged()
        }
    }

    private fun getList(): List<Note> {
        return listOf(
            Note(
                "Getting Started",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.\n" +
                        "Nisi, consectetur\n" +
                        "\n" +
                        "elementum."
            ),
            Note(
                "UX Design",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.\n" +
                        "Nisi, consectetur\n" +
                        "\n" +
                        "elementum."
            ),
            Note(
                "Important",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo."
            ),
            Note(
                "Important",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo."
            ),
            Note(
                "Important",
                "Lorem ipsum dolor sit amet, consectetur ."
            ),
            Note(
                "Important",
                "Lorem ipsum dolor sit amet, consectetur ."
            ),
            Note(
                "Getting Started",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.\n" +
                        "Nisi, consectetur\n" +
                        "\n" +
                        "elementum."
            ),
            Note(
                "UX Design",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.\n" +
                        "Nisi, consectetur\n" +
                        "\n" +
                        "elementum."
            )
        )
    }

    //cách 2 sử dụng listener
//    private val a = object : OnNoteClickListener {
//        override fun onNoteClick(note: Note) {
//            Toast.makeText(context, "OnClick ${note.title}", Toast.LENGTH_SHORT).show()
//        }
//
//        override fun onNoteLongClick(note: Note) {
//            Toast.makeText(context, "OnLongClick ${note.title}", Toast.LENGTH_SHORT).show()
//        }
//    }

    //cách 3 sử dụng listener
//    fun b(): OnNoteClickListener {
//        return object : OnNoteClickListener {
//            override fun onNoteClick(note: Note) {
//                Toast.makeText(context, "OnClick ${note.title}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNoteLongClick(note: Note) {
//                Toast.makeText(context, "OnLongClick ${note.title}", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
}