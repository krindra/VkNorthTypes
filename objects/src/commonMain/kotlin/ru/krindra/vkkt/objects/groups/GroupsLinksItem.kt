package ru.krindra.vkkt.objects.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseBoolInt

/**
 *
 * @param name Link title
 * @param desc Link description
 * @param editTitle Information whether the link title can be edited
 * @param id Link ID
 * @param photo100 URL of square image of the link with 100 pixels in width
 * @param photo50 URL of square image of the link with 50 pixels in width
 * @param url Link URL
 * @param imageProcessing Information whether the image on processing
 */
@Serializable
data class GroupsLinksItem (
    @SerialName("id") val id: Int? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("desc") val desc: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("photo_50") val photo50: String? = null,
    @SerialName("photo_100") val photo100: String? = null,
    @SerialName("edit_title") val editTitle: BaseBoolInt? = null,
    @SerialName("image_processing") val imageProcessing: BaseBoolInt? = null,
)
