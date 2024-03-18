package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.databinding.FragmentHomeScreenBinding
import edu.t3h.note.model.Note
import java.util.Date
import java.util.Locale


class HomeScreenFragment : Fragment() {
    private var binding: FragmentHomeScreenBinding? = null
    private val mBinding: FragmentHomeScreenBinding
        get() = requireNotNull(binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        val formatter = SimpleDateFormat("dd MMMM, yyyy", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        mBinding.date.text = current

        mBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(context,1, LinearLayoutManager.VERTICAL,false)
            adapter = NoteAdapter(
                listOf(
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                    Note(getString(R.string.getting_started), getString(R.string.lorem_ipsum)),
                )
            )
        }
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

