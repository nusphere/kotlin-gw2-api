package guildwars2.api.auth.finisher

import retrofit2.Response
import retrofit2.http.GET

interface FinisherApi {

    @GET("/v2/account/finisher")
    suspend fun getFinisherAsync(): Response<List<AccountFinisher>>
}