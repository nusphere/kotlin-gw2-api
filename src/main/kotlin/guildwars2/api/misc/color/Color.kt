package guildwars2.api.misc.color

import com.google.gson.annotations.SerializedName

/**
 * @param id - The color id.
 * @param name (string) – The color name.
 * @param base (array of numbers) – The base RGB values.
 * @param cloth (object) – Detailed information on its appearance when applied on cloth armor.
 * @param leather (object) – Detailed information on its appearance when applied on leather armor.
 * @param metal (object) – Detailed information on its appearance when applied on metal armor.
 * @param fur (object, optional) – Detailed information on its appearance when applied on fur armor.
 * @param item (number, optional) - ID of the dye item.
 * @param categories (list of strings) - Color categories. Possible values:
 *     Hue: Gray, Brown, Red, Orange, Yellow, Green, Blue, Purple
 *     Material: Vibrant, Leather, Metal
 *     Rarity: Starter, Common, Uncommon, Rare, Exclusive
 */
data class Color(
    var id: Long,
    var name: String,
    @SerializedName("base_rgb") private var baseRGBArray: List<Int>,
    var cloth: ColorDetail,
    var leather: ColorDetail,
    var metal: ColorDetail,
    var fur: ColorDetail?,
    var item: Long?,
    var categories: List<String>
) {
    val baseRGB: RGB
        get() = RGB(baseRGBArray[0], baseRGBArray[1], baseRGBArray[2])
}
