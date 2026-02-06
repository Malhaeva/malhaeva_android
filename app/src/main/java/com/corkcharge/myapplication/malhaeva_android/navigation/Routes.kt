package com.corkcharge.myapplication.malhaeva_android.navigation

object Routes {
    const val LOGIN = "login"
    const val SIGN_UP = "signup"
    const val MAIN = "main"
    const val INTERVIEW_DETAIL = "interview_detail/{questionId}"
    const val INTERVIEW_RESULT = "interview_result"
    const val COMMUNITY_DETAIL = "community_detail/{postId}"

    // Helper functions to build routes with arguments
    fun toInterviewDetail(questionId: Int) = "interview_detail/$questionId"
    fun toCommunityDetail(postId: Int) = "community_detail/$postId"
}