package com.corkcharge.myapplication.malhaeva_android.data.util

import androidx.datastore.core.Serializer
import com.corkcharge.myapplication.malhaeva_android.data.model.AuthToken
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object AuthTokenSerializer : Serializer<AuthToken> {
    override val defaultValue: AuthToken
        get() = AuthToken()

    override suspend fun readFrom(input: InputStream): AuthToken {
        return try {
            Json.decodeFromString(
                deserializer = AuthToken.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: AuthToken, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = AuthToken.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}
