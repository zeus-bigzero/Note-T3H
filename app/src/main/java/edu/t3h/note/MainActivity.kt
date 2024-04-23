package edu.t3h.note

import android.content.Context
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding by lazy { requireNotNull(_binding) }
    private var isHandleCallbackBackPress: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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