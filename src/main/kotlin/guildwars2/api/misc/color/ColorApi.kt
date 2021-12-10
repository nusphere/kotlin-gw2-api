package guildwars2.api.misc.color

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorApi {

    /**
     * This resource returns the current build id of the game. This can be used, for example, to register when event timers reset due to server restarts.
     */
    @GET("/v2/colors") fun getColorAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Deferred<Collection<Color>>

    @GET("/v2/colors") fun getColorIdsAsync(): Deferred<Collection<Int>>
}