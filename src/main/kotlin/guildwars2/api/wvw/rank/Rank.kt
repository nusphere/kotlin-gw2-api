package guildwars2.api.wvw.rank

import com.google.gson.annotations.SerializedName

data class Rank(
    var id: Int,
    var title: String,
    @SerializedName("min_rank") var minRank: Int
)
