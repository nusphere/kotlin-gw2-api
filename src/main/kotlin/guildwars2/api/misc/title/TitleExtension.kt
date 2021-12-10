package guildwars2.api.misc.title

import retrofit2.Retrofit

interface TitleExtension {
    val retrofit: Retrofit

    suspend fun getTitle(titleId: Int, language: String = "en"): Title? {
        val api: TitleApi = retrofit.create(TitleApi::class.java)
        val titleCollection: Collection<Title>

        // test language str
        guardLanguage(language)

        try {
            titleCollection = api.getTitlesAsync(titleId.toString(), language).await()
        } catch (e: Exception) {
            return null
        }

        return titleCollection.first()
    }

    suspend fun getTitleIds(): Collection<Int> {
        val api: TitleApi = retrofit.create(TitleApi::class.java)

        return api.getTitleIdsAsync().await()
    }

    suspend fun getTitles(titleIds: MutableList<Int>? = null, language: String = "en"): Collection<Title>? {
        val api: TitleApi = retrofit.create(TitleApi::class.java)

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