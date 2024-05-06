package edu.t3h.note.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.t3h.note.R
import edu.t3h.note.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentHomeBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childFragmentManager.beginTransaction()
            .replace(R.id.container, NotesFragment())
            .commit()


        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.notes -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.container, NotesFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.event -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.container, EventFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.search -> {
                    childFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.create -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, CreateNoteFragment())
                        .addToBackStack(null)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}