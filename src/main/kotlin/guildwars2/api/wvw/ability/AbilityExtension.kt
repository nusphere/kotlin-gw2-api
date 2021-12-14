package guildwars2.api.wvw.ability

import guildwars2.api.wvw.ability.data.Ability
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface AbilityExtension {
    val retrofit: Retrofit
    private val api: AbilityApi get() = retrofit.create(AbilityApi::class.java)

    fun getAbilityIds(): List<Int>? = runBlocking { api.getAbilityIdsAsync().body() }

    fun getAbility(abilityId: Int, language: String = "en"): Ability? = runBlocking {
        return@runBlocking try {
            api.getAbilitiesAsync(abilityId.toString(), language).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getAbilities(abilityId: MutableList<Int>? = null, language: String = "en"): List<Ability>? = runBlocking {
        return@runBlocking try {
            api.getAbilitiesAsync(abilityId?.joinToString(",") ?: "all", language).body()
        } catch (e: Exception) {
            null
        }
    }
}