package guildwars2.api.auth.dyes

import retrofit2.Response
import retrofit2.http.GET

interface DyesApi {

    @GET("/v2/account/dyes")
    suspend fun getDyesAsync(): Response<List<Int>>
}