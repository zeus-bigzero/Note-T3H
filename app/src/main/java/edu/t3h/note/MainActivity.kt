package edu.t3h.note

import android.content.Context
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.ActivityMainBinding
import edu.t3h.note.model.NoteModel
import java.io.File
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding by lazy { requireNotNull(_binding) }
    private var isHandleCallbackBackPress: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val note = NoteModel(1714042069513L,"Testing","Hello World!","#000000",false,false,false)
//        val content : String = note.toString() + "\n" + note.toString() + "\n" + note.toString() + "\n" + note.toString()

        val file = File(this.filesDir,"notes_data")
        if (!file.exists()) {
        try {
            val fos = this.openFileOutput("notes_data", Context.MODE_PRIVATE)
//            fos.write(content.toByteArray())
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        }

        val sharedPref = this.getSharedPreferences("tutorial_state", Context.MODE_PRIVATE)
        val isTutorialFinished = sharedPref.getBoolean("is_finish", true)
        if (isTutorialFinished) {
            replaceFragment(TutorialScreenFragment())
        } else {
            replaceFragment(HomeScreenFragment())
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (isHandleCallbackBackPress) {
                    showCloseAppDialog()
                } else {
                    finish()
                }
            }
        })
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }

    private fun showCloseAppDialog() {
        AlertDialog.Builder(this).apply {
            setTitle("Thông báo")
            setMessage("Bạn có muốn thoát ứng dụng không?")
            setPositiveButton("Có") { _, _ ->
                isHandleCallbackBackPress = false
                onBackPressedDispatcher.onBackPressed()
            }
            setNegativeButton("Không") { _, _ ->}
            show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}