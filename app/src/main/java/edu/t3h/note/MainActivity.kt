package edu.t3h.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import edu.t3h.note.adapter.NoteAdapter
import edu.t3h.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding by lazy {
        requireNotNull(_binding)
    }

    private val notes = arrayListOf<Note>()

    private val adapter: NoteAdapter by lazy {
        NoteAdapter(notes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))
        notes.add(Note(System.currentTimeMillis().toString(), "asdasda", "asdasda"))

        with(binding.recyclerView) {
            layoutManager = GridLayoutManager(this@MainActivity, 3).apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        if (position % 5 == 0 || position % 5 == 1) {
                            return 1
                        }
                        return 2
                    }

                }
            }
            adapter = this@MainActivity.adapter
        }

        binding.navigationView.setOnNavigationItemSelectedListener {
            Log.d("3IGZEUS", "it = ${it.itemId}")
            true
        }

        binding.navigationView.setOnItemSelectedListener {
            Log.d("3IGZEUS", "it v3 = ${it.itemId}")
            true
        }

        binding.navigationView.setOnClickListener {
            Log.d("3IGZEUS", "it v2 = ${ binding.navigationView.selectedItemId}")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}