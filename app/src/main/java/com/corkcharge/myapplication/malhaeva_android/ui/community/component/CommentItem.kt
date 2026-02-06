package com.corkcharge.myapplication.malhaeva_android.ui.community.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.corkcharge.myapplication.malhaeva_android.ui.theme.LocalMalhaevaTypography

@Composable
fun CommentItem(author: String, content: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Box(modifier = Modifier
            .size(32.dp)
            .background(color = Color(0xFF5C50E3), CircleShape))
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(author, style = LocalMalhaevaTypography.current.B_12)
            Text(content, style = LocalMalhaevaTypography.current.R_14)
        }
    }
}

@Preview
@Composable
fun CommentItemPreview() {
    CommentItem(author = "Author", content = "This is a comment.")
}