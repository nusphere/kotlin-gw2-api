package api.misc

import guildwars2.Api
import helper.GW2MockApi
import helper.MockResponseFileReader
import okhttp3.mockwebserver.MockResponse
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ColorTest: GW2MockApi() {

    @Test
    fun getColorIdsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/colors.json").content))
        }

        val testApi = Api("valid_api_key")
        val colorIds = testApi.Misc(retrofit).getColorIds()

        assertEquals(619, colorIds?.size)
    }

    @Test
    fun getColorIdsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/colors.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getColorIdHeaders()

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getColorApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/color-10.json").content))
        }

        val testApi = Api("valid_api_key")
        val color = testApi.Misc(retrofit).getColor(10)

        assertEquals(10, color?.id)
    }

    @Test
    fun getColorHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/color-10.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val headers = testApi.Misc(retrofit).getColorHeaders(2)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getColorApiExceptionTest() {
        val content = MockResponseFileReader("json/misc/color-10.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")

        val exception = assertThrows<Exception> {
            testApi.Misc(retrofit).getColor(8, "deutsch")
        }

        assertEquals("wrong language code", exception.message)
    }

    @Test
    fun useColorsApiTest() {
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("json/misc/colors-1245-1246.json").content))
        }

        val testApi = Api("valid_api_key")

        val list = mutableListOf(1245, 156)
        val colorList = testApi.Misc(retrofit).getColors(list, "en")

        assertEquals(2, colorList?.size)

        val color = colorList?.first()

        assertEquals(1245, color?.id)
    }

    @Test
    fun getColorsHeadersApiTest() {
        val content = MockResponseFileReader("json/misc/colors-1245-1246.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")
        val list = mutableListOf(1245, 156)
        val headers = testApi.Misc(retrofit).getColorsHeaders(list)

        assertEquals(content.length.toString(), headers?.get("Content-Length"))
    }

    @Test
    fun getColorsApiExceptionTest() {
        val content = MockResponseFileReader("json/misc/colors-1245-1246.json").content

        server.apply {
            enqueue(MockResponse().setBody(content))
        }

        val testApi = Api("valid_api_key")

        val exception = assertThrows<Exception> {
            val list = mutableListOf(1245, 156)
            testApi.Misc(retrofit).getColors(list, "deutsch")
        }

        assertEquals("wrong language code", exception.message)
    }
}