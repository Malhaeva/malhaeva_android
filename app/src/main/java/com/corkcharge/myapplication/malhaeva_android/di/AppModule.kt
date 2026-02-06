package com.corkcharge.myapplication.malhaeva_android.di

import com.corkcharge.myapplication.malhaeva_android.ui.login.viewmodel.LoginViewModel
import com.corkcharge.myapplication.malhaeva_android.ui.signup.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // TODO: 서버 배포 후 API, Repository 추가 필요

    // ViewModel
    viewModel { LoginViewModel() }
    viewModel { SignUpViewModel() }
}
