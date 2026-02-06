package com.corkcharge.myapplication.malhaeva_android.ui.interview.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.data.Question
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600

@Composable
fun AIInterviewScreen(onSelectQuestion: (Question) -> Unit) {
    val todayQuestions = listOf(
        Question(1, "본인의 강점과 약점에 대해 말씀해주세요.", "인성"),
        Question(2, "우리 회사의 최근 이슈에 대해 아는 대로 설명해주세요.", "직무"),
        Question(3, "갈등을 해결했던 경험이 있나요?", "경험")
    )

    Column(modifier = Modifier.padding(20.dp).fillMaxSize()) {
        Text("AI 면접 연습", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 20.dp))
        Text("오늘의 추천 질문", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))

        todayQuestions.forEach { question ->
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onSelectQuestion(question) },
                shape = RoundedCornerShape(16.dp),
                color = Color.White,
                border = BorderStroke(1.dp, Color(0xFFE5E7EB)),
                shadowElevation = 2.dp
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            question.category,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold,
                            color = Indigo600,
                            modifier = Modifier.background(Indigo50, RoundedCornerShape(4.dp)).padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text("AI 분석 지원", fontSize = 10.sp, color = Indigo600, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(question.text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
            }
        }
    }
}