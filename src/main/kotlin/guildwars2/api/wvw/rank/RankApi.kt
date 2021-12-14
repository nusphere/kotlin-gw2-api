package guildwars2.api.wvw.rank

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RankApi {

    @GET("/v2/wvw/ranks")
    suspend fun getRankIdsAsync(): Response<List<Int>>

    @GET("/v2/wvw/ranks/{rank_id}")
    suspend fun getRankAsync(
        @Path(value = "rank_id", encoded = true) rankId: Int,
        @Query("lang") lang: String = "en"
    ): Response<Rank>


    @GET("/v2/wvw/ranks")
    suspend fun getRanksAsync(
        @Query(value = "id", encoded = true) rankId: String = "all",
        @Query("lang") lang: String = "en"
    ): Response<List<Rank>>
}