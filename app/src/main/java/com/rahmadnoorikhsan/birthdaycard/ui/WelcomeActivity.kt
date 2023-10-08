package com.rahmadnoorikhsan.birthdaycard.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.rahmadnoorikhsan.birthdaycard.data.BirthdayGreeting
import com.rahmadnoorikhsan.birthdaycard.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnCreate.setOnClickListener {
                if (tilNameGoal.editText?.text.isNullOrBlank() && tilNameFrom.editText?.text.isNullOrBlank() && tilGreeting.editText?.text.isNullOrBlank()) {
                    Toast.makeText(this@WelcomeActivity, "Silahkan isi data terlebih dahulu", Toast.LENGTH_SHORT).show()
                } else {
                    intentWithData()
                }
            }
        }
    }

    private fun intentWithData() {
        binding.apply {
            val nameGoal = tiedNameGoal.text.toString().trim()
            val nameFrom = tiedNameFrom.text.toString().trim()
            val greeting = tiedGreeting.text.toString().trim()

            val birthdayGreeting = BirthdayGreeting(nameGoal, nameFrom, greeting)

            val intent = Intent(this@WelcomeActivity, MainActivity::class.java).apply {
                putExtra(GREETING, birthdayGreeting)
            }
            startActivity(intent)
        }
    }

    companion object {
        const val GREETING = "birthdayGreeting"
    }
}