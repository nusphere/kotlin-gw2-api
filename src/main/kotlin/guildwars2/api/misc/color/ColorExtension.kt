package guildwars2.api.misc.color

import guildwars2.api.misc.color.data.Color
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface ColorExtension {
    val retrofit: Retrofit
    private val api: ColorApi get() = retrofit.create(ColorApi::class.java)

    fun getColorIds(): List<Int>? = runBlocking { api.getColorIdsAsync().body() }

    fun getColor(colorId: Int, language: String = "en"): Color? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getColorAsync(colorId.toString(), language).body()?.first()
        } catch (e: Exception) {
             null
        }
    }

    fun getColors(colorIds: MutableList<Int>? = null, language: String = "en"): List<Color>? = runBlocking {
        guardLanguage(language)

        return@runBlocking try {
            api.getColorAsync(colorIds?.joinToString(",") ?: "all", language).body()
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