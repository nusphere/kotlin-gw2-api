package guildwars2.api.wvw.wvw

import retrofit2.Retrofit

interface WvWExtension {
    val retrofit: Retrofit
    private val api: WvWApi get() = retrofit.create(WvWApi::class.java)

    suspend fun getApiTypes(): List<String> = api.getApiTypesAsync().await()
}