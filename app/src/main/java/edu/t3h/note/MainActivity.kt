package edu.t3h.note

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.t3h.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //region -> UI Components
    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = requireNotNull(_binding)
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        _binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, TutorialFragment())
            .commit()
    }
}