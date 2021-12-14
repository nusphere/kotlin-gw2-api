package api.auth

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DyesTest: GW2MockApi() {

    @Test
    fun useDyesApiWithoutPermissionTest() {
        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"\"]}"))
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/dyes.json").content))
        }

        val testApi = Api("valid_api_key")
        val exception = assertThrows<Exception> {
            testApi.Auth(retrofit).getDyesIds()
        }

        assertEquals("token has no permission for account", exception.message)
    }

    @Test
    fun useDyesApiTest() {
        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"account\"]}"))
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/dyes.json").content))
        }

        val testApi = Api("valid_api_key")
        val dyesIds = testApi.Auth(retrofit).getDyesIds()

        assertEquals(4, dyesIds?.size)
    }

    @Test
    fun useDyesApiHeaderTest() {
        val content = MockResponseFileReader("json/auth/dyes.json").content

        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"account\"]}"))
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Auth(retrofit).getDyesHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}