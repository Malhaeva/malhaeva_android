package com.corkcharge.myapplication.malhaeva_android.di

import com.corkcharge.myapplication.malhaeva_android.data.api.AuthApi
import com.corkcharge.myapplication.malhaeva_android.data.api.HttpClientProvider
import com.corkcharge.myapplication.malhaeva_android.data.repository.AuthRepository
import com.corkcharge.myapplication.malhaeva_android.data.repositoryImpl.AuthRepositoryImpl
import com.corkcharge.myapplication.malhaeva_android.ui.login.viewmodel.LoginViewModel
import com.corkcharge.myapplication.malhaeva_android.ui.signup.viewmodel.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    // HttpClient
    single { HttpClientProvider.client }

    // API
    single { AuthApi(get()) }

    // Repository
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }

    // ViewModel
    viewModel { LoginViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
}
