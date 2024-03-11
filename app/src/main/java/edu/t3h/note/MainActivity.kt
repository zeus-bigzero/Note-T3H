package edu.t3h.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note1)

        val v1 = findViewById<View>(R.id.v1)
        val v2 = findViewById<View>(R.id.v2)
        val v3 = findViewById<View>(R.id.v3)
        val button1 = findViewById<Button>(R.id.n1)
        val skipText = findViewById<TextView>(R.id.tv1)

        button1.setOnClickListener {
            val intent = Intent(this, File2Activity::class.java)
            startActivity(intent)

            /* val color = Color.parseColor("#3A85F7")
             v1.setBackgroundColor(color)*/
        }

        skipText.setOnClickListener {
            val intent = Intent(this, File2Activity::class.java)
            startActivity(intent)
        }

    }
}