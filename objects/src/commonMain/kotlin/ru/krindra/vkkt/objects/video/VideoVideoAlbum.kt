package ru.krindra.vkkt.objects.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Album ID
 * @param ownerId Album owner's ID
 * @param title Album title
 * @param trackCode Album trackcode
 * @param responseType 
 */
@Serializable
data class VideoVideoAlbum (
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
    @SerialName("owner_id") val ownerId: Int,
    @SerialName("track_code") val trackCode: String? = null,
    @SerialName("response_type") val responseType: String? = null,
)
