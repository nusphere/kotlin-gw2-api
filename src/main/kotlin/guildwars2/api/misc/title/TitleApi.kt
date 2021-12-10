package guildwars2.api.misc.title

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface TitleApi {

    /**
     * This resource returns information about the titles that are in the game.
     *
     * https://api.guildwars2.com/v2/titles?ids=30
     * https://api.guildwars2.com/v2/titles?ids=222&lang=de
     * https://api.guildwars2.com/v2/titles?ids=222,300,369&lang=de
     */
    @GET("/v2/titles") fun getTitlesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Deferred<Collection<Title>>

    @GET("/v2/titles") fun getTitleIdsAsync(): Deferred<Collection<Int>>
}