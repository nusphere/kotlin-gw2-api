package guildwars2.api.misc.build

import retrofit2.Retrofit

interface BuildExtension {
    val retrofit: Retrofit
    private val api: BuildApi get() = retrofit.create(BuildApi::class.java)

    suspend fun getBuild(): Build = api.getBuildAsync().await()
}