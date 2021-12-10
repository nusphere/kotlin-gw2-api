package guildwars2.api.auth.account

import com.google.gson.annotations.SerializedName

data class Account(
    val id: String?,
    val name: String?,
    val age: Long?,   //22911780,
    val world: Int?,
    val created: String?,
    val commander: Boolean,
    val fractal_level: Long?,
    val daily_ap: Long?,
    val monthly_ap: Long?,
    @SerializedName("wvw_rank") val wvwRank: Long?
)