package api.auth

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FinisherTest: GW2MockApi() {

    @Test
    fun useFinisherApiWithoutPermissionTest() {
        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"\"]}"))
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/finisher.json").content))
        }

        val testApi = Api("valid_api_key")
        val exception = assertThrows<Exception> {
            testApi.Auth(retrofit).getFinisher()
        }

        assertEquals("token has no permission for account", exception.message)
    }

    @Test
    fun useFinisherApiTest() {
        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"account\"]}"))
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/finisher.json").content))
        }

        val testApi = Api("valid_api_key")
        val finisherList = testApi.Auth(retrofit).getFinisher()

        assertEquals(2, finisherList?.size)

        val firstAccountFinisher = finisherList?.first()
        val lastAccountFinisher = finisherList?.last()

        assertEquals(1, firstAccountFinisher?.id)
        assertTrue(firstAccountFinisher?.permanent ?: false)

        assertEquals(15, lastAccountFinisher?.id)
        assertFalse(lastAccountFinisher?.permanent ?: true)
        assertEquals(5, lastAccountFinisher?.quantity)
    }

    @Test
    fun useDyesApiHeaderTest() {
        val content = MockResponseFileReader("json/auth/finisher.json").content

        server.apply {
            enqueue(MockResponse().setBody("{\"permissions\": [\"account\"]}"))
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Auth(retrofit).getFinisherHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}