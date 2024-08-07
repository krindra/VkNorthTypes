package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Owner
 * 
 * @param id Owner id
 * @param name Name
 * @param photo Photo url
 * @param url Profile url
 */
@Serializable
data class AdsPostOwner (
    @SerialName("id") val id: Int? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("photo") val photo: String? = null,
)
