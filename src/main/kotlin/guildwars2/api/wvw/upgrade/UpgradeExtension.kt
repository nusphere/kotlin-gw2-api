package guildwars2.api.wvw.upgrade

import guildwars2.api.wvw.upgrade.data.Upgrade
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface UpgradeExtension {
    val retrofit: Retrofit
    private val api: UpgradeApi get() = retrofit.create(UpgradeApi::class.java)

    fun getUpgradeIds(): List<Int>? = runBlocking { getUpdateIdResponse().body() }
    fun getUpgradeIdHeaders(): Headers? = runBlocking { getUpdateIdResponse().headers() }

    fun getUpgrade(upgradeId: Int, language: String = "en"): Upgrade? = runBlocking {
        return@runBlocking try {
            getUpdateResponse(upgradeId.toString(), language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getUpgradeHeaders(upgradeId: Int, language: String = "en"): Headers? = runBlocking {
        return@runBlocking getUpdateResponse(upgradeId.toString(), language).headers()
    }

    suspend fun getUpdateIdResponse(): Response<List<Int>> = api.getUpgradeIdsAsync()
    suspend fun getUpdateResponse(upgradeId: String, language: String = "en"): Response<Upgrade> = api.getUpgradeAsync(upgradeId, language)
}