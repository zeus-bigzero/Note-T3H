package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class ThirdIntroFrame:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_thirdintroframe)

        findViewById<CardView>(R.id.btnStartThird).setOnClickListener {
            startActivity(Intent(this, HomeScreen::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide1Third).setOnClickListener {
            startActivity(Intent(this, FirstIntroFrame::class.java))
            finish()
        }
        findViewById<View>(R.id.btnBackThird).setOnClickListener {
            startActivity(Intent(this, SecondIntroFrame::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide2Third).setOnClickListener {
            startActivity(Intent(this, SecondIntroFrame::class.java))
            finish()
        }
    }
}