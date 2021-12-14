package guildwars2.api.misc.world

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface WorldExtension {
    val retrofit: Retrofit

    private val api: WorldApi get() = retrofit.create(WorldApi::class.java)

    fun getWorldIds(): Collection<Int>? = runBlocking { api.getWorldsAsync().body() }

    fun getWorld(worldId: Int): World? = runBlocking {
        return@runBlocking try {
            api.getWorldsAsync(worldId.toString()).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getWorlds(worldIds: MutableList<Int>? = null): List<World>? = runBlocking {
        return@runBlocking try {
            api.getWorldsAsync(worldIds?.joinToString(",") ?: "all").body()
        } catch (e: Exception) {
            null
        }
    }
}