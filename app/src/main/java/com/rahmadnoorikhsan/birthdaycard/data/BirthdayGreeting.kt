package com.rahmadnoorikhsan.birthdaycard.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class BirthdayGreeting(
    val nameGoal: String,
    val nameFrom: String,
    val greeting: String
): Parcelable
