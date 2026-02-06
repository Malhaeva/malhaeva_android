package com.corkcharge.myapplication.malhaeva_android.data

data class CommunityPost(
    val id: Int,
    val type: String,
    val author: String,
    val title: String,
    val content: String,
    val likes: Int,
    val comments: Int,
    val time: String
)
