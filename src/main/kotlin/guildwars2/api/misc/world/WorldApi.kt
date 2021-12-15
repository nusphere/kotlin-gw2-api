package guildwars2.api.misc.world

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorldApi {

    /**
     * This resource returns information about the available worlds, or servers.
     */
    @GET("/v2/worlds")
    suspend fun getWorldsAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<World>>

    @GET("/v2/worlds/{world_id}")
    suspend fun getWorldAsync(
        @Path(value = "world_id", encoded = true) worldId: Int,
        @Query("lang") lang: String = "en",
    ): Response<World>

    @GET("/v2/worlds")
    suspend fun getWorldIdsAsync(): Response<List<Int>>
}