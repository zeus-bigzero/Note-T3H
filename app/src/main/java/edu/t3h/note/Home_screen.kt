package edu.t3h.note

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.t3h.note.databinding.ActiviteHomeScreenBinding
import edu.t3h.note.databinding.ActivityMainBinding

class Home_screen : AppCompatActivity() {

    private lateinit var binding: ActiviteHomeScreenBinding
    private val mBinding: ActiviteHomeScreenBinding by lazy { binding}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActiviteHomeScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@Home_screen)
            adapter = NoteAdapter(
                listOf(
                    edu.t3h.note.model.Note("Getting Started", "Lorem ipsum dolor sit amet, consectetur adipisicing elit." +
                        " Cupiditate ea enim ipsum sint unde velit vitae! Asperiores dignissimos dolores eius eos"
                    ),edu.t3h.note.model.Note("Getting Started", "LOREM ipsum dolor sit amet, consectetur adipisicing elit." +
                            " Cupiditate ea enim ipsum sint unde velit vitae! Asperiores dignissimos dolores eius eos")
                )
            )
        }
    }
}