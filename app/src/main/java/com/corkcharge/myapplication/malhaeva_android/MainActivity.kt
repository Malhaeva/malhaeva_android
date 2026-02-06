package com.corkcharge.myapplication.malhaeva_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.corkcharge.myapplication.malhaeva_android.navigation.MalhaevaNavGraph
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = lightColorScheme(
                    primary = Indigo600,
                    background = Gray50,
                    surface = Color.White
                )
            ) {
                // Initialize Navigation
                val navController = rememberNavController()
                MalhaevaNavGraph(navController = navController)
            }
        }
    }
}