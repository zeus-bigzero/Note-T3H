package edu.t3h.note

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import java.io.IOException


class MainActivity : AppCompatActivity() {

    // region -> UI Components

    private lateinit var img: ImageView
    private lateinit var title1: TextView
    private lateinit var title2: TextView
    private lateinit var view1: View
    private lateinit var view2: View
    private lateinit var view3: View
    private lateinit var btnNext: TextView
    private lateinit var skip: TextView
    private lateinit var btnBack: LinearLayoutCompat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        img = findViewById(R.id.img)
        title1 = findViewById(R.id.tvTitle1)
        title2 = findViewById(R.id.tvTitle2)
        btnNext = findViewById(R.id.btnNext)

        skip = findViewById(R.id.skip)
        btnBack = findViewById(R.id.btnBack)

        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)

        btnNext.setOnClickListener {
            Manager.step++
            updateStep()
        }

        skip.setOnClickListener {
            Manager.step = 2
            updateStep()
        }

        btnBack.setOnClickListener {
            Manager.step--
            updateStep()
        }

        updateStep()
    }

    private fun updateStep() {
        if (Manager.step == 0) {
            setImageFromAssets(img, "tuto_01.png")
            title1.setText("Manage your notes easily")
            title2.text = "A completely easy way to manage and customize your notes."
            view1.visibility = View.VISIBLE
            view2.visibility = View.INVISIBLE
            view3.visibility = View.INVISIBLE
            skip.visibility = View.VISIBLE
            btnBack.visibility = View.INVISIBLE
            btnNext.setText("Next")
        } else if (Manager.step == 1) {
            setImageFromAssets(img, "tuto_02.png")
            title1.setText("Organize your thougts")
            title2.text = "Most beautiful note taking application."
            btnNext.setText("Next")
            view2.visibility = View.VISIBLE
            view1.visibility = View.INVISIBLE
            view3.visibility = View.INVISIBLE
            skip.visibility = View.VISIBLE
            btnBack.visibility = View.VISIBLE


        } else if (Manager.step == 2) {
            setImageFromAssets(img, "tuto_03.png")
            title1.setText("Create cards and easy styling")
            title2.text = "Making your content legible has never been easier."

            btnNext.setText("Get Started")

            view3.visibility = View.VISIBLE
            view1.visibility = View.INVISIBLE
            view2.visibility = View.INVISIBLE

            skip.visibility = View.INVISIBLE
            btnBack.visibility = View.VISIBLE
        } else {
            Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, HomeScreen::class.java))
            finish()
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