package com.corkcharge.myapplication.malhaeva_android.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography

@Composable
fun StatSummaryCard(title: String, content: String) { // 제목, 내용
    Box(
        modifier = Modifier
            .background(
                color = Color(0xFF7F57E5),
                shape = RoundedCornerShape(20.dp),
            )
            .border(
                width = 2.dp,
                color = Color(0xFF8869E7),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(40.dp, 16.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, color = Color.White, style = LocalMalhaevaTypography.current.R_14)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = content, color = Color.White, style = LocalMalhaevaTypography.current.B_17)
        }
    }
}

@Preview
@Composable
fun StatSummaryCardPreview() {
    StatSummaryCard(title = "총 연습 횟수", content = "12회")
}