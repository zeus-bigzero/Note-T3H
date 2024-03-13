package edu.t3h.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Home_screen : AppCompatActivity() {
    private lateinit var createNote: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)


        createNote = findViewById<ImageView>(R.id.img1)
        createNote.setOnClickListener{
            val intent = Intent(this, Create_Note::class.java)
            startActivity(intent)
        }
    }
}