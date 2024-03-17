package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.FragmentHomescreenBinding
import java.util.Date
import java.util.Locale


class HomeScreenFragment : Fragment() {
    private var binding: FragmentHomescreenBinding? = null
    private val mBinding: FragmentHomescreenBinding
        get() = requireNotNull(binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomescreenBinding.inflate(inflater, container, false)
        val formatter = SimpleDateFormat("dd MMMM, YYYY", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        mBinding.date.text = current
        return mBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}

