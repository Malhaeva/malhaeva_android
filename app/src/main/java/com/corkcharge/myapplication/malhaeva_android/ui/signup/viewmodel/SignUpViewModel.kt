package com.corkcharge.myapplication.malhaeva_android.ui.signup.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

data class SignUpUiState(
    val isLoading: Boolean = false,
    val isSuccess: Boolean = false,
    val errorMessage: String? = null
)

class SignUpViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun signUp(loginId: String, password: String, name: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            // TODO: 서버 배포 후 API 연동 필요
            // 임시로 성공 처리
            delay(500) // 로딩 효과
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isSuccess = true
            )
        }
    }

    fun resetState() {
        _uiState.value = SignUpUiState()
    }
}
