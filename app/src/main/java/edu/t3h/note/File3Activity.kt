package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class File3Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note3)

        val button3 = findViewById<Button>(R.id.n3)

        val backText1 = findViewById<TextView>(R.id.tv1)
        val backText2 = findViewById<ImageView>(R.id.im2)

        button3.setOnClickListener {
            val intent = Intent(this, MainActivityHome::class.java)
            startActivity(intent)
        }

        backText1.setOnClickListener {
            val intent = Intent(this, File2Activity::class.java)
            startActivity(intent)
        }
        backText2.setOnClickListener {
            val intent = Intent(this, File2Activity::class.java)
            startActivity(intent)
        }
    }
}