package guildwars2.api.wvw.match

import guildwars2.api.wvw.match.data.Match
import retrofit2.Retrofit

interface MatchExtension {
    val retrofit: Retrofit
    private val api: MatchApi get() = retrofit.create(MatchApi::class.java)

    suspend fun getMatchIds(): List<String> = api.getMatchIdsAsync().await()

    suspend fun getMatch(matchId: String): Match? {
        return try {
            api.getMatchByMatchIdsAsync(matchId).await().first()
        } catch (e: Exception) {
            return null
        }
    }

    suspend fun getMatchByWorld(worldId: Int): Match? {
        return try {
            api.getMatchByWorldIdAsync(worldId.toString()).await()
        } catch (e: Exception) {
            return null
        }
    }
}