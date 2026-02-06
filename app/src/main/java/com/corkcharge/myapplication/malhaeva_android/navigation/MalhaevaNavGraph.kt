package com.corkcharge.myapplication.malhaeva_android.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.corkcharge.myapplication.malhaeva_android.data.model.CommunityPost
import com.corkcharge.myapplication.malhaeva_android.data.model.Question
import com.corkcharge.myapplication.malhaeva_android.ui.community.screen.CommunityDetailScreen
import com.corkcharge.myapplication.malhaeva_android.ui.interview.screen.InterviewRecordingScreen
import com.corkcharge.myapplication.malhaeva_android.ui.interview.screen.InterviewResultScreen
import com.corkcharge.myapplication.malhaeva_android.ui.login.screen.LoginScreen
import com.corkcharge.myapplication.malhaeva_android.ui.signup.screen.SignUpScreen

@Composable
fun MalhaevaNavGraph(navController: NavHostController) {
    val todayQuestions = listOf(
        Question(1, "본인의 강점과 약점에 대해 말씀해주세요.", "인성"),
        Question(2, "우리 회사의 최근 이슈에 대해 아는 대로 설명해주세요.", "직무"),
        Question(3, "갈등을 해결했던 경험이 있나요?", "경험")
    )

    val communityPosts = listOf(
        CommunityPost(
            1,
            "review",
            "취뽀성공",
            "S전자 임원 면접 후기 공유합니다",
            "분위기는 생각보다 편안했고 면접관님들이 경청해주시는 느낌이었습니다. 저는 직무 경험 위주로 어필했습니다.",
            24,
            8,
            "1시간 전"
        ),
        CommunityPost(
            2,
            "discuss",
            "개발자지망생",
            "이 질문 어떻게 대답해야 할까요?",
            "\"마지막으로 하고 싶은 말\"에서 보통 어떤 걸 물어보시나요? 포부를 말해야 할지 질문을 해야 할지 고민입니다.",
            5,
            12,
            "3시간 전"
        ),
        CommunityPost(
            3,
            "review",
            "면접왕",
            "AI 역량검사 꿀팁 정리",
            "표정 관리가 제일 중요합니다. 그리고 마이크 테스트 꼭 미리 하세요.",
            56,
            21,
            "어제"
        )
    )
    NavHost(
        navController = navController,
        startDestination = Routes.LOGIN,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(300)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(300)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(300)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(300)
            )
        }
    ) {
        // Login Screen
        composable(Routes.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Routes.MAIN) {
                        popUpTo(Routes.LOGIN) { inclusive = true } // Clear back stack
                    }
                },
                onNavigateToSignUp = { navController.navigate(Routes.SIGN_UP) }
            )
        }

        // Sign Up Screen
        composable(Routes.SIGN_UP) {
            SignUpScreen(
                onBack = { navController.popBackStack() },
                onSignUpSuccess = { navController.popBackStack() }
            )
        }

        // Main Screen (Contains Home, List, Community List, Settings)
        composable(Routes.MAIN) {
            MainScreen(
                onNavigateToInterviewDetail = { questionId ->
                    navController.navigate(Routes.toInterviewDetail(questionId))
                },
                onNavigateToCommunityDetail = { postId ->
                    navController.navigate(Routes.toCommunityDetail(postId))
                },
                onLogout = {
                    navController.navigate(Routes.LOGIN) {
                        popUpTo(Routes.MAIN) { inclusive = true }
                        // 메인 화면을 백스택에서 제거하여 뒤로가기 시 다시 돌아오지 못하게 함
                    }
                }
            )
        }

        // Interview Detail / Recording Screen
        composable(
            route = Routes.INTERVIEW_DETAIL,
            arguments = listOf(navArgument("questionId") { type = NavType.IntType })
        ) { backStackEntry ->
            val questionId = backStackEntry.arguments?.getInt("questionId") ?: 1
            val question = todayQuestions.find { it.id == questionId } ?: todayQuestions[0]

            InterviewRecordingScreen(
                question = question,
                onBack = { navController.popBackStack() },
                onFinish = {
                    // Navigate to Result and remove Recording screen from back stack so user can't go back to recording state easily
                    navController.navigate(Routes.INTERVIEW_RESULT) {
                        popUpTo(Routes.INTERVIEW_DETAIL) { inclusive = true }
                    }
                }
            )
        }

        // Interview Result Screen
        composable(Routes.INTERVIEW_RESULT) {
            InterviewResultScreen(
                onClose = { navController.popBackStack() }
            )
        }

        // Community Detail Screen
        composable(
            route = Routes.COMMUNITY_DETAIL,
            arguments = listOf(navArgument("postId") { type = NavType.IntType })
        ) { backStackEntry ->
            val postId = backStackEntry.arguments?.getInt("postId") ?: 1
            val post = communityPosts.find { it.id == postId } ?: communityPosts[0]

            CommunityDetailScreen(
                post = post,
                onBack = { navController.popBackStack() }
            )
        }
    }
}