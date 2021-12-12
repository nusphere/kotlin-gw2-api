package guildwars2.api.wvw.abilities

import guildwars2.api.wvw.abilities.data.Ability
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface AbilityExtension {
    val retrofit: Retrofit
    private val api: AbilityApi get() = retrofit.create(AbilityApi::class.java)

    fun getAbilityIds(): List<Int> = runBlocking { api.getAbilityIdsAsync().await() }

    fun getAbility(abilityId: Int, language: String = "en"): Ability? = runBlocking {
        return@runBlocking try {
            api.getAbilitiesAsync(abilityId.toString(), language).await().first()
        } catch (e: Exception) {
            null
        }
    }

    fun getAbilities(abilityId: MutableList<Int>? = null, language: String = "en"): Collection<Ability>? = runBlocking {
        return@runBlocking try {
            api.getAbilitiesAsync(abilityId?.joinToString(",") ?: "all", language).await()
        } catch (e: Exception) {
            null
        }
    }
}