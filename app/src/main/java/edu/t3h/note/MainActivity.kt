package edu.t3h.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.children
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.databinding.ActivityMainBinding
import edu.t3h.note.listener.OnNoteClickListener
import edu.t3h.note.model.Note

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mBinding: ActivityMainBinding by lazy { binding }

    private val notes = arrayListOf<Note>()
    private val adapter: NoteAdapter by lazy {
        NoteAdapter(
            notes,
            object : OnNoteClickListener {
                override fun onClickNote(note: Note) {
                    Toast.makeText(this@MainActivity, "OnClick Note = ${note.id}", Toast.LENGTH_SHORT).show()
                }

                override fun onLongClickNote(note: Note) {
                    Toast.makeText(this@MainActivity, "OnLongClick Note = ${note.id}", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        notes.addAll(
            listOf(
                Note(
                    title = "Getting Started",
                    des = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.Nisi, consectetur elementum."
                ), Note(
                    title = "Getting Started",
                    des = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas sed diam cum ligula justo.Nisi, consectetur elementum."
                )
            )
        )
        mBinding.recyclerView.apply {
            adapter = this@MainActivity.adapter
        }

        mBinding.btnAddNote.setOnClickListener {
            // thực hiện công việc: Tạo 1 đối tượng Note mới
            // add vào danh sách cũ
            // hiển thị lên đầu danh sách trên màn hình.

            val note = Note(id = System.currentTimeMillis(), title = "T3H", des = "Welcome LAND2311")
            notes.add(0, note) // add vào vị trí nào? vào cuối? vàoầu

            adapter.notifyDataSetChanged()
        }
    }
}
