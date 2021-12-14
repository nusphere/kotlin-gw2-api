package guildwars2.api.misc.title

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface TitleExtension {
    val retrofit: Retrofit
    private val api: TitleApi get() = retrofit.create(TitleApi::class.java)

    fun getTitleIds(): List<Int>? = runBlocking { api.getTitleIdsAsync().body() }

    fun getTitle(titleId: Int, language: String = "en"): Title? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getTitlesAsync(titleId.toString(), language).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getTitles(titleIds: MutableList<Int>? = null, language: String = "en"): List<Title>? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getTitlesAsync(titleIds?.joinToString(",") ?: "all", language).body()
        } catch (e: Exception) {
            null
        }
    }

    private fun guardLanguage(language: String?) {
        if (language?.length?.equals(2) != true) {
            throw Exception("wrong language code")
        }
    }
}