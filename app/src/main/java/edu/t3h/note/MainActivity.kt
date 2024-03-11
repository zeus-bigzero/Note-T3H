package edu.t3h.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    // region -> UI Components

    private lateinit var img: ImageView
    private lateinit var title1: TextView
    private lateinit var title2: TextView

    private lateinit var view1: View
    private lateinit var view2: View
    private lateinit var view3: View

    private lateinit var btnNext: CardView

    // endregion

    // region -> variables

    private var step = 0

    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            Log.d("TAGs", "${it.getInt("step")}")
            step = it.getInt("step")
        }

        img = findViewById(R.id.img)
        title1 = findViewById(R.id.tvTitle1)
        title2 = findViewById(R.id.tvTitle2)
        btnNext = findViewById(R.id.btnNext)

        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)

        btnNext.setOnClickListener {
            step++
            updateStep()
        }

        updateStep()
    }

    private fun updateStep() {
        if (step == 0) {
            img.setImageResource(R.drawable.tuto_01)
            title1.setText("Manage your notes easily")
            title2.text = "A completely easy way to manage and customize your notes."
            view1.visibility = View.VISIBLE
            view2.visibility = View.INVISIBLE
            view3.visibility = View.INVISIBLE
        } else if (step == 1) {
            img.setImageResource(R.drawable.tuto_02)
            title1.setText("Organize your thougts")
            title2.text = "Most beautiful note taking application."

            view2.visibility = View.VISIBLE
            view1.visibility = View.INVISIBLE
            view3.visibility = View.INVISIBLE
        } else if (step == 2) {
            img.setImageResource(R.drawable.tuto_03)
            title1.setText("Create cards and easy styling")
            title2.text = "Making your content legible has never been easier."

            btnNext.children.forEach {
                (it as? TextView)?.text = "Get Started"
            }

            view3.visibility = View.VISIBLE
            view1.visibility = View.INVISIBLE
            view2.visibility = View.INVISIBLE
        } else {
            Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("step", step)
        Log.d("TAGs", "step 2 = $step")
        super.onSaveInstanceState(outState)
    }


}