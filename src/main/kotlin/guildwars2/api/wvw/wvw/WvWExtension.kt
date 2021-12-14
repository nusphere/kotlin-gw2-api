package guildwars2.api.wvw.wvw

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface WvWExtension {
    val retrofit: Retrofit
    private val api: WvWApi get() = retrofit.create(WvWApi::class.java)

    fun getApiTypes(): List<String>? = runBlocking { getApiTypesResponse().body() }

    fun getApiTypeHeaders(): Headers? = runBlocking { getApiTypesResponse().headers() }

    suspend fun getApiTypesResponse(): Response<List<String>> = api.getApiTypesAsync()
}