package guildwars2.api.auth.dyes

import guildwars2.api.auth.tokeninfo.Permission
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface DyesExtension: Permission {
    override val retrofit: Retrofit
    private val api: DyesApi get() = retrofit.create(DyesApi::class.java)

    fun getDyesIds(): List<Int>? = runBlocking { getDyesResponse()?.body() }

    fun getDyesHeaders(): Headers? = runBlocking { getDyesResponse()?.headers() }

    suspend fun getDyesResponse(): Response<List<Int>>? {
        guardPermission("account")

        return api.getDyesAsync()
    }
}