package guildwars2.api.wvw.ability.data

/**
 * The response is an object with the single property id containing the current build id as a number.
 *
 *  @param id The build id for the current build
 */
data class Ability(
    var id: Int,
    var name: String,
    val description: String,
    var icon: String,
    var ranks: List<Rank>
)
