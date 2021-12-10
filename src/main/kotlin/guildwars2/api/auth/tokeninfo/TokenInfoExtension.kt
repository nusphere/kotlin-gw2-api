package guildwars2.api.auth.tokeninfo

import retrofit2.Retrofit

interface TokenInfoExtension {
    val retrofit: Retrofit
    private val api: TokenInfoApi get() = retrofit.create(TokenInfoApi::class.java)

    suspend fun getTokenInfo(): TokenInfo = api.getTokenInfoAsync().await()
}