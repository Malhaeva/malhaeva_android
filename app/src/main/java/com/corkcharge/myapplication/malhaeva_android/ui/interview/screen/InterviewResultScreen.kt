package com.corkcharge.myapplication.malhaeva_android.ui.interview.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R
import com.corkcharge.myapplication.malhaeva_android.ui.interview.component.ResultItem
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography

@Composable
fun InterviewResultScreen(onClose: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp).verticalScroll(rememberScrollState())) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("분석 리포트", style = LocalMalhaevaTypography.current.SB_24)
            IconButton(onClick = onClose) { Icon(Icons.Default.Close, contentDescription = "Close", modifier = Modifier.size(24.dp)) }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Indigo600)
        ) {
            Row(
                modifier = Modifier.padding(24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text("종합 평가", color = Indigo50, style = LocalMalhaevaTypography.current.R_14)
                    Spacer(modifier = Modifier.height(3.dp))
                    Text("Excellent!", color = Color.White, fontSize = 32.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.weight(1f))
                Text("A", color = Color.Red , fontSize = 40.sp, fontWeight = FontWeight.Bold, modifier = Modifier.background(Color.White, RoundedCornerShape(100.dp)).padding(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        ResultItem(icon = ImageVector.vectorResource(id = R.drawable.ic_alarm), color = Color(0xFFF97316), title = "답변 시간") {
            Text("58초 (적정)", style = LocalMalhaevaTypography.current.SB_18)
        }
        ResultItem(icon = Icons.Outlined.Check, color = Indigo600, title = "습관어 분석") {
            Text("'음' 3회, '어' 1회 발견되었습니다.", style = LocalMalhaevaTypography.current.R_14)
        }
        ResultItem(icon = Icons.Outlined.ThumbUp, color = Color(0xFF22C55E), title = "핵심 키워드") {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("협업", "책임감", "소통").forEach {
                    Text("#$it", color = Indigo600, style = LocalMalhaevaTypography.current.SB_14, modifier = Modifier.background(Indigo50, RoundedCornerShape(4.dp)).padding(10.dp))
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = onClose,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("다른 질문 연습하기", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InterviewResultScreenPreview() {
    InterviewResultScreen(onClose = {})
}