package edu.t3h.note.ui

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentCreateNoteBinding

class CreateNoteFragment : Fragment() {

    private var _binding: FragmentCreateNoteBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val requestGalleryResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if (it != null && it.resultCode == RESULT_OK){
            binding.image.setImageURI(it.data?.data)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateNoteBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.root.setOnLongClickListener {
            openGallery()
            true
        }
    }

    private fun openGallery(){
        val i = Intent()
        i.type = "image/*"
        i.action = Intent.ACTION_GET_CONTENT
        requestGalleryResult.launch(i)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}