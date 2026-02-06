package com.corkcharge.myapplication.malhaeva_android.ui.community.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.corkcharge.myapplication.malhaeva_android.R
import com.corkcharge.myapplication.malhaeva_android.data.CommunityPost
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Gray50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo50
import com.corkcharge.myapplication.malhaeva_android.ui.theme.Indigo600

@Composable
fun CommunityScreen(onSelectPost: (CommunityPost) -> Unit) {

    val communityPosts = listOf(
        CommunityPost(1, "review", "취뽀성공", "S전자 임원 면접 후기 공유합니다", "분위기는 생각보다 편안했고 면접관님들이 경청해주시는 느낌이었습니다. 저는 직무 경험 위주로 어필했습니다.", 24, 8, "1시간 전"),
        CommunityPost(2, "discuss", "개발자지망생", "이 질문 어떻게 대답해야 할까요?", "\"마지막으로 하고 싶은 말\"에서 보통 어떤 걸 물어보시나요? 포부를 말해야 할지 질문을 해야 할지 고민입니다.", 5, 12, "3시간 전"),
        CommunityPost(3, "review", "면접왕", "AI 역량검사 꿀팁 정리", "표정 관리가 제일 중요합니다. 그리고 마이크 테스트 꼭 미리 하세요.", 56, 21, "어제")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text("취준 커뮤니티", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp))
            Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                FilterChip(selected = true, onClick = {}, label = { Text("전체") }, modifier = Modifier.padding(end = 8.dp))
                FilterChip(selected = false, onClick = {}, label = { Text("면접후기") }, modifier = Modifier.padding(end = 8.dp))
                FilterChip(selected = false, onClick = {}, label = { Text("질문토론") })
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        items(communityPosts) { post ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onSelectPost(post) }
                    .background(Color.White)
                    .padding(20.dp)
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        if (post.type == "review") "면접후기" else "질문토론",
                        fontSize = 10.sp, color = Indigo600, fontWeight = FontWeight.Bold,
                        modifier = Modifier.background(
                            color = Indigo50,
                            shape = RoundedCornerShape(4.dp)
                        ).padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(post.author, fontSize = 12.sp, color = Color.Gray)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(post.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(post.content, color = Color.Gray, maxLines = 2, overflow = TextOverflow.Ellipsis, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Row {
                    Icon(Icons.Outlined.ThumbUp, contentDescription = null, modifier = Modifier.size(14.dp))
                    Text(" ${post.likes}  ", fontSize = 12.sp, color = Color.Gray)
                    Icon(painter = painterResource(id = R.drawable.ic_send), contentDescription = null, modifier = Modifier.size(14.dp), tint = Color.Gray)
                    Text(" ${post.comments}", fontSize = 12.sp, color = Color.Gray)
                }
            }
            HorizontalDivider(color = Gray50)
        }
    }
}
