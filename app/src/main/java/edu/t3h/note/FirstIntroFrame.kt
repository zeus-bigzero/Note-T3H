package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FirstIntroFrame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_firstintroframe)

        findViewById<View>(R.id.tvSkipFirst).setOnClickListener {
            startActivity(Intent(this, ThirdIntroFrame::class.java))
            finish()
        }
        findViewById<CardView>(R.id.btnNextFirst).setOnClickListener {
            startActivity(Intent(this, SecondIntroFrame::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide2First).setOnClickListener {
            startActivity(Intent(this, SecondIntroFrame::class.java))
            finish()
        }
        findViewById<Button>(R.id.btnSlide3First).setOnClickListener {
            startActivity(Intent(this, ThirdIntroFrame::class.java))
            finish()
        }
    }
}