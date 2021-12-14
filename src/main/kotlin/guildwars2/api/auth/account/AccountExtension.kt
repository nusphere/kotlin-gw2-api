package guildwars2.api.auth.account

import guildwars2.api.auth.tokeninfo.Permission
import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface AccountExtension: Permission {
    override val retrofit: Retrofit
    private val api: AccountApi get() = retrofit.create(AccountApi::class.java)

    fun getAccount(): Account? = runBlocking {
        return@runBlocking getAccountResponse()?.body()
    }

    fun getAccountHeader(): Headers? = runBlocking {
        return@runBlocking getAccountResponse()?.headers()
    }

    suspend fun getAccountResponse(): Response<Account>? {
        guardPermission("account")

        return api.getAccountAsync()
    }
}