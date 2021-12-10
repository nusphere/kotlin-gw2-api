package guildwars2.api.wvw.wvw

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface WvWApi {

    /**
     * This resource provides information about the v2/wvw endpoints.
     */
    @GET("/v2/wvw") fun getWvWTypesAsync(): Deferred<List<String>>
}