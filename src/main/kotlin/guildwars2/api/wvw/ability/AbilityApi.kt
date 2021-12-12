package guildwars2.api.wvw.ability

import guildwars2.api.wvw.ability.data.Ability
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface AbilityApi {

    /**
     * This resource returns all quaggan images ids.
     */
    @GET("/v2/abilities") fun getAbilityIdsAsync(): Deferred<List<Int>>

    /**
     * This resource returns quaggan images.
     */
    @GET("/v2/abilities") fun getAbilitiesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Deferred<List<Ability>>
}