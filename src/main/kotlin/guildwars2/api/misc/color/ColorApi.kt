package guildwars2.api.misc.color

import guildwars2.api.misc.color.data.Color
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ColorApi {

    /**
     * This resource returns the current build id of the game. This can be used, for example, to register when event timers reset due to server restarts.
     */
    @GET("/v2/colors")
    suspend fun getColorAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Color>>

    @GET("/v2/colors")
    suspend fun getColorIdsAsync(): Response<List<Int>>
}