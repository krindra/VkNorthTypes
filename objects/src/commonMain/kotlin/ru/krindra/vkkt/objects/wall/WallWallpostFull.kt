package ru.krindra.vkkt.objects.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.newsfeed.NewsfeedItemWallpostFeedback
import ru.krindra.vkkt.objects.base.BaseRepostsInfo
import ru.krindra.vkkt.objects.base.BaseLikesInfo
import ru.krindra.vkkt.objects.base.BaseBoolInt
import ru.krindra.vkkt.objects.base.BaseCommentsInfo

/**
 *
 * @param copyHistory 
 * @param canEdit Information whether current user can edit the post
 * @param createdBy Post creator ID (if post still can be edited)
 * @param canDelete Information whether current user can delete the post
 * @param canPin Information whether current user can pin the post
 * @param donut 
 * @param isPinned Information whether the post is pinned
 * @param comments 
 * @param markedAsAds Information whether the post is marked as ads
 * @param topicId Topic ID. Allowed values can be obtained from newsfeed.getPostTopics method
 * @param shortTextRate Preview length control parameter
 * @param hash Hash for sharing
 * @param type 
 * @param feedback 
 * @param toId 
 * @param carouselOffset Index of current carousel element
 * @param accessKey Access key to private object
 * @param isDeleted 
 * @param deletedReason 
 * @param deletedDetails 
 * @param attachments 
 * @param copyright Information about the source of the post
 * @param date Date of publishing in Unixtime
 * @param edited Date of editing in Unixtime
 * @param fromId Post author ID
 * @param geo 
 * @param id Post ID
 * @param isArchived Is post archived, only for post owners
 * @param isFavorite Information whether the post in favorites list
 * @param likes Count of likes
 * @param ownerId Wall owner's ID
 * @param postId If post type 'reply', contains original post ID
 * @param parentsStack If post type 'reply', contains original parent IDs stack
 * @param postSource 
 * @param postType 
 * @param reposts 
 * @param signerId Post signer ID
 * @param text Post text
 * @param views Count of views
 */
@Serializable
data class WallWallpostFull (
    @SerialName("id") val id: Int? = null,
    @SerialName("date") val date: Int? = null,
    @SerialName("to_id") val toId: Int? = null,
    @SerialName("geo") val geo: WallGeo? = null,
    @SerialName("hash") val hash: String? = null,
    @SerialName("text") val text: String? = null,
    @SerialName("edited") val edited: Int? = null,
    @SerialName("from_id") val fromId: Int? = null,
    @SerialName("post_id") val postId: Int? = null,
    @SerialName("owner_id") val ownerId: Int? = null,
    @SerialName("topic_id") val topicId: Int? = null,
    @SerialName("views") val views: WallViews? = null,
    @SerialName("signer_id") val signerId: Int? = null,
    @SerialName("type") val type: WallPostType? = null,
    @SerialName("created_by") val createdBy: Int? = null,
    @SerialName("likes") val likes: BaseLikesInfo? = null,
    @SerialName("can_pin") val canPin: BaseBoolInt? = null,
    @SerialName("access_key") val accessKey: String? = null,
    @SerialName("can_edit") val canEdit: BaseBoolInt? = null,
    @SerialName("is_deleted") val isDeleted: Boolean? = null,
    @SerialName("donut") val donut: WallWallpostDonut? = null,
    @SerialName("is_archived") val isArchived: Boolean? = null,
    @SerialName("is_favorite") val isFavorite: Boolean? = null,
    @SerialName("is_pinned") val isPinned: BaseBoolInt? = null,
    @SerialName("post_type") val postType: WallPostType? = null,
    @SerialName("reposts") val reposts: BaseRepostsInfo? = null,
    @SerialName("can_delete") val canDelete: BaseBoolInt? = null,
    @SerialName("carousel_offset") val carouselOffset: Int? = null,
    @SerialName("comments") val comments: BaseCommentsInfo? = null,
    @SerialName("deleted_reason") val deletedReason: String? = null,
    @SerialName("parents_stack") val parentsStack: List<Int>? = null,
    @SerialName("short_text_rate") val shortTextRate: Double? = null,
    @SerialName("copyright") val copyright: WallPostCopyright? = null,
    @SerialName("deleted_details") val deletedDetails: String? = null,
    @SerialName("marked_as_ads") val markedAsAds: BaseBoolInt? = null,
    @SerialName("post_source") val postSource: WallPostSource? = null,
    @SerialName("feedback") val feedback: NewsfeedItemWallpostFeedback? = null,
    @SerialName("copy_history") val copyHistory: List<WallWallpostFull>? = null,
    @SerialName("attachments") val attachments: List<WallWallpostAttachment>? = null,
)
