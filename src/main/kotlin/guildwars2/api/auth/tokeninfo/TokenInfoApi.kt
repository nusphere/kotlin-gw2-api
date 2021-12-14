package guildwars2.api.auth.tokeninfo

import retrofit2.Response
import retrofit2.http.GET

interface TokenInfoApi {

    /**
     * This resource returns information about the supplied API key.
     */
    @GET("/v2/tokeninfo")
    suspend fun getTokenInfoAsync(): Response<TokenInfo>
}