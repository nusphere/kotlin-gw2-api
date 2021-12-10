package guildwars2.api.auth.tokeninfo

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface TokenInfoApi {

    /**
     * This resource returns information about the supplied API key.
     */
    @GET("/v2/tokeninfo") fun getTokenInfoAsync(): Deferred<TokenInfo>


    /**
     * This resource returns information about the supplied API key.
     */
    @GET("/v2/tokeninfo") fun getTokenInfo(): TokenInfo
}