package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CurrencyTest: GW2MockApi() {

    @Test
    fun getCurrencyIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/currencies.json").content))
        }

        val testApi = Api("valid_api_key")
        val titleIds = testApi.Misc(retrofit).getCurrencyIds()

        assertEquals(56, titleIds?.size)
    }

    @Test
    fun getCurrencyIdsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/currencies.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getCurrencyIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getCurrencyApiTest() {
        val content = MockResponseFileReader("json/misc/currency-54.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val currency = testApi.Misc(retrofit).getCurrency(54, "de")

        assertEquals(54, currency?.id)
        assertEquals("Blue Prophet Crystal", currency?.name)
        assertEquals("Crystalline formations of dragon magic, veined with blue.\n" +
                "Emissaries in the Eye of the North have interest in these.\n" +
                "Obtained from Priority Strikes or by combining shards.", currency?.description)
        assertEquals(351, currency?.order)
        assertEquals("https://render.guildwars2.com/file/2F531F63F5A9A93C624A3CDDC73F9078C00E5097/2270830.png", currency?.icon)
    }

    @Test
    fun getCurrencyHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/currency-54.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getCurrencyHeaders(54, "de")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getCurrenciesApiTest() {
        val content = MockResponseFileReader("json/misc/currencies-all.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(12, 45)
        val currencies = testApi.Misc(retrofit).getCurrencies(list, "de")

        assertEquals(56, currencies?.size)
    }

    @Test
    fun getCurrenciesHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/currencies-all.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(12, 45)
        val headers = testApi.Misc(retrofit).getCurrenciesHeaders(list, "de")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}