package ru.krindra.vkkt.objects.newsfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param photoTags 
 * @param postId Post ID
 * @param carouselOffset Index of current carousel element
 * @param type 
 * @param sourceId Item source ID
 * @param date Date when item has been added in Unixtime
 * @param shortTextRate Preview length control parameter
 * @param feedback 
 */
@Serializable
data class NewsfeedItemPhotoTag (
    @SerialName("source_id") val sourceId: Int,
    @SerialName("post_id") val postId: Int? = null,
    @SerialName("date") val date: Int/* WARN! Int? = null */,
    @SerialName("carousel_offset") val carouselOffset: Int? = null,
    @SerialName("short_text_rate") val shortTextRate: Double? = null,
    @SerialName("feedback") val feedback: NewsfeedItemWallpostFeedback? = null,
    @SerialName("photo_tags") val photoTags: NewsfeedItemPhotoTagPhotoTags? = null,
    @SerialName("type") val type: NewsfeedNewsfeedItemType/* WARN! WallPostType? = null */,
)
