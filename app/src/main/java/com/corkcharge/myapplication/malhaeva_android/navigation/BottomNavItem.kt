package com.corkcharge.myapplication.malhaeva_android.navigation

import com.corkcharge.myapplication.malhaeva_android.R

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: Int
) {
    object Home : BottomNavItem("home", "홈", R.drawable.ic_home)
    object AiInterview : BottomNavItem("ai", "AI 면접", R.drawable.ic_ai_interview)
    object Community : BottomNavItem("community", "커뮤니티", R.drawable.ic_community)
    object Settings : BottomNavItem("settings", "설정", R.drawable.ic_settings)
}
