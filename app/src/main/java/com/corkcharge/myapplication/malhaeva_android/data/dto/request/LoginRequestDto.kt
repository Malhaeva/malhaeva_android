package com.corkcharge.myapplication.malhaeva_android.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestDto(
    val loginId : String,
    val password : String
)
