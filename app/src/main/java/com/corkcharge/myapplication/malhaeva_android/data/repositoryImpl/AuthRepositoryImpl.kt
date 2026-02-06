package com.corkcharge.myapplication.malhaeva_android.data.repositoryImpl

import android.content.Context
import androidx.datastore.dataStore
import com.corkcharge.myapplication.malhaeva_android.data.api.AuthApi
import com.corkcharge.myapplication.malhaeva_android.data.dto.request.LoginRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.request.SignUpRequestDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.LoginResponseDto
import com.corkcharge.myapplication.malhaeva_android.data.dto.response.SignUpResponseDto
import com.corkcharge.myapplication.malhaeva_android.data.model.AuthToken
import com.corkcharge.myapplication.malhaeva_android.data.repository.AuthRepository
import com.corkcharge.myapplication.malhaeva_android.data.util.AuthTokenSerializer
import kotlinx.coroutines.flow.first

val Context.authDataStore by dataStore(
    fileName = "auth_tokens",
    serializer = AuthTokenSerializer
)

class AuthRepositoryImpl(
    private val context: Context,
    private val authApi: AuthApi
) : AuthRepository {

    override suspend fun login(loginId: String, password: String): Result<LoginResponseDto> {
        return try {
            val response = authApi.login(LoginRequestDto(loginId, password))
            // 토큰 저장
            if (response.isSuccess) {
                saveTokens(response.result.accessToken, response.result.refreshToken)
            }
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signUp(
        loginId: String,
        password: String,
        name: String
    ): Result<SignUpResponseDto> {
        return try {
            val response = authApi.signUp(SignUpRequestDto(loginId, password, name))
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun saveTokens(accessToken: String, refreshToken: String) {
        context.authDataStore.updateData {
            it.copy(accessToken = accessToken, refreshToken = refreshToken)
        }
    }

    override suspend fun getAccessToken(): String? {
        return context.authDataStore.data.first().accessToken
    }

    override suspend fun getRefreshToken(): String? {
        return context.authDataStore.data.first().refreshToken
    }

    override suspend fun clearTokens() {
        context.authDataStore.updateData {
            AuthToken()
        }
    }
}
