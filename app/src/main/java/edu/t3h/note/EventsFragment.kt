package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.adapter.EventsAdapter
import edu.t3h.note.databinding.FragmentEventsBinding
import java.util.Date
import java.util.Locale

class EventsFragment : Fragment() {
    private var _binding : FragmentEventsBinding? = null
    private val binding : FragmentEventsBinding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEventsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dateFormater = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
        val date = Date()
        val currentDate = dateFormater.format(date)
        binding.date.text = currentDate
        binding.rvEvent.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = EventsAdapter()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}