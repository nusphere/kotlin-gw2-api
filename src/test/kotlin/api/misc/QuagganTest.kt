package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class QuagganTest: GW2MockApi() {

    @Test
    fun useQuagganImageIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/quaggans.json").content))
        }

        val testApi = Api("valid_api_key")

        val quagganImageIds = testApi.Misc(retrofit).getQuagganImageIds() ?: emptyList()

        assertContains(quagganImageIds, "404")
        assertContains(quagganImageIds, "bubble")
        assertContains(quagganImageIds, "lollipop")
        assertContains(quagganImageIds, "summer")
    }

    @Test
    fun useQuagganApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/quaggan-404.json").content))
        }

        val testApi = Api("valid_api_key")
        val quaggan = testApi.Misc(retrofit).getQuaggan("404")

        assertEquals("404", quaggan?.id)
        assertEquals("https://static.staticwars.com/quaggans/404.jpg", quaggan?.url)
    }

    @Test
    fun useQuaggansApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/quaggan-404-knight.json").content))
        }

        val testApi = Api("valid_api_key")

        val request = mutableListOf("404", "knight")
        val quaggans = testApi.Misc(retrofit).getQuaggans(request)

        val firstQuaggan = quaggans?.first()
        val lastQuaggan = quaggans?.last()

        assertEquals("404", firstQuaggan?.id)
        assertEquals("https://static.staticwars.com/quaggans/404.jpg", firstQuaggan?.url)
        assertEquals("knight", lastQuaggan?.id)
        assertEquals("https://static.staticwars.com/quaggans/knight.jpg", lastQuaggan?.url)
    }

    @Test
    fun allQuaggansApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/quaggan-all.json").content))
        }

        val testApi = Api("valid_api_key")
        val quaggans = testApi.Misc(retrofit).getQuaggans()

        assertEquals(35, quaggans?.size)
    }
}