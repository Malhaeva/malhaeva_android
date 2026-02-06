package com.corkcharge.myapplication.malhaeva_android.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthToken(
    val accessToken: String? = null,
    val refreshToken: String? = null
)
