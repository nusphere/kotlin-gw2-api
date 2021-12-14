package api.wvw

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UpgradeTest: GW2MockApi() {

    @Test
    fun getUpgradeIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/upgrades.json").content))
        }

        val testApi = Api("valid_api_key")
        val upgradeIds = testApi.WvW(retrofit).getUpgradeIds()

        assertEquals(48, upgradeIds?.size)
    }

    @Test
    fun getUpgradeIdHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/upgrades.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getUpgradeIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getUpgradeApiTest() {
        val content = MockResponseFileReader("json/wvw/upgrade-2.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val upgrade = testApi.WvW(retrofit).getUpgrade(2)

        assertEquals(2, upgrade?.id)
        assertEquals(3, upgrade?.tiers?.size)

        val tier = upgrade?.tiers?.first()

        assertEquals("Secured", tier?.name)
        assertEquals(20, tier?.yaksRequired)
        assertEquals(2, tier?.upgrades?.size)

        val tierUpgrade = tier?.upgrades?.first()

        assertEquals("Caravan Guards", tierUpgrade?.name)
        assertEquals("Recruits guards to escort the camp's dolyak caravans.", tierUpgrade?.description)
        assertEquals("https://render.guildwars2.com/file/A81310D55E7BEA075E2F739A43E223070414EFE3/105225.png", tierUpgrade?.icon)
    }

    @Test
    fun getUpgradeHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/upgrade-2.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getUpgradeHeaders(2)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}