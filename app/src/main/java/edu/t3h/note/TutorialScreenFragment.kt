package edu.t3h.note

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import edu.t3h.note.adapter.TutorialViewPagerAdapter
import edu.t3h.note.controller.Manager
import edu.t3h.note.databinding.FragmentTutorialScreenBinding


class TutorialScreenFragment : Fragment() {

    private var _binding: FragmentTutorialScreenBinding? = null
    private val binding: FragmentTutorialScreenBinding by lazy { requireNotNull(_binding) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTutorialScreenBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.apply {
            adapter = TutorialViewPagerAdapter()
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    when (position) {
                        0 -> {
                            Manager.step = 0
                            updateStep()
                        }
                        1 -> {
                            Manager.step = 1
                            updateStep()
                        }
                        else -> {
                            Manager.step = 2
                            updateStep()
                        }
                    }
                }
            })
        }

        binding.btnNext.setOnClickListener {
            Manager.step++
            updateStep()
        }

        binding.skip.setOnClickListener {
            Manager.step = 2
            updateStep()
        }

        binding.btnBack.setOnClickListener {
            Manager.step--
            updateStep()
        }
        updateStep()
    }

    private fun updateStep() {
        when (Manager.step) {
            0 -> {
                binding.apply {
                    tvTitle1.text = getString(R.string.tuto_1_title_1)
                    tvTitle2.text = getString(R.string.tuto_1_title_2)
                    view1.visibility = View.VISIBLE
                    view2.visibility = View.INVISIBLE
                    view3.visibility = View.INVISIBLE
                    skip.visibility = View.VISIBLE
                    btnBack.visibility = View.INVISIBLE
                    btnNext.text = getString(R.string.next)
                    viewPager.currentItem = 0
                }
            }
            1 -> {
                binding.apply {
                    tvTitle1.text = getString(R.string.tuto_2_title_1)
                    tvTitle2.text = getString(R.string.tuto_2_title_2)
                    btnNext.text = getString(R.string.next)
                    view2.visibility = View.VISIBLE
                    view1.visibility = View.INVISIBLE
                    view3.visibility = View.INVISIBLE
                    skip.visibility = View.VISIBLE
                    btnBack.visibility = View.VISIBLE
                    viewPager.currentItem = 1
                }
            }
            2 -> {
                binding.apply {
                    tvTitle1.text = getString(R.string.tuto_3_title_1)
                    tvTitle2.text = getString(R.string.tuto_3_title_1)
                    btnNext.text = getString(R.string.getting_started)
                    view3.visibility = View.VISIBLE
                    view1.visibility = View.INVISIBLE
                    view2.visibility = View.INVISIBLE
                    skip.visibility = View.INVISIBLE
                    btnBack.visibility = View.VISIBLE
                    viewPager.currentItem = 2
                }
            }
            else -> {
                val sharedPref = activity?.getSharedPreferences("appData", Context.MODE_PRIVATE)
                sharedPref?.edit()?.putBoolean("isTutorialFinish", false)?.apply()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container,HomeScreenFragment())
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}