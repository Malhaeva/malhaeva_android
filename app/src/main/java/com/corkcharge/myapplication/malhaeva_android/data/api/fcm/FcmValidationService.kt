package com.corkcharge.myapplication.malhaeva_android.data.api.fcm

import de.jensklingenberg.ktorfit.Response
import de.jensklingenberg.ktorfit.http.POST

interface FcmValidationService {
    @POST("notifications/validation-token")
    suspend fun validateToken(): Response<Unit>
}
