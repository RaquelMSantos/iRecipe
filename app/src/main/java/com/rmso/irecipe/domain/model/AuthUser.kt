package com.rmso.irecipe.domain.model

import android.net.Uri
import com.google.firebase.auth.FirebaseUser

data class AuthUser(
    val id: String = "",
    val isAnonymous: Boolean = true,
    val displayName: String? = null,
    val email: String? = null,
    val phoneNumber: String? = null,
    val photoUrl: Uri? = null,
    val isEmailVerified: Boolean = false
)

fun FirebaseUser?.toAuthUser(): AuthUser =
    this?.let {
        AuthUser(
            id = it.uid,
            isAnonymous = it.isAnonymous,
            displayName = it.displayName,
            email = it.email,
            phoneNumber = it.phoneNumber,
            photoUrl = it.photoUrl,
            isEmailVerified = it.isEmailVerified
        )
    } ?: AuthUser()
