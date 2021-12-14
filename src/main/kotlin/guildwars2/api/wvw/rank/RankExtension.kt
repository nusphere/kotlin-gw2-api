package guildwars2.api.wvw.rank

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface RankExtension {
    val retrofit: Retrofit
    private val api: RankApi get() = retrofit.create(RankApi::class.java)

    fun getRankIds(): List<Int>? = runBlocking { getRankIdResponse().body() }
    fun getRankIdHeaders(): Headers? = runBlocking { getRankIdResponse().headers() }

    suspend fun getRankIdResponse(): Response<List<Int>> = api.getRankIdsAsync()

    fun getRank(rankId: Int, language: String = "en"): Rank? = runBlocking {
        return@runBlocking try {
            getRankResponse(rankId, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getRankHeaders(rankId: Int, language: String = "en"): Headers? = runBlocking {
        return@runBlocking getRankResponse(rankId, language).headers()
    }

    suspend fun getRankResponse(rankId: Int, language: String = "en"): Response<Rank> = api.getRankAsync(rankId, language)

    fun getRanks(rankIds: MutableList<Int>? = null, language: String = "en"): List<Rank>? = runBlocking {
        return@runBlocking try {
            getRanksResponse(rankIds, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getRanksHeaders(rankIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking {
        return@runBlocking getRanksResponse(rankIds, language).headers()
    }

    suspend fun getRanksResponse(rankIds: MutableList<Int>? = null, language: String = "en"): Response<List<Rank>> {
        return api.getRanksAsync(rankIds?.joinToString(",") ?: "all", language)
    }
}