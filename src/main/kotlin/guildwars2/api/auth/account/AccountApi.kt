package guildwars2.api.auth.account

import retrofit2.Response
import retrofit2.http.GET

interface AccountApi {

    @GET("/v2/account")
    suspend fun getAccountAsync(): Response<Account>
}