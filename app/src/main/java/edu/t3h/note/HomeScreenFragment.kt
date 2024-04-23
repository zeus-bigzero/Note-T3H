package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.adapter.NoteAdapter
import edu.t3h.note.databinding.FragmentHomeScreenBinding
import edu.t3h.note.listener.OnNoteClickLisatener
import edu.t3h.note.model.Note
import java.util.Date
import java.util.Locale


class HomeScreenFragment : Fragment() {
    private lateinit var binding: FragmentHomeScreenBinding
    private val mBinding: FragmentHomeScreenBinding by lazy { binding }
    private val notes = arrayListOf<Note>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val formatter = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        mBinding.date.text = current


        mBinding.recyclerView.apply {
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
                object : OnNoteClickLisatener{
                    override fun onClickNote(note: Note) {
                        TODO("Not yet implemented")
                    }

                    override fun onLongClickNote(note: Note) {
                        TODO("Not yet implemented")
                    }
                }
            )
        }
        return mBinding.root
    }
}

