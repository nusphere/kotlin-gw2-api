package guildwars2.api.misc.world

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WorldApi {
    /**
     * This resource returns information about the available worlds, or servers.
     */
    @GET("/v2/worlds")
    suspend fun getWorldsAsync(@Query("ids") ids: String = "all"): Response<List<World>>

    @GET("/v2/worlds")
    suspend fun getWorldsAsync(): Response<List<Int>>
}