package com.corkcharge.myapplication.malhaeva_android.data.api

import com.corkcharge.myapplication.malhaeva_android.data.dto.request.LoginRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.request.SignUpRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.LoginResponseDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.SignUpResponseDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType

class AuthApi(private val client: HttpClient) {
    suspend fun login(request: LoginRequestDto): LoginResponseDto {
        return client.post("auth/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }

    suspend fun signUp(request: SignUpRequestDto): SignUpResponseDto {
        return client.post("auth/sign-up") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }.body()
    }
}
