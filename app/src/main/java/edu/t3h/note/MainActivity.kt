package edu.t3h.note

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import edu.t3h.note.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mBinding: ActivityMainBinding by lazy { binding }

    val homeScreenFragment = HomeScreenFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        replaceFragment(homeScreenFragment)

        mBinding.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_notes -> replaceFragment(homeScreenFragment)
                R.id.navigation_event -> Toast.makeText(this, "event screen", Toast.LENGTH_SHORT)
                    .show()
                R.id.navigation_search -> Toast.makeText(this, "search screen", Toast.LENGTH_SHORT)
                    .show()
                R.id.navigation_createNote -> startActivity(Intent(this, CreateNote::class.java))

                else -> {}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(mBinding.container.id, fragment)
            .commit()
    }
}