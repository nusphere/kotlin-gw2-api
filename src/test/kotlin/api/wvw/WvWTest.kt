package api.wvw

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class WvWTest: GW2MockApi() {

    @Test
    fun useAbilityIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/wvw.json").content))
        }

        val testApi = Api("valid_api_key")
        val apiTypes = testApi.WvW(retrofit).getApiTypes()

        assertEquals(5, apiTypes?.size)
    }

}