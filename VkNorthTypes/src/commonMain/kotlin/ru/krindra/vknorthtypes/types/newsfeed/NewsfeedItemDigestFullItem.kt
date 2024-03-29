package ru.krindra.vknorthtypes.types.newsfeed

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.wall.WallWallpostAttachment

/**
 *
 * @param text 
 * @param sourceName 
 * @param attachmentIndex 
 * @param attachment 
 * @param style 
 * @param post 
 * @param badgeText Optional red badge for posts in digest block
 * @param type 
 * @param sourceId Item source ID
 * @param date Date when item has been added in Unixtime
 * @param shortTextRate Preview length control parameter
 * @param feedback 
 */
@Serializable
data class NewsfeedItemDigestFullItem (
    @SerialName("attachment_index") val attachmentIndex: Int? = null,
    @SerialName("type") val type: NewsfeedNewsfeedItemType/* WARN! WallPostType? = null */,
    @SerialName("feedback") val feedback: NewsfeedItemWallpostFeedback? = null,
    @SerialName("source_id") val sourceId: Long,
    @SerialName("post") val post: NewsfeedItemWallpost,
    @SerialName("attachment") val attachment: WallWallpostAttachment? = null,
    @SerialName("text") val text: String? = null,
    @SerialName("badge_text") val badgeText: String? = null,
    @SerialName("source_name") val sourceName: String? = null,
    @SerialName("short_text_rate") val shortTextRate: Double? = null,
    @SerialName("date") val date: Int/* WARN! Int? = null */,
    @SerialName("style") val style: String? = null,
)
