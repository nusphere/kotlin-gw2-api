package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WorldTest: GW2MockApi() {

    @Test
    fun useWorldApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/worlds.json").content))
        }

        val testApi = Api("valid_api_key")

        val worlds = mutableListOf(1001, 1200)
        val worldCollection = testApi.Misc(retrofit).getWorlds(worlds) ?: emptyList()

        assertEquals(3, worldCollection.size)

        val world = worldCollection.first()

        assertEquals("Amboss-Stein", world.name)
        assertEquals("North America", world.region)
        assertEquals("Full", world.population)
        assertEquals("English", world.language)
    }
}