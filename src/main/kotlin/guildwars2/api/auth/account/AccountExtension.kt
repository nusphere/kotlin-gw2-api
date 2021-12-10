package guildwars2.api.auth.account

import guildwars2.api.auth.tokeninfo.Permission
import retrofit2.Retrofit

interface AccountExtension: Permission {
    override val retrofit: Retrofit

    suspend fun getAccount(): Account {
        guardPermission("account")

        val api: AccountApi = retrofit.create(AccountApi::class.java)

        return api.getAccount().await()
    }
}