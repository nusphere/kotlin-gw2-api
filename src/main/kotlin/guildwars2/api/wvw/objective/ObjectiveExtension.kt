package guildwars2.api.wvw.objective

import kotlinx.coroutines.runBlocking
import okhttp3.Headers
import retrofit2.Response
import retrofit2.Retrofit

interface ObjectiveExtension {
    val retrofit: Retrofit
    private val api: ObjectiveApi get() = retrofit.create(ObjectiveApi::class.java)

    fun getObjectiveIds(): List<String>? = runBlocking { getObjectiveIdsResponse().body() }
    fun getObjectiveIdHeaders(): Headers? = runBlocking { getObjectiveIdsResponse().headers() }

    suspend fun getObjectiveIdsResponse(): Response<List<String>> = api.getObjectiveIdsAsync()

    fun getObjective(objectiveId: String, language: String = "en"): Objective? = runBlocking {
        return@runBlocking try {
            getObjectiveResponse(objectiveId, language).body()
        } catch (e: Exception) {
            null
        }
    }

    fun getObjectiveHeaders(objectiveId: String, language: String = "en"): Headers? = runBlocking {
        getObjectiveResponse(objectiveId, language).headers()
    }

    suspend fun getObjectiveResponse(objectiveId: String, language: String = "en"): Response<Objective> = api.getObjectiveAsync(objectiveId, language)
}