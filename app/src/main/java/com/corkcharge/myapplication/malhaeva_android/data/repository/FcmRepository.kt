package com.corkcharge.myapplication.malhaeva_android.data.repository

interface FcmRepository {
    suspend fun saveFcmToken(token: String)
    suspend fun getFcmToken(): String?

    suspend fun clearToken()
    suspend fun validateAndRefreshTokenIfNeeded(jwtToken: String)
}
