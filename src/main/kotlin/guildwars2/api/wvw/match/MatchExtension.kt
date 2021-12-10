package guildwars2.api.wvw.match

import guildwars2.api.wvw.match.data.Match
import retrofit2.Retrofit

interface MatchExtension {
    val retrofit: Retrofit

    suspend fun getMatchIds(): List<String> {
        val api: MatchApi = retrofit.create(MatchApi::class.java)

        return api.getMatchIdsAsync().await()
    }

    suspend fun getMatch(matchId: String): Match? {
        val api: MatchApi = retrofit.create(MatchApi::class.java)

        return try {
            api.getMatchByMatchIdsAsync(matchId).await().first()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getMatchByWorld(worldId: Int): Match? {
        val api: MatchApi = retrofit.create(MatchApi::class.java)

        return try {
            api.getMatchByWorldIdAsync(worldId.toString()).await()
        } catch (e: Exception) {
            return null
        }
    }
}