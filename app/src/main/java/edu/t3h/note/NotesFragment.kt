package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.databinding.FragmentNotesBinding
import edu.t3h.note.model.Note

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding: FragmentNotesBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = getList()
        binding.noteRv.apply {
            for (i in list.indices){
                layoutManager = if (i % 3 == 1){
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }else{
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                }
            }

            adapter = NotesAdapter(list)
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
            )
        )
    }
}