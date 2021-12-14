package guildwars2.api.misc.color

import guildwars2.api.misc.color.data.Color
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ColorApi {

    @GET("/v2/colors")
    suspend fun getColorIdsAsync(): Response<List<Int>>

    @GET("/v2/colors/{color_id}")
    suspend fun getColorAsync(
        @Path(value = "color_id", encoded = true) colorId: Int,
        @Query("lang") lang: String = "en",
    ): Response<Color>

    @GET("/v2/colors")
    suspend fun getColorsAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Color>>

}