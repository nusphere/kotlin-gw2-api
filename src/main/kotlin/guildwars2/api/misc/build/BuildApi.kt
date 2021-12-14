package guildwars2.api.misc.build

import retrofit2.Response
import retrofit2.http.GET

interface BuildApi {

    /**
     * This resource returns the current build id of the game. This can be used, for example, to register when event timers reset due to server restarts.
     */
    @GET("/v2/build")
    suspend fun getBuildAsync(): Response<Build>
}