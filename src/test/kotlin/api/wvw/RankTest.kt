package api.wvw

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RankTest: GW2MockApi() {

    @Test
    fun getRankIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/wvw/ranks.json").content))
        }

        val testApi = Api("valid_api_key")
        val rankIds = testApi.WvW(retrofit).getRankIds()

        assertEquals(105, rankIds?.size)
    }

    @Test
    fun getRankIdHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/ranks.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getRankIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getRankApiTest() {
        val content = MockResponseFileReader("json/wvw/rank-20.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val rank = testApi.WvW(retrofit).getRank(20)

        assertEquals(20, rank?.id)
        assertEquals("Bronze Scout", rank?.title)
        assertEquals(270, rank?.minRank)
    }

    @Test
    fun getRankHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/rank-20.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.WvW(retrofit).getRankHeaders(20)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getRanksApiTest() {
        val content = MockResponseFileReader("json/wvw/rank-30-105.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val ranks = mutableListOf(30, 105)
        val rankList = testApi.WvW(retrofit).getRanks(ranks, "de")

        assertEquals(2, rankList?.size)

        val firstRank = rankList?.first()
        val lastRank = rankList?.last()

        assertEquals(30, firstRank?.id)
        assertEquals("Bronze-Legende", firstRank?.title)
        assertEquals(570, firstRank?.minRank)

        assertEquals(105, lastRank?.id)
        assertEquals("Diamant-Legende", lastRank?.title)
        assertEquals(9945, lastRank?.minRank)
    }

    @Test
    fun getRanksHeadersApiTest() {
        val content = MockResponseFileReader("json/wvw/rank-30-105.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val ranks = mutableListOf(30, 105)
        val headers = testApi.WvW(retrofit).getRanksHeaders(ranks)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }
}