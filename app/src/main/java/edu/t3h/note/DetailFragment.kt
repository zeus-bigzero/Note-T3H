package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentDetailBinding
import edu.t3h.note.model.Note

class DetailFragment(private val note: Note) : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.pageContent.setText(note.content)
        binding.pageTitle.setText(note.title)
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack("Note", 1)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}