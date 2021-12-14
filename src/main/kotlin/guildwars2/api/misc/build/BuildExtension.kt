package guildwars2.api.misc.build

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface BuildExtension {
    val retrofit: Retrofit
    private val api: BuildApi get() = retrofit.create(BuildApi::class.java)

    fun getBuild(): Build? = runBlocking { getAccountResponse()?.body() }

    fun getBuildHeaders(): Headers? = runBlocking { getAccountResponse()?.headers() }

    suspend fun getAccountResponse(): Response<Build>? = api.getBuildAsync()
}