package guildwars2.api.wvw.wvw

import retrofit2.Retrofit

interface WvWExtension {
    val retrofit: Retrofit

    suspend fun getWvWTypes(): List<String> {
        val api: WvWApi = retrofit.create(WvWApi::class.java)

        return api.getWvWTypesAsync().await()
    }
}