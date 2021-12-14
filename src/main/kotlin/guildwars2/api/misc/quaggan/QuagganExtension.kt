package guildwars2.api.misc.quaggan

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface QuagganExtension {
    val retrofit: Retrofit
    private val api: QuagganApi get() = retrofit.create(QuagganApi::class.java)

    fun getQuagganImageIds(): List<String>? = runBlocking { api.getQuagganImageIdsAsync().body() }

    fun getQuaggan(quagganId: String): Quaggan? = runBlocking {
        return@runBlocking try {
            api.getQuaggansAsync(quagganId).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getQuaggans(quagganIds: MutableList<String>? = null): List<Quaggan>? = runBlocking {
        return@runBlocking try {
            api.getQuaggansAsync(quagganIds?.joinToString(",") ?: "all").body()
        } catch (e: Exception) {
            null
        }
    }
}