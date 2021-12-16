package guildwars2.api.misc.currency

data class Currency(
    var id: Int,
    var name: String,
    var description: String,
    var order: Int,
    var icon: String
)
