package guildwars2.api.wvw.match

import guildwars2.api.wvw.match.data.Match
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface MatchExtension {
    val retrofit: Retrofit
    private val api: MatchApi get() = retrofit.create(MatchApi::class.java)

    fun getMatchIds(): List<String>? = runBlocking { api.getMatchIdsAsync().body() }

    fun getMatch(matchId: String): Match? = runBlocking {
        return@runBlocking try {
            api.getMatchByMatchIdsAsync(matchId).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getMatchByWorld(worldId: Int): Match? = runBlocking {
        return@runBlocking try {
            api.getMatchByWorldIdAsync(worldId.toString()).body()
        } catch (e: Exception) {
            null
        }
    }
}