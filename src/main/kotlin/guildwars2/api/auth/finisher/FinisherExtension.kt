package guildwars2.api.auth.finisher

import guildwars2.api.auth.tokeninfo.Permission
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface FinisherExtension: Permission {
    override val retrofit: Retrofit
    private val api: FinisherApi get() = retrofit.create(FinisherApi::class.java)

    fun getFinisher(): List<AccountFinisher>? = runBlocking {
        return@runBlocking getFinisherResponse()?.body()
    }

    fun getFinisherHeaders(): Headers? = runBlocking {
        return@runBlocking getFinisherResponse()?.headers()
    }

    suspend fun getFinisherResponse(): Response<List<AccountFinisher>>? {
        guardPermission("account")

        return api.getFinisherAsync()
    }
}