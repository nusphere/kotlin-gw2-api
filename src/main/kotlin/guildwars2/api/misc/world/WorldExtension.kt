package guildwars2.api.misc.world

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface WorldExtension {
    val retrofit: Retrofit

    private val api: WorldApi get() = retrofit.create(WorldApi::class.java)

    fun getWorldIds(): List<Int>? = runBlocking { getWorldIdsResponse().body() }
    fun getWorldIdHeaders(): Headers? = runBlocking { getWorldIdsResponse().headers() }

    suspend fun getWorldIdsResponse(): Response<List<Int>> = api.getWorldIdsAsync()

    fun getWorld(worldId: Int, language: String = "en"): World? = runBlocking {
        return@runBlocking try {
            getWorldResponse(worldId, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getWorldHeaders(worldId: Int, language: String = "en"): Headers? = runBlocking { getWorldResponse(worldId, language).headers() }

    suspend fun getWorldResponse(worldId: Int, language: String = "en"): Response<World> = api.getWorldAsync(worldId, language)

    fun getWorlds(worldIds: MutableList<Int>? = null, language: String = "en"): List<World>? = runBlocking {
        return@runBlocking try {
            getWorldsResponse(worldIds, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getWorldsHeaders(worldIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking { getWorldsResponse(worldIds, language).headers() }

    suspend fun getWorldsResponse(worldIds: MutableList<Int>? = null, language: String = "en"): Response<List<World>> = api.getWorldsAsync(worldIds?.joinToString(",") ?: "all", language)
}