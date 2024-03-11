package edu.t3h.note

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class File2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note2)


        val v3 = findViewById<View>(R.id.v3)
        val button2 = findViewById<Button>(R.id.n2)
        val skipText = findViewById<TextView>(R.id.tv1)

        val backText1 = findViewById<TextView>(R.id.tv2)
        val backText2 = findViewById<ImageView>(R.id.im2)

        button2.setOnClickListener {
            val intent = Intent(this, File3Activity::class.java)
            startActivity(intent)

            /*v3.setOnClickListener {
                val color = Color.parseColor("#3A85F7")
                v3.setBackgroundColor(color)
            }*/
        }
        skipText.setOnClickListener {
            val intent = Intent(this, File3Activity::class.java)
            startActivity(intent)
        }

        backText1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        backText2.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}