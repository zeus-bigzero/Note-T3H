package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var searchBar: EditText
    private lateinit var allNotes: LinearLayout
    private lateinit var favourite: LinearLayout
    private lateinit var hidden: LinearLayout
    private lateinit var trash: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initViews()

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.notes -> {
                    Toast.makeText(this, "Notes Screen", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.event -> {
                    Toast.makeText(this, "Event Screen", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.search -> {
                    Toast.makeText(this, "Search Screen", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.create -> {
                    val intent = Intent(this, CreateNote::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.bottom_navigation)
        searchBar = findViewById(R.id.search_txt)
        allNotes = findViewById(R.id.allnotes)
        favourite = findViewById(R.id.favourite)
        hidden = findViewById(R.id.hidden)
        trash = findViewById(R.id.trash)
    }
}