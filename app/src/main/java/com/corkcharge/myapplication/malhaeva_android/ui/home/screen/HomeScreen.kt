package com.corkcharge.myapplication.malhaeva_android.ui.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.corkcharge.myapplication.malhaeva_android.data.Question
import com.corkcharge.myapplication.malhaeva_android.ui.common.component.CommonTopAppBar
import com.corkcharge.myapplication.malhaeva_android.ui.home.component.MissionDdayItem
import com.corkcharge.myapplication.malhaeva_android.ui.home.component.QuestionCard
import com.corkcharge.myapplication.malhaeva_android.ui.home.component.StatSummaryCard
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography

@Composable
fun HomeScreen(onNavigateToInterview: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        val todayQuestions = listOf(
            Question(1, "본인의 강점과 약점에 대해 말씀해주세요.", "인성"),
            Question(2, "우리 회사의 최근 이슈에 대해 아는 대로 설명해주세요.", "직무"),
            Question(3, "갈등을 해결했던 경험이 있나요?", "경험")
        )
        CommonTopAppBar()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .shadow(
                        elevation = 6.dp,
                        shape = RoundedCornerShape(20.dp),
                        clip = false
                    )
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF9810FA), // 위쪽 보라
                                Color(0xFF4F39F6)  // 아래쪽 보라
                            )
                        ),
                        shape = RoundedCornerShape(20.dp),
                    )
                    .padding(24.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "오늘도 합격에 가까워지세요!",
                        color = Color.White,
                        style = LocalMalhaevaTypography.current.R_14
                    )
                    Spacer(Modifier.height(5.dp))
                    Text(text = "면접 준비 4일차 🔥", style = LocalMalhaevaTypography.current.B_20, color = Color.White)
                    Spacer(Modifier.height(10.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        StatSummaryCard(title = "총 연습 횟수", content = "12회")
                        Spacer(modifier = Modifier.weight(1f))
                        StatSummaryCard(title = "평균 AI 점수", content = "B+")
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "오늘의 미션", style = LocalMalhaevaTypography.current.SB_16, color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                MissionDdayItem("자정 마감")
            }
            Spacer(modifier = Modifier.height(20.dp))
            todayQuestions.forEachIndexed { index, question ->
                Surface(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 6.dp).clickable { onNavigateToInterview() },
                    shape = RoundedCornerShape(16.dp), color = Color.White, shadowElevation = 1.dp
                ) {
                    QuestionCard(
                        number = index + 1,
                        category = question.category,
                        question = question.text,
                        onClick = onNavigateToInterview
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@Preview
@Composable
private fun HomePreview() {
    HomeScreen({})
}