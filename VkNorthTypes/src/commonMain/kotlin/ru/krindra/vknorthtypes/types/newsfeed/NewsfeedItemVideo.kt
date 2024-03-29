package ru.krindra.vknorthtypes.types.newsfeed

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param video 
 * @param postId Post ID
 * @param carouselOffset Index of current carousel element
 * @param type 
 * @param sourceId Item source ID
 * @param date Date when item has been added in Unixtime
 * @param shortTextRate Preview length control parameter
 * @param feedback 
 */
@Serializable
data class NewsfeedItemVideo (
    @SerialName("type") val type: NewsfeedNewsfeedItemType/* WARN! WallPostType? = null */,
    @SerialName("feedback") val feedback: NewsfeedItemWallpostFeedback? = null,
    @SerialName("source_id") val sourceId: Long,
    @SerialName("carousel_offset") val carouselOffset: Int? = null,
    @SerialName("date") val date: Int/* WARN! Int? = null */,
    @SerialName("post_id") val postId: Long? = null,
    @SerialName("short_text_rate") val shortTextRate: Double? = null,
    @SerialName("video") val video: NewsfeedItemVideoVideo? = null,
)
