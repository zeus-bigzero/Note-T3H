package edu.t3h.note

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreateNote : AppCompatActivity() {

    //region -> UI Components
    private lateinit var btnBack: ImageView
    private lateinit var txtBack: TextView
    private lateinit var btnSave: TextView
    private lateinit var title: EditText
    private lateinit var content: EditText
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        initViews()

    }

    private fun initViews() {
        btnBack = findViewById(R.id.btn_back)
        txtBack = findViewById(R.id.back_txt)
        btnSave = findViewById(R.id.btn_save)
        title = findViewById(R.id.pageTitle)
        content = findViewById(R.id.pageContent)
    }
}