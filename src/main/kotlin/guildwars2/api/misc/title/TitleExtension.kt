package guildwars2.api.misc.title

import retrofit2.Retrofit

interface TitleExtension {
    val retrofit: Retrofit
    private val api: TitleApi get() = retrofit.create(TitleApi::class.java)

    suspend fun getTitleIds(): Collection<Int> = api.getTitleIdsAsync().await()

    suspend fun getTitle(titleId: Int, language: String = "en"): Title? {
        guardLanguage(language)

        return try {
            api.getTitlesAsync(titleId.toString(), language).await().first()
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getTitles(titleIds: MutableList<Int>? = null, language: String = "en"): Collection<Title>? {
        guardLanguage(language)

        return try {
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