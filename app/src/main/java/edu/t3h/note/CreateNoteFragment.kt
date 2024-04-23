package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {
    private var _binding : FragmentCreateNoteBinding? = null
    private val binding : FragmentCreateNoteBinding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnBack.setOnClickListener{
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container,HomeScreenFragment())
                    .commit()
            }
            pageBody.setOnLongClickListener {
                true
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}