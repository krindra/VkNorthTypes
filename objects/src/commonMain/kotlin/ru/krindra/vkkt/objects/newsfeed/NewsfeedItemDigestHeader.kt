package ru.krindra.vkkt.objects.newsfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param title Title of the header
 * @param subtitle Subtitle of the header, when title have two strings
 * @param badgeText Optional field for red badge in Trends feed blocks
 * @param style 
 * @param button 
 */
@Serializable
data class NewsfeedItemDigestHeader (
    @SerialName("style") val style: String,
    @SerialName("title") val title: String,
    @SerialName("subtitle") val subtitle: String? = null,
    @SerialName("badge_text") val badgeText: String? = null,
    @SerialName("button") val button: NewsfeedItemDigestButton? = null,
)
