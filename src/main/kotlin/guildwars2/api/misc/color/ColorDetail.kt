package guildwars2.api.misc.color

import com.google.gson.annotations.SerializedName

/**
 * @param brightness (number) – The brightness.
 * @param contrast (number) – The contrast.
 * @param hue (number) – The hue in the HSL colorspace.
 * @param saturation (number) – The saturation in the HSL colorspace.
 * @param lightness (number) – The lightness in the HSL colorspace.
 * @property rgb (object) – A object containing precalculated RGB values.
 */
data class ColorDetail (
    var brightness: Long,
    var contrast: Double,
    var hue: Long,
    var saturation: Double,
    var lightness: Double,
    @SerializedName("rgb") private var rgbArray: List<Int>
) {
    val rgb: RGB
        get() = RGB(rgbArray[0], rgbArray[1], rgbArray[2])
}