package ru.krindra.vkkt.objects.utils

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param accessKey Access key for private stats
 * @param key Link key (characters after vk.cc/)
 * @param shortUrl Short link URL
 * @param url Full URL
 */
@Serializable
data class UtilsShortLink (
    @SerialName("key") val key: String? = null,
    @SerialName("url") val url: String? = null,
    @SerialName("short_url") val shortUrl: String? = null,
    @SerialName("access_key") val accessKey: String? = null,
)
