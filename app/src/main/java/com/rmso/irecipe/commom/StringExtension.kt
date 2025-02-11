package com.rmso.irecipe.commom

import android.util.Patterns

private const val MIN_CHARACTERS = 8

fun String.isValidEmail(): Boolean =
    Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword(): Boolean {
    // rule: min 8 characters - one upperCase - one lowerCase - one number - special character
    if (this.length < MIN_CHARACTERS) return false
    if (!this.any { it.isUpperCase() }) return false
    if (!this.any { it.isLowerCase() }) return false
    if (!this.any { it.isDigit() }) return false
    if (!this.any { it in "!@#$%^&*()" }) return false
    return true
}
