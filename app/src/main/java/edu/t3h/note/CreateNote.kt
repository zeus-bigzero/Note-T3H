package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat

class CreateNote : AppCompatActivity() {
    private lateinit var pageTitle : EditText
    private lateinit var pagebody : EditText
    private lateinit var btnSave : TextView
    private lateinit var btnBack : LinearLayoutCompat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_create_note)

        pageTitle = findViewById(R.id.pageTitle)
        pagebody = findViewById(R.id.pageBody)
        btnSave = findViewById(R.id.btnSave)
        btnBack = findViewById(R.id.btnBack)

        btnSave.setOnClickListener{
            Manager.title = pageTitle.text.toString()
            Manager.body = pagebody.text.toString()
        }

        btnBack.setOnClickListener {
            Toast.makeText(this, Manager.title, Toast.LENGTH_LONG).show()
            Toast.makeText(this, Manager.body, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, HomeScreenFragment::class.java))
            finish()
        }
    }
}