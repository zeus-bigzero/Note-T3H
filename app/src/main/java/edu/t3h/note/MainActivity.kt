package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //region -> UI Components
    private lateinit var img: ImageView
    private lateinit var title1: TextView
    private lateinit var title2: TextView
    private lateinit var btnBack: ImageView
    private lateinit var txtBack: TextView
    private lateinit var btnSkip: TextView
    private lateinit var btnNext: TextView
    private lateinit var slider1: ImageView
    private lateinit var slider2: ImageView
    private lateinit var slider3: ImageView
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnNext.setOnClickListener {
            actionNext()
        }

        btnSkip.setOnClickListener {
            actionNext()
        }

        arrayOf(slider1, slider2, slider3).forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                Manager.step = index
                updateUi(index)
            }
        }

        btnBack.setOnClickListener {
            Manager.step--
            updateUi(Manager.step)
        }

        updateUi(Manager.step)
    }

    private fun initViews() {
        img = findViewById(R.id.img)
        title1 = findViewById(R.id.title1)
        title2 = findViewById(R.id.description1)
        btnBack = findViewById(R.id.btn_back)
        txtBack = findViewById(R.id.backtxt)
        btnSkip = findViewById(R.id.skiptxt)
        btnNext = findViewById(R.id.nextbtn)
        slider1 = findViewById(R.id.slider1)
        slider2 = findViewById(R.id.slider2)
        slider3 = findViewById(R.id.slider3)
    }

    private fun updateUi(step: Int) {
        when (step) {
            0 -> {
                img.setImageResource(R.drawable.splash1)
                title1.setText(R.string.title1)
                title2.setText(R.string.description1)
                btnNext.setText(R.string.next)
                btnSkip.visibility = TextView.VISIBLE
                btnBack.visibility = ImageView.GONE
                txtBack.visibility = TextView.GONE
                slider1.setImageResource(R.drawable.rectangle)
                slider2.setImageResource(R.drawable.rectangle3)
                slider3.setImageResource(R.drawable.rectangle3)
            }

            1 -> {
                img.setImageResource(R.drawable.splash2)
                title1.setText(R.string.title2)
                title2.setText(R.string.description2)
                btnBack.visibility = ImageView.VISIBLE
                txtBack.visibility = TextView.VISIBLE
                btnNext.setText(R.string.next)
                btnSkip.visibility = TextView.VISIBLE
                slider1.setImageResource(R.drawable.rectangle3)
                slider2.setImageResource(R.drawable.rectangle)
                slider3.setImageResource(R.drawable.rectangle3)
            }

            2 -> {
                img.setImageResource(R.drawable.splash3)
                title1.setText(R.string.title3)
                title2.setText(R.string.description3)
                btnSkip.visibility = TextView.GONE
                btnNext.setText(R.string.start)
                slider1.setImageResource(R.drawable.rectangle3)
                slider2.setImageResource(R.drawable.rectangle3)
                slider3.setImageResource(R.drawable.rectangle)
            }
        }
    }

    private fun actionNext() {
        if (Manager.step < 2) {
            Manager.step++
            updateUi(Manager.step)
        } else {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}