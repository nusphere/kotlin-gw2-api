package guildwars2.api.wvw.match.data

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * @param id The WvW match id.
 * @param start  The starting time of the matchup.
 * @param end  The ending time of the matchup.
 * @param scores An object containing the score of the three servers, under the values red, blue, and green.
 * @param primaryWorlds An object containing the IDs of the three primary matchup worlds.
 */
data class Match(
    val id: String,
    @SerializedName("start_time") val start: Date,
    @SerializedName("end_time") val end: Date,
    val scores: Scores,
    @SerializedName("worlds") val primaryWorlds: PrimaryWorlds,
    @SerializedName("all_worlds") val allWorlds: AllWorlds,
    val deaths: Any,
    val kills: Any,
    val victory_points: Any,
    val maps: Any,
    val skirmishes: Any
)
