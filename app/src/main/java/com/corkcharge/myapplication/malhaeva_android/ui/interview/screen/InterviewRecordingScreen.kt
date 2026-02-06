package com.corkcharge.myapplication.malhaeva_android.ui.interview.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R
import com.corkcharge.myapplication.malhaeva_android.data.Question
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography
import kotlinx.coroutines.delay


@Composable
fun InterviewRecordingScreen(question: Question, onBack: () -> Unit, onFinish: () -> Unit) {
    var timerSeconds by remember { mutableIntStateOf(0) }
    var isRecording by remember { mutableStateOf(false) }
    var isAnalyzing by remember { mutableStateOf(false) }

    // Timer Logic
    LaunchedEffect(isRecording) {
        if (isRecording) {
            timerSeconds = 0
            while (isRecording) {
                delay(1000L)
                timerSeconds++
            }
        }
    }

    // Analyzing Simulation
    LaunchedEffect(isAnalyzing) {
        if (isAnalyzing) {
            delay(2500) // Fake analysis time
            onFinish()
        }
    }

    if (isAnalyzing) {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(color = Indigo600)
            Spacer(modifier = Modifier.height(20.dp))
            Text("AI 분석 중...", style = LocalMalhaevaTypography.current.B_20)
            Text("발음, 속도, 습관어를 분석하고 있습니다.", color = Color.Gray)
        }
    } else {
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White).padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = onBack, modifier = Modifier.align(Alignment.CenterStart)) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                color = if (isRecording) Color(0xFFFEF2F2) else Gray50,
                shape = RoundedCornerShape(50)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.size(8.dp).background(if(isRecording) Color.Red else Color.Gray, CircleShape))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if(isRecording) "녹음 중" else "대기 중", color = if(isRecording) Color.Red else Color.Gray, style = LocalMalhaevaTypography.current.B_12)
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text("\"${question.text}\"", fontSize = 22.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.weight(1f))
            Text(
                String.format("%02d:%02d", timerSeconds / 60, timerSeconds % 60),
                fontSize = 56.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace
            )
            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = {
                    if (isRecording) isAnalyzing = true // Stop -> Analyze
                    else isRecording = true // Start
                },
                modifier = Modifier.size(80.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(containerColor = if (isRecording) Color.White else Color(0xFFEF4444)),
                border = if (isRecording) BorderStroke(4.dp, Color.Gray) else null
            ) {
                Icon(
                    painter = painterResource(if (isRecording) R.drawable.ic_stop_record else R.drawable.ic_start_record),
                    contentDescription = null,
                    tint = if (isRecording) Color.Black else Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}