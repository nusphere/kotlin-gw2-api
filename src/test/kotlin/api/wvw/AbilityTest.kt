package api.wvw

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AbilityTest: GW2MockApi() {

    @Test
    fun useAbilityIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/abilities.json").content))
        }

        val testApi = Api("valid_api_key")
        val abilityIds = testApi.WvW(retrofit).getAbilityIds()

        assertEquals(22, abilityIds?.size)
    }

    @Test
    fun useAbilityApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/ability.json").content))
        }

        val testApi = Api("valid_api_key")
        val ability = testApi.WvW(retrofit).getAbility(2)

        assertEquals(2, ability?.id)
        assertEquals("Guard Killer", ability?.name)
        assertEquals("Increases damage to enemy guards", ability?.description)
        assertEquals("https://render.guildwars2.com/file/C5E6E906927E2C6311036C11F1306CCF57CBF259/544537.png", ability?.icon)
        assertEquals(5, ability?.ranks?.size)
        assertEquals(1, ability?.ranks?.first()?.cost)
        assertEquals("4% damage to guards", ability?.ranks?.first()?.effect)
    }



    @Test
    fun useAbilitiesApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/abilities-2-5.json").content))
        }

        val testApi = Api("valid_api_key")

        val list = mutableListOf(2, 5)
        val abilityList = testApi.WvW(retrofit).getAbilities(list)

        assertEquals(2, abilityList?.size)

        val ability = abilityList?.first()

        assertEquals(2, ability?.id)
        assertEquals("Guard Killer", ability?.name)
        assertEquals("Increases damage to enemy guards", ability?.description)
        assertEquals("https://render.guildwars2.com/file/C5E6E906927E2C6311036C11F1306CCF57CBF259/544537.png", ability?.icon)
        assertEquals(5, ability?.ranks?.size)
        assertEquals(1, ability?.ranks?.first()?.cost)
        assertEquals("4% damage to guards", ability?.ranks?.first()?.effect)
    }
}