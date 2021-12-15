package guildwars2.api.misc.world

/**
 * If the root endpoint (/v2/worlds) is accessed without specifying an id, a list of all ids is returned. When multiple ids are requested using the ids parameter, a list of response objects is returned.
 *
 * For each requested world id, an object with the following properties is returned:
 *
 * @param id The world id.
 * @param name The world name.
 * @param population The world population level. One of: Low, Medium, High, VeryHigh, Full
 *
 * @property region The world's region.
 * @property language The world's assigned language.
 */
data class World(
    var id: Int,
    var name: String,
    var population: String
) {
    val region: String get() = if (this.id.toString()[0] == '1') "North America" else "Europe"

    val language: String get() = when (this.id.toString()[1]) {
        '1' -> "French"
        '2' -> "German"
        '3' -> "Spanish"
        else -> "English"
    }
}