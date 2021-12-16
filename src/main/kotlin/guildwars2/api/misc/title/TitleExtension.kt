package guildwars2.api.misc.title

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface TitleExtension {
    val retrofit: Retrofit
    private val api: TitleApi get() = retrofit.create(TitleApi::class.java)

    fun getTitleIds(): List<Int>? = runBlocking { getTitleIdsResponse().body() }
    fun getTitleIdHeaders(): Headers? = runBlocking { getTitleIdsResponse().headers() }

    suspend fun getTitleIdsResponse(): Response<List<Int>> = api.getTitleIdsAsync()

    fun getTitle(titleId: Int, language: String = "en"): Title? = runBlocking { getTitleResponse(titleId, language).body() }
    fun getTitleHeaders(titleId: Int, language: String = "en"): Headers? = runBlocking { getTitleResponse(titleId, language).headers() }

    suspend fun getTitleResponse(titleId: Int, language: String = "en"): Response<Title> {
        guardLanguage(language)

        return api.getTitleAsync(titleId, language)
    }

    fun getTitles(titleIds: MutableList<Int>? = null, language: String = "en"): List<Title>? = runBlocking { getTitlesResponse(titleIds, language).body() }
    fun getTitleHeaders(titleIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking { getTitlesResponse(titleIds, language).headers() }

    suspend fun getTitlesResponse(titleIds: MutableList<Int>? = null, language: String = "en"): Response<List<Title>> {
        guardLanguage(language)

        return api.getTitlesAsync(titleIds?.joinToString(",") ?: "all", language)
    }

    private fun guardLanguage(language: String?) {
        if (language?.length?.equals(2) != true) {
            throw Exception("wrong language code")
        }
    }
}