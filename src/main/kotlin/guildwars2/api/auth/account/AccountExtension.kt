package guildwars2.api.auth.account

import guildwars2.api.auth.tokeninfo.Permission
import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface AccountExtension: Permission {
    override val retrofit: Retrofit
    private val api: AccountApi get() = retrofit.create(AccountApi::class.java)

    fun getAccount(): Account = runBlocking {
        guardPermission("account")

        return@runBlocking api.getAccountAsync().await()
    }
}