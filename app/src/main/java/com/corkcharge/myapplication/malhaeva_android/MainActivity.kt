package com.corkcharge.myapplication.malhaeva_android

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.navigation.compose.rememberNavController
import com.corkcharge.myapplication.malhaeva_android.navigation.MalhaevaNavGraph
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600
import com.google.firebase.FirebaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Firebase 초기화 (FCM 필수)
        FirebaseApp.initializeApp(this)

        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Indigo600,
                    background = Gray50,
                    surface = Color.White
                )
            ) {
                // Android 13+ 알림 권한 요청 (FCM 필수)
                RequestNotificationPermission()

                val navController = rememberNavController()
                MalhaevaNavGraph(navController = navController)
            }
        }
    }
}

@Composable
fun RequestNotificationPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        val context = LocalContext.current
        val permission = android.Manifest.permission.POST_NOTIFICATIONS
        val hasRequested = remember { mutableStateOf(false) }

        LaunchedEffect(Unit) {
            if (!hasRequested.value &&
                ContextCompat.checkSelfPermission(
                    context,
                    permission
                ) != android.content.pm.PackageManager.PERMISSION_GRANTED
            ) {
                hasRequested.value = true
                (context as ComponentActivity).requestPermissions(
                    arrayOf(permission),
                    0
                )
            }
        }
    }
}
