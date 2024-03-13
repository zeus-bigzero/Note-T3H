package edu.t3h.note

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Date
import java.util.Locale


class HomeScreen:AppCompatActivity() {
    private lateinit var day : TextView
    private lateinit var createNoteBtn : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_homescreen)

        day = findViewById(R.id.date)
        val formatter = SimpleDateFormat("dd MMMM, YYYY", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        day.text = current

        createNoteBtn = findViewById(R.id.menuCreateNote)
        createNoteBtn.setOnClickListener{
            startActivity(Intent(this, CreateNote::class.java))
            finish()
        }
    }
}