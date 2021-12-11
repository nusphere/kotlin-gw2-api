package guildwars2.api.misc.quaggan

/**
 * The response is an object with the single property id containing the current build id as a number.
 *
 *  @param id The build id for the current build
 */
data class Quaggan(
    var id: String,
    var url: String
)
