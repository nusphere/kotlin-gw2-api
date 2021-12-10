package guildwars2.api.wvw.match

import guildwars2.api.wvw.match.data.Match
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchApi {

    /**
     * This resource provides a list of Ids the matches.
     */
    @GET("/v2/wvw/matches") fun getMatchIdsAsync(): Deferred<List<String>>

    /**
     * This resource provides matches by using match ids.
     */
    @GET("/v2/wvw/matches") fun getMatchByMatchIdsAsync(
        @Query("ids") ids: String = "all"
    ): Deferred<Collection<Match>>

    /**
     * This resource provides matches by using world id.
     */
    @GET("/v2/wvw/matches") fun getMatchByWorldIdAsync(
        @Query("world") worldId: String
    ): Deferred<Match>
}