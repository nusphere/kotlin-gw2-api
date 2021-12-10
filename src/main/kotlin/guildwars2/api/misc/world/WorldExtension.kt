package guildwars2.api.misc.world

import retrofit2.Retrofit

interface WorldExtension {
    val retrofit: Retrofit
    private val api: WorldApi get() = retrofit.create(WorldApi::class.java)

    suspend fun getWorldIds(): Collection<Int> = api.getWorldsAsync().await()

    suspend fun getWorld(worldId: Int): World? {
        return try {
            api.getWorldsAsync(worldId.toString()).await().first()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getWorlds(worldIds: MutableList<Int>? = null): Collection<World>? {
        return try {
            api.getWorldsAsync(worldIds?.joinToString(",") ?: "all").await()
        } catch (e: Exception) {
            null
        }
    }
}