package guildwars2.api.wvw.wvw

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface WvWExtension {
    val retrofit: Retrofit
    private val api: WvWApi get() = retrofit.create(WvWApi::class.java)

    fun getApiTypes(): List<String> = runBlocking { api.getApiTypesAsync().await() }
}