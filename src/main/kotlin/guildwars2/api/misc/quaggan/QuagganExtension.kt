package guildwars2.api.misc.quaggan

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface QuagganExtension {
    val retrofit: Retrofit
    private val api: QuagganApi get() = retrofit.create(QuagganApi::class.java)

    fun getQuagganImageIds(): List<String>? = runBlocking { getQuagganImageIdsResponse().body() }
    fun getQuagganImageIdHeaders(): Headers? = runBlocking { getQuagganImageIdsResponse().headers() }

    fun getQuaggan(quagganId: String): Quaggan? = runBlocking {
        return@runBlocking try {
            getQuaggansResponse(quagganId).body()?.first()
        } catch (e: Exception) {
            null
        }
    }

    fun getQuagganHeaders(quagganId: String): Headers? = runBlocking {
        getQuaggansResponse(quagganId).headers()
    }

    fun getQuaggans(quagganIds: MutableList<String>? = null): List<Quaggan>? = runBlocking {
        return@runBlocking try {
            getQuaggansResponse(quagganIds?.joinToString(",") ?: "all").body()
        } catch (e: Exception) {
            null
        }
    }

    fun getQuaggansHeaders(quagganIds: MutableList<String>? = null): Headers? = runBlocking {
        getQuaggansResponse(quagganIds?.joinToString(",") ?: "all").headers()
    }

    suspend fun getQuagganImageIdsResponse(): Response<List<String>> = api.getQuagganImageIdsAsync()
    suspend fun getQuaggansResponse(ids: String = "all"): Response<List<Quaggan>> = api.getQuaggansAsync()
}