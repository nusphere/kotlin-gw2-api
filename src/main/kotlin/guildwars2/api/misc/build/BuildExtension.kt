package guildwars2.api.misc.build

import retrofit2.Retrofit

interface BuildExtension {
    val retrofit: Retrofit

    suspend fun getBuild(): Build {
        val api: BuildApi = retrofit.create(BuildApi::class.java)

        return api.getBuildAsync().await()
    }
}