package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import edu.t3h.note.adapter.NoteAdapter
import edu.t3h.note.databinding.FragmentNotesBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.NoteModel
import edu.t3h.note.model.convertStringToNoteModel
import java.io.BufferedReader
import java.io.FileInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.Date
import java.util.Locale


class NotesFragment : Fragment() {
    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding by lazy { requireNotNull(_binding) }

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

        val fis: FileInputStream = requireContext().openFileInput("notes_data.txt")
        val inputStreamReader = InputStreamReader(fis, StandardCharsets.UTF_8)
        val stringBuilder = StringBuilder()
        val list = arrayListOf<NoteModel>()
        try {
            BufferedReader(inputStreamReader).use { reader ->
                var line : String? = reader.readLine()
                while (line != null) {
                    stringBuilder.append(line).append('\n')
                    val model = line.convertStringToNoteModel()
                    list.add(model)
                    line = reader.readLine()
                }
            }
        } catch (e: IOException) {
            // Error occurred when opening raw file for reading.
        } finally {
        }

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2). apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (adapter?.getItemViewType(position) == 0) {1} else {2}
                    }
                }
            }
            adapter = NoteAdapter(
                list,
                object : OnNoteClickListener{
                    override fun onClickNote(note: NoteModel) {
                        TODO("Not yet implemented")
                    }

                    override fun onLongClickNote(note: NoteModel) {
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

