package guildwars2.api.auth.tokeninfo

import retrofit2.Retrofit

interface Permission {
    val retrofit: Retrofit

    suspend fun guardPermission(requirePermission: String): Boolean {
        val api: TokenInfoApi = retrofit.create(TokenInfoApi::class.java)

        val permissions = api.getTokenInfoAsync().await().permissions

        if (!permissions.contains(requirePermission)) {
            throw Exception("token has no permission for $requirePermission")
        }

        return true
    }
}