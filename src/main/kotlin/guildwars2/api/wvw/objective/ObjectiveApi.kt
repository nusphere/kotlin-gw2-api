package guildwars2.api.wvw.objective

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ObjectiveApi {

    @GET("/v2/wvw/objectives")
    suspend fun getObjectiveIdsAsync(): Response<List<String>>

    @GET("/v2/wvw/objectives/{objective_id}")
    suspend fun getObjectiveAsync(
        @Path(value = "objective_id", encoded = true) objectiveId: String,
        @Query("lang") lang: String = "en",
    ): Response<Objective>
}