package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WorldTest: GW2MockApi() {

    @Test
    fun getWorldIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/world-ids.json").content))
        }

        val testApi = Api("valid_api_key")
        val objectiveIds = testApi.Misc(retrofit).getWorldIds()

        assertEquals(51, objectiveIds?.size)
    }

    @Test
    fun getWorldIdsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/world-ids.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getWorldIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getWorldApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/world.json").content))
        }

        val testApi = Api("valid_api_key")

        val world = testApi.Misc(retrofit).getWorld(2001, "de")

        assertEquals("Kodasch [DE]", world?.name)
        assertEquals("Europe", world?.region)
        assertEquals("Medium", world?.population)
        assertEquals("German", world?.language)
    }

    @Test
    fun getWorldHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/world.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getWorldHeaders(2001, "de")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getWorldsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/worlds.json").content))
        }

        val testApi = Api("valid_api_key")

        val worlds = mutableListOf(1001, 1200)
        val worldCollection = testApi.Misc(retrofit).getWorlds(worlds)

        assertEquals(3, worldCollection?.size)

        val world = worldCollection?.first()

        assertEquals("Amboss-Stein", world?.name)
        assertEquals("North America", world?.region)
        assertEquals("Full", world?.population)
        assertEquals("English", world?.language)
    }

    @Test
    fun getWorldsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/worlds.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val worlds = mutableListOf(1001, 1200)
        val headers = testApi.Misc(retrofit).getWorldsHeaders(worlds)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}