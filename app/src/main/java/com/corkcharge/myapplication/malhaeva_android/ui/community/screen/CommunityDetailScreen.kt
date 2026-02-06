package com.corkcharge.myapplication.malhaeva_android.ui.community.screen

import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.data.model.CommunityPost
import com.corkcharge.myapplication.malhaeva_android.ui.community.component.CommentItem
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Malhaeva_androidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommunityDetailScreen(post: CommunityPost, onBack: () -> Unit) {
    var text by rememberSaveable() { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if(post.type == "review") "면접후기" else "질문토론") },
                navigationIcon = {
                    IconButton(onClick = onBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                }
            )
        },
        bottomBar = {
            Surface(shadowElevation = 8.dp) {
                Row(
                    modifier = Modifier.padding(16.dp).fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        placeholder = { Text("댓글을 입력하세요") },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(20.dp),
                        value = text,
                        onValueChange = { text = it }
                    )
                    IconButton(onClick = {text = ""}) {
                        Icon(
                            Icons.AutoMirrored.Filled.Send,
                            contentDescription = "Send",
                            tint = Color(0xFF7E84F7)
                        )
                    }
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(modifier = Modifier.size(40.dp).background(Color.LightGray, CircleShape))
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(post.author, fontWeight = FontWeight.Bold)
                    Text(post.time, fontSize = 12.sp, color = Color.Gray)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(post.title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))
            Text(post.content, fontSize = 16.sp, lineHeight = 24.sp)

            Spacer(modifier = Modifier.height(30.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(16.dp))
            Text("댓글 ${post.comments}", fontWeight = FontWeight.Bold)

            // Mock Comments
            Spacer(modifier = Modifier.height(16.dp))
            CommentItem("익명1", "좋은 정보 감사합니다!")
            CommentItem("취준생2", "저도 비슷하게 답변했어요.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CommunityDetailScreenPreview() {
    Malhaeva_androidTheme {
        CommunityDetailScreen(
            post = CommunityPost(
                id = 1,
                type = "review",
                author = "익명",
                title = "면접 질문입니다.",
                content = "실제 면접에서 나왔던 질문입니다. 다들 좋은 결과 있으시길 바랍니다.",
                likes = 10,
                comments = 2,
                time = "1시간 전"
            ),
            onBack = {}
        )
    }
}
