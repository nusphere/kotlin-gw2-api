package guildwars2.api.misc.title

data class Title(
    var id: Long,
    var name: String,
    var achievement: Long,
    var achievements: List<Long> = emptyList()
)
