package com.rahmadnoorikhsan.birthdaycard.ui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.rahmadnoorikhsan.birthdaycard.R
import com.rahmadnoorikhsan.birthdaycard.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            ibBlue.setOnClickListener {
                replaceFragment(BlueFragment())
                tvSelectBackground.isVisible = false
            }
            ibPink.setOnClickListener {
                replaceFragment(PinkFragment())
                tvSelectBackground.isVisible = false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().apply {
            replace(R.id.fcv_birthday, fragment)
            commit()
        }

    }
}