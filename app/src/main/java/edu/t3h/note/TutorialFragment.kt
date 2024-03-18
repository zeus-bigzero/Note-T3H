package edu.t3h.note

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import edu.t3h.note.databinding.FragmentTutorialBinding

class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorialBinding? = null
    private val binding: FragmentTutorialBinding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorialBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = TutorialAdapter()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                updateUi(position)
                if (position == 2) {
                    binding.nextbtn.setOnClickListener {
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.container, HomeFragment())
                            .commit()
                    }
                }
            }
        })
    }

    private fun updateUi(step: Int) {
        when (step) {
            0 -> {
                binding.title1.setText(R.string.title1)
                binding.description1.setText(R.string.description1)
                binding.nextbtn.setText(R.string.next)
                binding.skiptxt.visibility = TextView.VISIBLE
                binding.btnBack.visibility = ImageView.GONE
                binding.backtxt.visibility = TextView.GONE
                binding.slider1.setImageResource(R.drawable.rectangle)
                binding.slider2.setImageResource(R.drawable.rectangle3)
                binding.slider3.setImageResource(R.drawable.rectangle3)
            }

            1 -> {
                binding.title1.setText(R.string.title2)
                binding.description1.setText(R.string.description2)
                binding.nextbtn.setText(R.string.next)
                binding.skiptxt.visibility = TextView.VISIBLE
                binding.btnBack.visibility = ImageView.VISIBLE
                binding.backtxt.visibility = TextView.VISIBLE
                binding.slider1.setImageResource(R.drawable.rectangle3)
                binding.slider2.setImageResource(R.drawable.rectangle)
                binding.slider3.setImageResource(R.drawable.rectangle3)
            }

            2 -> {
                binding.title1.setText(R.string.title3)
                binding.description1.setText(R.string.description3)
                binding.skiptxt.visibility = TextView.GONE
                binding.nextbtn.setText(R.string.start)
                binding.slider1.setImageResource(R.drawable.rectangle3)
                binding.slider2.setImageResource(R.drawable.rectangle3)
                binding.slider3.setImageResource(R.drawable.rectangle)
            }
        }
    }
}