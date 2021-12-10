package helper

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.mockwebserver.MockWebServer
import org.junit.After;
import org.junit.Before;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory

open class GW2MockApi() {
    val server: MockWebServer = MockWebServer()
    val MOCK_WEBSERVER_PORT = 8000

    val retrofit: Retrofit get() = Retrofit.Builder()
        .baseUrl(server.url("/"))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    @Before
    fun init() {
        server.start(MOCK_WEBSERVER_PORT)
    }

    @After
    fun shutdown() {
        server.shutdown()
    }
}
