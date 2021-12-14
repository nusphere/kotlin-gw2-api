package guildwars2.api.wvw.upgrade

import guildwars2.api.wvw.upgrade.data.Upgrade
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UpgradeApi {

    @GET("/v2/wvw/upgrades")
    suspend fun getUpgradeIdsAsync(): Response<List<Int>>

    @GET("/v2/wvw/upgrades/{upgrade_id}")
    suspend fun getUpgradeAsync(
        @Path(value = "upgrade_id", encoded = true) upgradeId: Int,
        @Query("lang") lang: String = "en"
    ): Response<Upgrade>
}