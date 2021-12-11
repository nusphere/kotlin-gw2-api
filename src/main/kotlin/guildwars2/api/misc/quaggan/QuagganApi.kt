package guildwars2.api.misc.quaggan

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface QuagganApi {

    /**
     * This resource returns all quaggan images ids.
     */
    @GET("/v2/quaggans") fun getQuagganImageIdsAsync(): Deferred<List<String>>

    /**
     * This resource returns quaggan images.
     */
    @GET("/v2/quaggans") fun getQuaggansAsync(@Query("ids") ids: String = "all"): Deferred<List<Quaggan>>
}