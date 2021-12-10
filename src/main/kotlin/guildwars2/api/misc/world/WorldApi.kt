package guildwars2.api.misc.world

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface WorldApi {
    /**
     * This resource returns information about the available worlds, or servers.
     */
    @GET("/v2/worlds") fun getWorldsAsync(@Query("ids") ids: String = "all"): Deferred<Collection<World>>
    @GET("/v2/worlds") fun getWorldsAsync(): Deferred<Collection<Int>>
}