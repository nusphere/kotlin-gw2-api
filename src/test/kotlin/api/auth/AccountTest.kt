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
    fun useAuthAccountApiDeniedTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/account.json").content))
        }

        val testApi = Api("valid_api_key")

        val exception = assertThrows<Exception> {
            testApi.Auth(retrofit).getAccount()
        }

        assertEquals("token has no permission for account", exception.message)
    }

    @Test
    fun useAuthAccountApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/account-permission.json").content))
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/account.json").content))
        }

        val testApi = Api("valid_api_key")
        val account = testApi.Auth(retrofit).getAccount()

        assertEquals("Account.1234", account?.name)
    }

    @Test
    fun getAccountHeaderApiTest() {
        val content = MockResponseFileReader("json/auth/account.json").content

        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/account-permission.json").content))
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Auth(retrofit).getAccountHeader()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}