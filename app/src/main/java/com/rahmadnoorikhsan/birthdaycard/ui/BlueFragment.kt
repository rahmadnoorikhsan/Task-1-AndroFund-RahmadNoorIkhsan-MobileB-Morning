package com.rahmadnoorikhsan.birthdaycard.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rahmadnoorikhsan.birthdaycard.data.BirthdayGreeting
import com.rahmadnoorikhsan.birthdaycard.databinding.FragmentBlueBinding

@Suppress("DEPRECATION")
class BlueFragment : Fragment() {

    private var _binding: FragmentBlueBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBlueBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            val intent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                activity?.intent?.getParcelableExtra(WelcomeActivity.GREETING, BirthdayGreeting::class.java)
            } else {
                activity?.intent?.getParcelableExtra(WelcomeActivity.GREETING)
            }
            tvNameGoal.text = intent?.nameGoal
            tvNameFrom.text = intent?.nameFrom
            tvGreeting.text = intent?.greeting
        }
    }
}