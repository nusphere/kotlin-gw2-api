package guildwars2.api.misc.title

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface TitleExtension {
    val retrofit: Retrofit
    private val api: TitleApi get() = retrofit.create(TitleApi::class.java)

    fun getTitleIds(): Collection<Int> = runBlocking { api.getTitleIdsAsync().await() }

    fun getTitle(titleId: Int, language: String = "en"): Title? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getTitlesAsync(titleId.toString(), language).await().first()
        } catch (e: Exception) {
            null
        }
    }

    fun getTitles(titleIds: MutableList<Int>? = null, language: String = "en"): Collection<Title>? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getTitlesAsync(titleIds?.joinToString(",") ?: "all", language).await()
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