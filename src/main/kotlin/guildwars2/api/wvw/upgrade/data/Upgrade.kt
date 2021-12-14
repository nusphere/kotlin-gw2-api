package guildwars2.api.wvw.upgrade.data

data class Upgrade(
    var id: Int,
    var tiers: List<UpgradeTier>
)
