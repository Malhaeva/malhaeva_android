package com.corkcharge.myapplication.malhaeva_android.data.repository

import com.corkcharge.myapplication.malhaeva_android.data.dto.request.LoginRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.request.SignUpRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.LoginResponseDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.SignUpResponseDto

interface AuthRepository {
    // 로그인
    suspend fun login(loginId: String, password: String): Result<LoginResponseDto>

    // 회원가입
    suspend fun signUp(loginId: String, password: String, name: String): Result<SignUpResponseDto>

    // 토큰 저장
    suspend fun saveTokens(accessToken: String, refreshToken: String)

    // Access Token 가져오기
    suspend fun getAccessToken(): String?

    // Refresh Token 가져오기
    suspend fun getRefreshToken(): String?

    // 토큰 삭제 (로그아웃)
    suspend fun clearTokens()
}
