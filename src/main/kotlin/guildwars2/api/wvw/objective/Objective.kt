package guildwars2.api.wvw.objective

import com.google.gson.annotations.SerializedName

data class Objective(
    var id: String,
    var name: String,
    @SerializedName("sector_id") var sectorId: Int,
    var type: String,
    @SerializedName("map_type") var mapType: String,
    @SerializedName("map_id") var mapId: Int,
    @SerializedName("upgrade_id") var upgradeId: Int,
    var coord: List<Double>,
    @SerializedName("label_coord") var labelCoord: List<Double>,
    var marker: String,
    @SerializedName("chat_link") var chatLink: String,
)