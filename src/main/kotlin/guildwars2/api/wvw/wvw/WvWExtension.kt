package guildwars2.api.wvw.wvw

import retrofit2.Retrofit

interface WvWExtension {
    val retrofit: Retrofit

    suspend fun getApiTypes(): List<String> {
        val api: WvWApi = retrofit.create(WvWApi::class.java)

        return api.getApiTypesAsync().await()
    }
}