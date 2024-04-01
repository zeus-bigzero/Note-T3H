package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
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
//                    Toast.makeText(this, "Notes Screen", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.event -> {
//                    Toast.makeText(this, "Event Screen", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.search -> {
//                    Toast.makeText(this, "Search Screen", Toast.LENGTH_SHORT).show()
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
}