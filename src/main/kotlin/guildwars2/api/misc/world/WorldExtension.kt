package guildwars2.api.misc.world

import retrofit2.Retrofit

interface WorldExtension {
    val retrofit: Retrofit

    suspend fun getWorld(worldId: Int): World? {
        val api: WorldApi = retrofit.create(WorldApi::class.java)
        val worldCollection: Collection<World>

        try {
            worldCollection = api.getWorldsAsync(worldId.toString()).await()
        } catch (e: Exception) {
            return null
        }

        return worldCollection.first();
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