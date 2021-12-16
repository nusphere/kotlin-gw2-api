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

    suspend fun getQuagganImageIdsResponse(): Response<List<String>> = api.getQuagganImageIdsAsync()

    fun getQuaggan(quagganId: String): Quaggan? = runBlocking { getQuagganResponse(quagganId).body() }
    fun getQuagganHeaders(quagganId: String): Headers? = runBlocking { getQuagganResponse(quagganId).headers() }

    suspend fun getQuagganResponse(quagganId: String): Response<Quaggan> = api.getQuagganAsync(quagganId)

    fun getQuaggans(quagganIds: MutableList<String>? = null): List<Quaggan>? = runBlocking { getQuaggansResponse(quagganIds).body() }
    fun getQuaggansHeaders(quagganIds: MutableList<String>? = null): Headers? = runBlocking { getQuaggansResponse(quagganIds).headers() }

    suspend fun getQuaggansResponse(quagganIds: MutableList<String>? = null): Response<List<Quaggan>> = api.getQuaggansAsync(quagganIds?.joinToString(",") ?: "all")
}