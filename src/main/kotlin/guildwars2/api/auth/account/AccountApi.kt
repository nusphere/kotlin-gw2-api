package guildwars2.api.auth.account

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface AccountApi {

    /**
     *
     */
    @GET("/v2/account") fun getAccount(): Deferred<Account>
}