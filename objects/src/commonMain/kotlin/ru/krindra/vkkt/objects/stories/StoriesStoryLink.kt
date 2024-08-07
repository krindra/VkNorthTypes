package ru.krindra.vkkt.objects.stories

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param text Link text
 * @param url Link URL
 * @param linkUrlTarget How to open url
 */
@Serializable
data class StoriesStoryLink (
    @SerialName("url") val url: String,
    @SerialName("text") val text: String,
    @SerialName("link_url_target") val linkUrlTarget: String? = null,
)
