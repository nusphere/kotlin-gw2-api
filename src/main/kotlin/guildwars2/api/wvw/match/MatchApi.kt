package guildwars2.api.wvw.match

import guildwars2.api.wvw.match.data.Match
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchApi {

    /**
     * This resource provides a list of Ids the matches.
     */
    @GET("/v2/wvw/matches")
    suspend fun getMatchIdsAsync(): Response<List<String>>

    /**
     * This resource provides matches by using match ids.
     */
    @GET("/v2/wvw/matches")
    suspend fun getMatchByMatchIdsAsync(
        @Query("ids") ids: String = "all"
    ): Response<List<Match>>

    /**
     * This resource provides matches by using world id.
     */
    @GET("/v2/wvw/matches")
    suspend fun getMatchByWorldIdAsync(
        @Query("world") worldId: String
    ): Response<Match>
}