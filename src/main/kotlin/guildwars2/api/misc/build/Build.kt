package guildwars2.api.misc.build

/**
 * The response is an object with the single property id containing the current build id as a number.
 *
 *  @param id The build id for the current build
 */
data class Build(
    var id: Long
)
