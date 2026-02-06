package com.corkcharge.myapplication.malhaeva_android.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R
import com.corkcharge.myapplication.malhaeva_android.data.CommunityPost
import com.corkcharge.myapplication.malhaeva_android.data.Question
import com.corkcharge.myapplication.malhaeva_android.ui.community.screen.CommunityScreen
import com.corkcharge.myapplication.malhaeva_android.ui.home.screen.HomeScreen
import com.corkcharge.myapplication.malhaeva_android.ui.interview.screen.AIInterviewScreen
import com.corkcharge.myapplication.malhaeva_android.ui.settings.screen.SettingsScreen
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600

@Composable
fun MainScreen(
    onNavigateToInterviewDetail: (Int) -> Unit,
    onNavigateToCommunityDetail: (Int) -> Unit
) {
    var selectedTab by rememberSaveable { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                val items = listOf(
                    Triple("홈", R.drawable.ic_home, 0),
                    Triple("AI 면접", R.drawable.ic_ai_interview, 1),
                    Triple("커뮤니티", R.drawable.ic_community, 2),
                    Triple("설정", R.drawable.ic_settings, 3) // Profile -> Settings
                )
                items.forEach { item ->
                    NavigationBarItem(
                        icon = { Icon(painter = painterResource(id = item.second), contentDescription = item.first, modifier = Modifier.size(24.dp)) },
                        label = { Text(item.first, fontSize = 10.sp) },
                        selected = selectedTab == item.third,
                        onClick = { selectedTab = item.third },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Indigo600,
                            selectedTextColor = Indigo600,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                0 -> HomeScreen(onNavigateToInterview = { q -> onNavigateToInterviewDetail(q.id) })
                1 -> AIInterviewScreen (onSelectQuestion = { q -> onNavigateToInterviewDetail(q.id) })
                2 -> CommunityScreen(onSelectPost = { p -> onNavigateToCommunityDetail(p.id) })
                3 -> SettingsScreen()
            }
        }
    }
}