package api.auth

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class TokenInfoTest: GW2MockApi() {

    @Test
    fun useAuthTokenInfoApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/auth/tokeninfo.json").content))
        }

        val testApi = Api("valid_api_key")
        val tokenInfo = testApi.Auth(retrofit).getTokenInfo()

        assertEquals("ABCDE02B-8888-FEBA-1234-DE98765C7DEF", tokenInfo.id)
        assertEquals("My API Key", tokenInfo.name)
        assertContains(tokenInfo.permissions ?: emptyList(), "account")
        assertContains(tokenInfo.permissions ?: emptyList(), "tradingpost")
    }

}