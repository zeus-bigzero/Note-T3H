package edu.t3h.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Create_Note : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var img: ImageView
    private lateinit var tvBack: TextView

    private var stepp = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        savedInstanceState?.let {
            stepp = it.getInt("step")
        }
        textView = findViewById(R.id.tvCreate2)
        img = findViewById(R.id.img1)

        textView.setOnClickListener{
            stepp++
            updateStep()
        }
        updateStep()


        tvBack = findViewById<TextView>(R.id.tvCreate1)
        tvBack.setOnClickListener{
            val intent = Intent(this, Home_screen::class.java)
            startActivity(intent)
        }
    }
    private fun updateStep() {
        if(stepp == 0) {
            textView.visibility = View.VISIBLE
            img.visibility = View.INVISIBLE
        }else if(stepp == 1){
            textView.visibility = View.VISIBLE
            img.visibility = View.VISIBLE
        }else {
            Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show()
        }
    }
}