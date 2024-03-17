package edu.t3h.note


import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.children


class MainActivity : AppCompatActivity() {

    // region
    private lateinit var img: ImageView
    private lateinit var title1: TextView
    private lateinit var title2: TextView
    private lateinit var tvBack: TextView
    private lateinit var tvSkip: TextView

    private lateinit var btnNext: CardView

    private lateinit var view1: View
    private lateinit var view2: View
    private lateinit var view3: View

    // endregion

    // region
    private var step = 0

    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            step = it.getInt("step")
        }

        img = findViewById(R.id.img)
        title1 = findViewById(R.id.tVtitle1)
        title2 = findViewById(R.id.tVtitle2)
        btnNext = findViewById(R.id.btnNext)
        tvBack = findViewById(R.id.tvBack)
        tvSkip = findViewById(R.id.tvSkip)

        view1 = findViewById(R.id.view1)
        view2 = findViewById(R.id.view2)
        view3 = findViewById(R.id.view3)


        tvSkip.setOnClickListener{
            step++
            updateStep()
        }
        btnNext.setOnClickListener{
            step++
            updateStep()
        }
        updateStep()
    }
    private fun updateStep() {
        if(step == 0) {
            img.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.tuto01))
            title1.setText("Manage your notes easily")
            title2.setText("A completely easy way to manage and customize your notes.")
            view1.visibility = View.VISIBLE
            view2.visibility = View.INVISIBLE
            view3.visibility = View.INVISIBLE
            tvBack.visibility = View.INVISIBLE
        }else if(step == 1){
            img.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.tuto02))
            title1.setText("Organize your thougts")
            title2.setText("Most beautiful not taking application your notes.")
            view1.visibility = View.INVISIBLE
            view2.visibility = View.VISIBLE
            view3.visibility = View.INVISIBLE
            tvBack.visibility = View.VISIBLE
        }else if(step == 2){
            img.setImageBitmap(BitmapFactory.decodeResource(resources, R.drawable.tuto03))
            title1.setText("Create cards and easy styling")
            title2.setText("Making your content legible has never been easier.")
            view1.visibility = View.INVISIBLE
            view2.visibility = View.INVISIBLE
            view3.visibility = View.VISIBLE
            tvBack.visibility = View.VISIBLE
            btnNext.children.forEach {
                (it as? TextView)?.text = "Get started"
            }
        }else {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("step", step)
        Log.d("TAGs", "step 2 = $step")
        super.onSaveInstanceState(outState)

    }
}
