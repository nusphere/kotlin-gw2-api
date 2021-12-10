package guildwars2.api.misc.world

import retrofit2.Retrofit

interface WorldExtension {
    val retrofit: Retrofit

    suspend fun getWorld(worldId: Int): World? {
        val api: WorldApi = retrofit.create(WorldApi::class.java)

        return try {
            api.getWorldsAsync(worldId.toString()).await().first()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getWorlds(worldIds: MutableList<Int>? = null): Collection<World>? {
        val api: WorldApi = retrofit.create(WorldApi::class.java)

        return try {
            api.getWorldsAsync(worldIds?.joinToString(",") ?: "all").await()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getWorldIds(): Collection<Int> {
        val api: WorldApi = retrofit.create(WorldApi::class.java)
        return api.getWorldsAsync().await()
    }
}