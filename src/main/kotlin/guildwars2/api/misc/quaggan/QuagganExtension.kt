package guildwars2.api.misc.quaggan

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface QuagganExtension {
    val retrofit: Retrofit
    private val api: QuagganApi get() = retrofit.create(QuagganApi::class.java)

    fun getQuagganImageIds(): List<String> = runBlocking { api.getQuagganImageIdsAsync().await() }

    fun getQuaggan(quagganId: String): Quaggan? = runBlocking {
        return@runBlocking try {
            api.getQuaggansAsync(quagganId).await().first()
        } catch (e: Exception) {
            null
        }
    }

    fun getQuaggans(quagganIds: MutableList<String>? = null): Collection<Quaggan>? = runBlocking {
        return@runBlocking try {
            api.getQuaggansAsync(quagganIds?.joinToString(",") ?: "all").await()
        } catch (e: Exception) {
            null
        }
    }
}