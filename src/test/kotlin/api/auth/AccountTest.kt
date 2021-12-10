package api.auth

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class AccountTest: GW2MockApi() {

    @Test
    fun useAuthAccountApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/account.json").content))
        }

        val testApi = Api("valid_api_key")

        val exception = assertThrows<Exception> {
            testApi.Auth(retrofit).getAccount()
        }

        assertEquals("token has no permission for account", exception.message)
    }
}