package guildwars2.api.misc.color

import guildwars2.api.misc.color.data.Color
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface ColorExtension {
    val retrofit: Retrofit
    private val api: ColorApi get() = retrofit.create(ColorApi::class.java)

    fun getColorIds(): List<Int>? = runBlocking { getColorIdsResponse().body() }
    fun getColorIdHeaders(): Headers? = runBlocking { getColorIdsResponse().headers() }

    suspend fun getColorIdsResponse(): Response<List<Int>> = api.getColorIdsAsync()

    fun getColor(colorId: Int, language: String = "en"): Color? = runBlocking { getColorResponse(colorId, language).body() }
    fun getColorHeaders(colorId: Int, language: String = "en"): Headers? = runBlocking { getColorResponse(colorId, language).headers() }

    suspend fun getColorResponse(colorId: Int, language: String = "en"): Response<Color> {
        guardLanguage(language)

        return api.getColorAsync(colorId, language)
    }

    fun getColors(colorIds: MutableList<Int>? = null, language: String = "en"): List<Color>? = runBlocking { getColorsResponse(colorIds, language).body() }
    fun getColorsHeaders(colorIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking { getColorsResponse(colorIds, language).headers() }

    suspend fun getColorsResponse(colorIds: MutableList<Int>? = null, language: String = "en"): Response<List<Color>> {
        guardLanguage(language)

        return api.getColorsAsync(colorIds?.joinToString(",") ?: "all", language)
    }

    private fun guardLanguage(language: String?) {
        if (language?.length?.equals(2) != true) {
            throw Exception("wrong language code")
        }
    }
}