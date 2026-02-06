package com.corkcharge.myapplication.malhaeva_android.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponseDto(
    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: Tokens
)

@Serializable
data class Tokens(
    val accessToken: String,
    val refreshToken: String,
)
