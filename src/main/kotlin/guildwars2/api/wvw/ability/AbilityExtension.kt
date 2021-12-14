package guildwars2.api.wvw.ability

import guildwars2.api.wvw.ability.data.Ability
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface AbilityExtension {
    val retrofit: Retrofit
    private val api: AbilityApi get() = retrofit.create(AbilityApi::class.java)

    fun getAbilityIds(): List<Int>? = runBlocking { getAbilityIdsResponse().body() }
    fun getAbilityIdHeaders(): Headers? = runBlocking { getAbilityIdsResponse().headers() }

    suspend fun getAbilityIdsResponse(): Response<List<Int>> = api.getAbilityIdsAsync()

    fun getAbility(abilityId: Int, language: String = "en"): Ability? = runBlocking {
        return@runBlocking try {
            getAbilityResponse(abilityId, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getAbilityHeaders(abilityId: Int, language: String = "en"): Headers? = runBlocking {
        getAbilityResponse(abilityId, language).headers()
    }

    suspend fun getAbilityResponse(abilityId: Int, language: String = "en"): Response<Ability> = api.getAbilityAsync(abilityId, language)

    fun getAbilities(abilityIds: MutableList<Int>? = null, language: String = "en"): List<Ability>? = runBlocking {
        return@runBlocking try {
            getAbilitiesResponse(abilityIds, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getAbilitiesHeaders(abilityIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking {
        getAbilitiesResponse(abilityIds, language).headers()
    }

    suspend fun getAbilitiesResponse(abilityId: MutableList<Int>? = null, language: String = "en"): Response<List<Ability>> {
        return api.getAbilitiesAsync(abilityId?.joinToString(",") ?: "all", language)
    }
}