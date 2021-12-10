package guildwars2.api.misc.build

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface BuildExtension {
    val retrofit: Retrofit
    private val api: BuildApi get() = retrofit.create(BuildApi::class.java)

    fun getBuild(): Build = runBlocking { api.getBuildAsync().await() }
}