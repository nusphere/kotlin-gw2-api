package guildwars2.api.auth.tokeninfo

import kotlinx.coroutines.runBlocking
import retrofit2.Retrofit

interface Permission {
    val retrofit: Retrofit

    fun guardPermission(requirePermission: String): Boolean = runBlocking {
        val api: TokenInfoApi = retrofit.create(TokenInfoApi::class.java)

        val permissions = api.getTokenInfoAsync().body()?.permissions

        if (permissions === null || !permissions.contains(requirePermission)) {
            throw Exception("token has no permission for $requirePermission")
        }

        return@runBlocking true
    }
}