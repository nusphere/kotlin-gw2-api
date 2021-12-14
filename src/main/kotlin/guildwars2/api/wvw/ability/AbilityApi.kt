package guildwars2.api.wvw.ability

import guildwars2.api.wvw.ability.data.Ability
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AbilityApi {

    /**
     * This resource returns all quaggan images ids.
     */
    @GET("/v2/abilities")
    suspend fun getAbilityIdsAsync(): Response<List<Int>>

    /**
     * This resource returns quaggan images.
     */
    @GET("/v2/abilities")
    suspend fun getAbilitiesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Ability>>
}