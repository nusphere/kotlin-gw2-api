package api.wvw

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ObjectiveTest: GW2MockApi() {

    @Test
    fun getObjectiveIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/objectives.json").content))
        }

        val testApi = Api("valid_api_key")
        val objectiveIds = testApi.WvW(retrofit).getObjectiveIds()

        assertEquals(178, objectiveIds?.size)
    }

    @Test
    fun getObjectiveIdsHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/objectives.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getObjectiveIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getObjectiveApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/objective.json").content))
        }

        val testApi = Api("valid_api_key")
        val objective = testApi.WvW(retrofit).getObjective("38-6")

        assertEquals("38-6", objective?.id)
        assertEquals("Speldan Clearcut", objective?.name)
        assertEquals(844, objective?.sectorId)
        assertEquals("Camp", objective?.type)
        assertEquals("Center", objective?.mapType)
        assertEquals(38, objective?.mapId)
        assertEquals(28, objective?.upgradeId)
        assertEquals("https://render.guildwars2.com/file/015D365A08AAE105287A100AAE04529FDAE14155/102532.png", objective?.marker)
        assertEquals("[&DAYAAAAmAAAA]", objective?.chatLink)
    }

    @Test
    fun getObjectiveHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/objective.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getObjectiveHeaders("38-6")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}