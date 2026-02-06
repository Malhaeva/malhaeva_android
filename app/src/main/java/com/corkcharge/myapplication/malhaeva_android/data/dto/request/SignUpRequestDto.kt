package com.corkcharge.myapplication.malhaeva_android.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class SignUpRequestDto(
    val loginId: String,
    val password: String,
    val name: String,
)
