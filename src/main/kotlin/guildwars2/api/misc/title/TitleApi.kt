package guildwars2.api.misc.title

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TitleApi {

    /**
     * This resource returns information about the titles that are in the game.
     *
     * https://api.guildwars2.com/v2/titles?ids=222,300,369&lang=de
     */
    @GET("/v2/titles")
    suspend fun getTitlesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Title>>

    @GET("/v2/titles/{title_id}")
    suspend fun getTitleAsync(
        @Path(value = "title_id", encoded = true) titleId: Int,
        @Query("lang") lang: String = "en",
    ): Response<Title>

    @GET("/v2/titles")
    suspend fun getTitleIdsAsync(): Response<List<Int>>
}