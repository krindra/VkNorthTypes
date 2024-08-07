package ru.krindra.vkkt.responses.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.photos.*

/**
 * @param cropData Crop data
 * @param cropHash Crop hash
 * @param groupId Community ID
 * @param hash Uploading hash
 * @param photo Uploaded photo data
 * @param server Upload server number
 */
@Serializable
data class PhotosMarketUploadResponse (
    @SerialName("hash") val hash: String? = null,
    @SerialName("server") val server: Int? = null,
    @SerialName("photo") val photo: String? = null,
    @SerialName("group_id") val groupId: Int? = null,
    @SerialName("crop_data") val cropData: String? = null,
    @SerialName("crop_hash") val cropHash: String? = null,
)

