package guildwars2.api.auth.tokeninfo

import retrofit2.Retrofit

interface TokenInfoExtension {
    val retrofit: Retrofit

    suspend fun getTokenInfo(): TokenInfo {
        val api: TokenInfoApi = retrofit.create(TokenInfoApi::class.java)

        return api.getTokenInfoAsync().await()
    }
}