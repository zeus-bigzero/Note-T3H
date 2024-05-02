package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.t3h.note.controller.Manager
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
            btnSave.setOnClickListener{
                if (binding.pageTitle.text.isNullOrEmpty() || binding.pageBody.text.isNullOrEmpty()){
                    Toast.makeText(requireContext(),"Vui lòng nhập đầy đủ Tiêu Đề và Nội Dung",Toast.LENGTH_SHORT).show()
                } else {
                    Manager.des = binding.pageBody.text.toString()
                    Manager.title = binding.pageTitle.text.toString()
                    binding.pageBody.text = null
                    binding.pageTitle.text = null
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container,HomeScreenFragment())
                        .commit()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}