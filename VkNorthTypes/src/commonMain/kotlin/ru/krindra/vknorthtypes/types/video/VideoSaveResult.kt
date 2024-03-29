package ru.krindra.vknorthtypes.types.video

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param accessKey Video access key
 * @param description Video description
 * @param ownerId Video owner ID
 * @param title Video title
 * @param uploadUrl URL for the video uploading
 * @param videoId Video ID
 */
@Serializable
data class VideoSaveResult (
    @SerialName("description") val description: String? = null,
    @SerialName("video_id") val videoId: Long? = null,
    @SerialName("title") val title: String? = null,
    @SerialName("access_key") val accessKey: String? = null,
    @SerialName("owner_id") val ownerId: Long? = null,
    @SerialName("upload_url") val uploadUrl: String? = null,
)
