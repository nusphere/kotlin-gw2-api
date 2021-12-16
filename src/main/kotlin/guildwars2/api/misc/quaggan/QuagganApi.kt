package guildwars2.api.misc.quaggan

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuagganApi {

    /**
     * This resource returns all quaggan images ids.
     */
    @GET("/v2/quaggans")
    suspend fun getQuagganImageIdsAsync(): Response<List<String>>

    /**
     * This resource returns quaggan images.
     */
    @GET("/v2/quaggans/{quaggan_id}")
    suspend fun getQuagganAsync(
        @Path(value = "quaggan_id", encoded = true) quagganId: String,
    ): Response<Quaggan>

    /**
     * This resource returns quaggan images.
     */
    @GET("/v2/quaggans")
    suspend fun getQuaggansAsync(
        @Query("ids") ids: String = "all"
    ): Response<List<Quaggan>>
}