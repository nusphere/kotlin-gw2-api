package guildwars2.api.wvw.ability

import guildwars2.api.wvw.ability.data.Ability
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AbilityApi {

    @GET("/v2/wvw/abilities")
    suspend fun getAbilityIdsAsync(): Response<List<Int>>

    @GET("/v2/wvw/abilities/{ability_id}")
    suspend fun getAbilityAsync(
        @Path(value = "ability_id", encoded = true) abilityId: Int,
        @Query("lang") lang: String = "en",
    ): Response<Ability>

    @GET("/v2/wvw/abilities")
    suspend fun getAbilitiesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Ability>>
}