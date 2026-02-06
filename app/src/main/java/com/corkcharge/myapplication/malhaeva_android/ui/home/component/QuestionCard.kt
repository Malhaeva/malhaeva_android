package com.corkcharge.myapplication.malhaeva_android.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R
import com.corkcharge.myapplication.malhaeva_android.data.Question

@Composable
fun QuestionCard(
    number: Int,
    category: String,
    question: String,
    onClick: (Question) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 6.dp,
                shape = RoundedCornerShape(20.dp),
                clip = false
            )
            .clickable(onClick = { onClick(Question(number, question, category)) })
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 숫자 원
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color(0xFFEDEFFF),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = number.toString(),
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF574ADC)
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // 텍스트 영역
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // 카테고리 칩
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFF2F2F2),
                            shape = RoundedCornerShape(12.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = category,
                        fontSize = 12.sp,
                        color = Color(0xFF666666)
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                // 질문 텍스트
                Text(
                    text = question,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 화살표
            Icon(
                painter = painterResource(id = R.drawable.outline_arrow_forward_ios_24),
                contentDescription = "arrow",
                tint = Color(0xFFB0B0B0),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionCardPreview() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        QuestionCard(
            number = 1,
            category = "인성",
            question = "본인의 강점과 약점에 대해 말씀해주세요."
        )
    }
}

