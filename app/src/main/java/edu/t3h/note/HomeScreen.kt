package edu.t3h.note

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Date
import java.util.Locale


class HomeScreen:AppCompatActivity() {
    private lateinit var day : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_homescreen)

        day = findViewById(R.id.date)
        val formatter = SimpleDateFormat("dd MMMM, YYYY", Locale.ENGLISH)
        val date = Date()
        val current = formatter.format(date)
        day.text = "$current"
    }
}