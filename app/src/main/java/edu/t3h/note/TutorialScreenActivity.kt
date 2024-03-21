package edu.t3h.note

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import edu.t3h.note.databinding.ActivityTutorialScreenBinding
import java.io.IOException


class TutorialScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialScreenBinding
    private val mBinding: ActivityTutorialScreenBinding by lazy { binding }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.viewPager.adapter = TutorialViewPagerAdapter(this)
        mBinding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
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

        mBinding.btnNext.setOnClickListener {
            Manager.step++
            updateStep()
        }

        mBinding.skip.setOnClickListener {
            Manager.step = 2
            updateStep()
        }

        mBinding.btnBack.setOnClickListener {
            Manager.step--
            updateStep()
        }

        updateStep()
    }

    private fun updateStep() {
        when (Manager.step) {
            0 -> {
                mBinding.tvTitle1.text = "Manage your notes easily"
                mBinding.tvTitle2.text = "A completely easy way to manage and customize your notes."
                mBinding.view1.visibility = View.VISIBLE
                mBinding.view2.visibility = View.INVISIBLE
                mBinding.view3.visibility = View.INVISIBLE
                mBinding.skip.visibility = View.VISIBLE
                mBinding.btnBack.visibility = View.INVISIBLE
                mBinding.btnNext.text = "Next"
                mBinding.viewPager.currentItem = 0
            }
            1 -> {
                mBinding.tvTitle1.text = "Organize your thougts"
                mBinding.tvTitle2.text = "Most beautiful note taking application."
                mBinding.btnNext.text = "Next"
                mBinding.view2.visibility = View.VISIBLE
                mBinding.view1.visibility = View.INVISIBLE
                mBinding.view3.visibility = View.INVISIBLE
                mBinding.skip.visibility = View.VISIBLE
                mBinding.btnBack.visibility = View.VISIBLE
                mBinding.viewPager.currentItem = 1
            }
            2 -> {
                mBinding.tvTitle1.text = "Create cards and easy styling"
                mBinding.tvTitle2.text = "Making your content legible has never been easier."
                mBinding.btnNext.text = "Get Started"
                mBinding.view3.visibility = View.VISIBLE
                mBinding.view1.visibility = View.INVISIBLE
                mBinding.view2.visibility = View.INVISIBLE
                mBinding.skip.visibility = View.INVISIBLE
                mBinding.btnBack.visibility = View.VISIBLE
                mBinding.viewPager.currentItem = 2
            }
            else -> {
                Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }

    @Throws(IOException::class)
    fun setImageFromAssets(img: ImageView, fileName: String?) {
        val ims = assets.open(fileName!!)
        val d = Drawable.createFromStream(ims, null)
        img.setImageDrawable(d)
        ims.close()
    }

}