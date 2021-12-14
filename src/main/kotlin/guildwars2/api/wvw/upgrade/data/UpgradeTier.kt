package guildwars2.api.wvw.upgrade.data

import com.google.gson.annotations.SerializedName

data class UpgradeTier(
    var name: String,
    @SerializedName("yaks_required") var yaksRequired: Int,
    var upgrades: List<TierInfo>
)
