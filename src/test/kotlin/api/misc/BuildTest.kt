package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BuildTest: GW2MockApi() {

    @Test
    fun useBuildApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/build.json").content))
        }

        val testApi = Api("valid_api_key")
        val build = testApi.Misc(retrofit).getBuild()

        assertEquals(45075, build?.id)
    }

    @Test
    fun useBuildApiHeaderTest() {
        val content = MockResponseFileReader("json/misc/build.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getBuildHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}