package guildwars2.api.misc.color

import guildwars2.api.misc.color.data.Color
import retrofit2.Retrofit

interface ColorExtension {
    val retrofit: Retrofit

    suspend fun getColorIds(): Collection<Int> {
        val api: ColorApi = retrofit.create(ColorApi::class.java)

        return api.getColorIdsAsync().await()
    }

    suspend fun getColor(colorId: Int, language: String = "en"): Color? {
        val api: ColorApi = retrofit.create(ColorApi::class.java)

        guardLanguage(language)

        return try {
            api.getColorAsync(colorId.toString(), language).await().first()
        } catch (e: Exception) {
             null
        }
    }

    suspend fun getColors(colorIds: MutableList<Int>? = null, language: String = "en"): Collection<Color>? {
        val api: ColorApi = retrofit.create(ColorApi::class.java)

        guardLanguage(language)

        return try {
            api.getColorAsync(colorIds?.joinToString(",") ?: "all", language).await()
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