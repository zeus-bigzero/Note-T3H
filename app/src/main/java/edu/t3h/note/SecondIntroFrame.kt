package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class SecondIntroFrame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_secondintroframe)

        findViewById<View>(R.id.tvSkipSecond).setOnClickListener {
            startActivity(Intent(this, ThirdIntroFrame::class.java))
            finish()
        }
        findViewById<CardView>(R.id.btnNextSecond).setOnClickListener {
            startActivity(Intent(this, ThirdIntroFrame::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide1Second).setOnClickListener {
            startActivity(Intent(this, FirstIntroFrame::class.java))
            finish()
        }
        findViewById<View>(R.id.btnBackSecond).setOnClickListener {
            startActivity(Intent(this, FirstIntroFrame::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide3Second).setOnClickListener {
            startActivity(Intent(this, ThirdIntroFrame::class.java))
            finish()
        }
    }
}