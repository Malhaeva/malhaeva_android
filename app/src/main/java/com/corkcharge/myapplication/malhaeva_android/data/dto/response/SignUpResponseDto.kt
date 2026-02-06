package com.corkcharge.myapplication.malhaeva_android.data.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class SignUpResponseDto(
    val userId: Long,
    val email: String,
)
