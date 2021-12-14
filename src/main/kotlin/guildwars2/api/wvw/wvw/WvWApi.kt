package guildwars2.api.wvw.wvw

import retrofit2.Response
import retrofit2.http.GET

interface WvWApi {

    /**
     * This resource provides information about the v2/wvw endpoints.
     */
    @GET("/v2/wvw")
    suspend fun getApiTypesAsync(): Response<List<String>>
}