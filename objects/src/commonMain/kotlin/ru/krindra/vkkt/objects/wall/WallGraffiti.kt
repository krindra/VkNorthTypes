package ru.krindra.vkkt.objects.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Graffiti ID
 * @param ownerId Graffiti owner's ID
 * @param photo200 URL of the preview image with 200 px in width
 * @param photo586 URL of the preview image with 586 px in width
 * @param height Graffiti height
 * @param url Graffiti URL
 * @param width Graffiti width
 * @param accessKey Access key for graffiti
 */
@Serializable
data class WallGraffiti (
    @SerialName("id") val id: Int? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("width") val width: Int? = null,
    @SerialName("height") val height: Int? = null,
    @SerialName("owner_id") val ownerId: Int? = null,
    @SerialName("photo_200") val photo200: String? = null,
    @SerialName("photo_586") val photo586: String? = null,
    @SerialName("access_key") val accessKey: String? = null,
)
