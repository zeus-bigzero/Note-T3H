package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding: FragmentHomeScreenBinding by lazy { requireNotNull(_binding) }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        replaceFragment(NotesFragment())
        binding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_notes -> {
                    replaceFragment(NotesFragment())
                    true
                }
                R.id.navigation_event -> {
                    replaceFragment(EventsFragment())
                    true
                }
                R.id.navigation_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.navigation_createNote -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container,CreateNoteFragment())
                        .commit()
                    true
                } else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        childFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}