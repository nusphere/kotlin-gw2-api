package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TitleTest: GW2MockApi() {

    @Test
    fun getTitleIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/titles.json").content))
        }

        val testApi = Api("valid_api_key")
        val titleIds = testApi.Misc(retrofit).getTitleIds()

        assertEquals(231, titleIds?.size)
    }

    @Test
    fun getTitleIdsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/titles.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getTitleIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getTitleApiTest() {
        val content = MockResponseFileReader("json/misc/title.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val title = testApi.Misc(retrofit).getTitle(8, "de")

        assertEquals(8, title?.id)
        assertEquals("Flammensucher", title?.name)
        assertEquals(118, title?.achievement)
        assertEquals(1, title?.achievements?.size)
    }

    @Test
    fun getTitleApiExceptionTest() {
        val content = MockResponseFileReader("json/misc/title.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")

        val exception = assertThrows<Exception> {
            testApi.Misc(retrofit).getTitle(8, "deutsch")
        }

        assertEquals("wrong language code", exception.message)
    }

    @Test
    fun getTitleHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/title.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getTitleHeaders(8, "de")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getTitlesApiTest() {
        val content = MockResponseFileReader("json/misc/titles-40-90.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(40, 90)
        val titles = testApi.Misc(retrofit).getTitles(list, "de")

        assertEquals(2, titles?.size)

        val firstTitle = titles?.first()
        val lastTitle = titles?.last()

        assertEquals(40, firstTitle?.id)
        assertEquals("Kingmaker", firstTitle?.name)
        assertEquals(294, firstTitle?.achievement)
        assertEquals(1, firstTitle?.achievements?.size)

        assertEquals(90, lastTitle?.id)
        assertEquals("Slayer", lastTitle?.name)
        assertEquals(239, lastTitle?.achievement)
        assertEquals(1, lastTitle?.achievements?.size)
    }

    @Test
    fun getTitlesApiExceptionTest() {
        val content = MockResponseFileReader("json/misc/titles-40-90.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(40, 90)

        val exception = assertThrows<Exception> {
            testApi.Misc(retrofit).getTitles(list, "chinese")
        }

        assertEquals("wrong language code", exception.message)
    }

    @Test
    fun getTitlesHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/titles-40-90.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(40, 90)
        val headers = testApi.Misc(retrofit).getTitleHeaders(list, "de")

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

}