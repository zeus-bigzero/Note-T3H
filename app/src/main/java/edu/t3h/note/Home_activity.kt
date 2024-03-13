package edu.t3h.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Home_activity : AppCompatActivity() {
    private lateinit var create: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        create = findViewById(R.id.menu_create)
        create.setOnClickListener{
            startActivity(Intent(this, CreateNote::class.java ))
        }
    }
}