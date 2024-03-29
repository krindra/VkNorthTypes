package ru.krindra.vknorthtypes.types.stories

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
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
    @SerialName("link_url_target") val linkUrlTarget: String? = null,
    @SerialName("url") val url: String,
    @SerialName("text") val text: String,
)
