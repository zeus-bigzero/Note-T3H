package edu.t3h.note.ui

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import edu.t3h.note.Manager
import edu.t3h.note.R
import edu.t3h.note.adapter.TutorialAdapter
import edu.t3h.note.databinding.FragmentTutorialBinding

class TutorialFragment : Fragment() {

    private var _binding: FragmentTutorialBinding? = null
    private val binding: FragmentTutorialBinding get() = requireNotNull(_binding)

    private val permissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        listOf(
            android.Manifest.permission.READ_MEDIA_VIDEO,
            android.Manifest.permission.READ_MEDIA_IMAGES,
            android.Manifest.permission.READ_MEDIA_AUDIO,
        )
    } else {
        listOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
    }

    private val requestMultiplePermissionsResult =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) {
            if (isGranted(permissions)) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment())
                    .commit()
            }else{
                Toast.makeText(requireContext(), "Please allow permission", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            FragmentTutorialBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.viewPager) {
            adapter = TutorialAdapter()
            offscreenPageLimit = 2
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Manager.step = position
                    updateUi(position)
                }
            })

        }

        binding.nextbtn.setOnClickListener {
            if (binding.viewPager.currentItem < 2) {
                binding.viewPager.currentItem++
            } else {
                if (isGranted(permissions)) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, HomeFragment())
                        .commit()
                } else {
                    requestMultiplePermissionsResult.launch(permissions.toTypedArray())
                }
            }
        }

        binding.skiptxt.setOnClickListener {
            binding.viewPager.currentItem++
        }

        binding.btnBack.setOnClickListener {
            binding.viewPager.currentItem--
        }

        updateUi(Manager.step)
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


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun isGranted(permissions: List<String>): Boolean {
        for (permission in permissions) {
            if (isDenied(permission)) {
                return false
            }
        }
        return true
    }

    private fun isDenied(permission: String): Boolean {
        return !isGranted(permission)
    }

    private fun isGranted(permission: String): Boolean {
        return ContextCompat.checkSelfPermission(
            this.requireContext(),
            permission
        ) == PackageManager.PERMISSION_GRANTED
    }
//    override fun onDestroy() {
//        super.onDestroy()
//        binding.viewPager.unregisterOnPageChangeCallback(object :
//            ViewPager2.OnPageChangeCallback() {})
//    }
}