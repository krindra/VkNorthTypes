package ru.krindra.vkkt.objects.video

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param external URL of the external player
 * @param mp4144 URL of the mpeg4 file with 144p quality
 * @param mp4240 URL of the mpeg4 file with 240p quality
 * @param mp4360 URL of the mpeg4 file with 360p quality
 * @param mp4480 URL of the mpeg4 file with 480p quality
 * @param mp4720 URL of the mpeg4 file with 720p quality
 * @param mp41080 URL of the mpeg4 file with 1080p quality
 * @param mp41440 URL of the mpeg4 file with 2K quality
 * @param mp42160 URL of the mpeg4 file with 4K quality
 * @param flv320 URL of the flv file with 320p quality
 */
@Serializable
data class VideoVideoFiles (
    @SerialName("flv_320") val flv320: String? = null,
    @SerialName("mp4_144") val mp4144: String? = null,
    @SerialName("mp4_240") val mp4240: String? = null,
    @SerialName("mp4_360") val mp4360: String? = null,
    @SerialName("mp4_480") val mp4480: String? = null,
    @SerialName("mp4_720") val mp4720: String? = null,
    @SerialName("mp4_1080") val mp41080: String? = null,
    @SerialName("mp4_1440") val mp41440: String? = null,
    @SerialName("mp4_2160") val mp42160: String? = null,
    @SerialName("external") val external: String? = null,
)
