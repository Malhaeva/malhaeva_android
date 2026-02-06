package com.corkcharge.myapplication.malhaeva_android.ui.settings.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.ui.settings.component.SettingsItem
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo50

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Gray50)) {
        // Header Profile
        Surface(color = Color.White, shadowElevation = 1.dp) {
            Row(
                modifier = Modifier.padding(24.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(modifier = Modifier.size(60.dp).background(Indigo50, CircleShape), contentAlignment = Alignment.Center) {
                    Text("🧑‍💻", fontSize = 30.sp)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text("취준생 화이팅", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text("마케팅 직무 희망", fontSize = 14.sp, color = Color.Gray)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Settings Options
        SettingsGroup("계정") {
            SettingsItem("내 프로필 수정")
            SettingsItem("비밀번호 변경")
        }

        SettingsGroup("알림") {
            SettingsItem("데일리 미션 알림", hasSwitch = true)
            SettingsItem("커뮤니티 댓글 알림", hasSwitch = true)
        }

        SettingsGroup("앱 정보") {
            SettingsItem("공지사항")
            SettingsItem("버전 정보 (1.0.0)")
            SettingsItem("로그아웃", isDestructive = true)
        }
    }
}

@Composable
fun SettingsGroup(title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 8.dp)) {
        Text(title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray, modifier = Modifier.padding(bottom = 8.dp, start = 4.dp))
        Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column { content() }
        }
    }
}
