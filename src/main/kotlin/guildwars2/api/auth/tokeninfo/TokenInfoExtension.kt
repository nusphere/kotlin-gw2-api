package guildwars2.api.auth.tokeninfo

import kotlinx.coroutines.*
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface TokenInfoExtension {
    val retrofit: Retrofit

    private val api: TokenInfoApi get() = retrofit.create(TokenInfoApi::class.java)

    fun getTokenInfo(): TokenInfo? = runBlocking { getTokenResponse()?.body() }

    fun getTokenInfoHeader(): Headers? = runBlocking { getTokenResponse()?.headers() }

    suspend fun getTokenResponse(): Response<TokenInfo>? = api.getTokenInfoAsync()
}