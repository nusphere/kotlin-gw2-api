package guildwars2.api.misc.build

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface BuildApi {

    /**
     * This resource returns the current build id of the game. This can be used, for example, to register when event timers reset due to server restarts.
     */
    @GET("/v2/build") fun getBuildAsync(): Deferred<Build>
}