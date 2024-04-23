package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.adapter.NoteAdapter
import edu.t3h.note.databinding.FragmentNotesBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.Note
import java.util.Date
import java.util.Locale


class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding by lazy { requireNotNull(_binding) }
    private val notes = arrayListOf<Note>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val formatter = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        binding.date.text = current
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = NoteAdapter(
                listOf(
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                    Note(
                        System.currentTimeMillis(),
                        getString(R.string.getting_started),
                        getString(R.string.lorem_ipsum)
                    ),
                ),
                object : OnNoteClickListener{
                    override fun onClickNote(note: Note) {
                        TODO("Not yet implemented")
                    }

                    override fun onLongClickNote(note: Note) {
                        TODO("Not yet implemented")
                    }
                }
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

