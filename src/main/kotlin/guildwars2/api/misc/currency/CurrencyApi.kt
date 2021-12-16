package guildwars2.api.misc.currency

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CurrencyApi {

    @GET("/v2/currencies")
    suspend fun getCurrencyIdsAsync(): Response<List<String>>

    @GET("/v2/currencies/{currency_id}")
    suspend fun getCurrencyAsync(
        @Path(value = "currency_id", encoded = true) currencyId: Int,
        @Query("lang") lang: String = "en",
    ): Response<Currency>

    @GET("/v2/currencies")
    suspend fun getCurrenciesAsync(
        @Query("ids") ids: String = "all",
        @Query("lang") lang: String = "en",
    ): Response<List<Currency>>
}