package guildwars2.api.auth.account

import guildwars2.api.auth.tokeninfo.Permission
import retrofit2.Retrofit

interface AccountExtension: Permission {
    override val retrofit: Retrofit
    private val api: AccountApi get() = retrofit.create(AccountApi::class.java)

    suspend fun getAccount(): Account {
        guardPermission("account")

        return api.getAccount().await()
    }
}