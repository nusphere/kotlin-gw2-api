package guildwars2.api.misc.currency

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface CurrencyExtension {
    val retrofit: Retrofit
    private val api: CurrencyApi get() = retrofit.create(CurrencyApi::class.java)

    fun getCurrencyIds(): List<String>? = runBlocking { getCurrencyIdsResponse().body() }
    fun getCurrencyIdHeaders(): Headers? = runBlocking { getCurrencyIdsResponse().headers() }

    suspend fun getCurrencyIdsResponse(): Response<List<String>> = api.getCurrencyIdsAsync()

    fun getCurrency(currencyId: Int, language: String = "en"): Currency? = runBlocking { getCurrencyResponse(currencyId, language).body() }
    fun getCurrencyHeaders(currencyId: Int, language: String = "en"): Headers? = runBlocking { getCurrencyResponse(currencyId, language).headers() }

    suspend fun getCurrencyResponse(currencyId: Int, language: String = "en"): Response<Currency> = api.getCurrencyAsync(currencyId, language)

    fun getCurrencies(currencyIds: MutableList<Int>? = null, language: String = "en"): List<Currency>? = runBlocking { getCurrenciesResponse(currencyIds, language).body() }
    fun getCurrenciesHeaders(currencyIds: MutableList<Int>? = null, language: String = "en"): Headers? = runBlocking { getCurrenciesResponse(currencyIds, language).headers() }

    suspend fun getCurrenciesResponse(currencyIds: MutableList<Int>? = null, language: String = "en"): Response<List<Currency>> = api.getCurrenciesAsync(currencyIds?.joinToString(",") ?: "all", language)
}