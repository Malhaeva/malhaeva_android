package com.corkcharge.myapplication.malhaeva_android.ui.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography
import androidx.compose.ui.tooling.preview.Preview
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Malhaeva_androidTheme

@Composable
fun MissionDdayItem(content: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color(0xFFE6EBFC),
                shape = RoundedCornerShape(100.dp)
            )
            .background(
                Color(0xFFEDEFFE),
                shape = RoundedCornerShape(100.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = content,
            color = Color(0xFF5C50E3),
            style = LocalMalhaevaTypography.current.SB_14
        )

    }
}

@Preview
@Composable
fun MissionDdayItemPreview() {
    Malhaeva_androidTheme {
        MissionDdayItem(content = "자정 마감")
    }
}
