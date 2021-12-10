package guildwars2.api.auth.tokeninfo

import kotlinx.coroutines.*
import retrofit2.Retrofit

interface TokenInfoExtension {
    val retrofit: Retrofit

    private val api: TokenInfoApi get() = retrofit.create(TokenInfoApi::class.java)

    fun getTokenInfo(): TokenInfo = runBlocking { api.getTokenInfoAsync().await() }
}