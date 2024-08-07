package ru.krindra.vkkt.objects.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseRepostsInfo
import ru.krindra.vkkt.objects.base.BaseLikesInfo

/**
 *
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
data class WallWallpost (
    @SerialName("id") val id: Int? = null,
    @SerialName("date") val date: Int? = null,
    @SerialName("geo") val geo: WallGeo? = null,
    @SerialName("text") val text: String? = null,
    @SerialName("edited") val edited: Int? = null,
    @SerialName("from_id") val fromId: Int? = null,
    @SerialName("post_id") val postId: Int? = null,
    @SerialName("owner_id") val ownerId: Int? = null,
    @SerialName("views") val views: WallViews? = null,
    @SerialName("signer_id") val signerId: Int? = null,
    @SerialName("likes") val likes: BaseLikesInfo? = null,
    @SerialName("access_key") val accessKey: String? = null,
    @SerialName("is_deleted") val isDeleted: Boolean? = null,
    @SerialName("is_archived") val isArchived: Boolean? = null,
    @SerialName("is_favorite") val isFavorite: Boolean? = null,
    @SerialName("post_type") val postType: WallPostType? = null,
    @SerialName("reposts") val reposts: BaseRepostsInfo? = null,
    @SerialName("deleted_reason") val deletedReason: String? = null,
    @SerialName("parents_stack") val parentsStack: List<Int>? = null,
    @SerialName("copyright") val copyright: WallPostCopyright? = null,
    @SerialName("deleted_details") val deletedDetails: String? = null,
    @SerialName("post_source") val postSource: WallPostSource? = null,
    @SerialName("attachments") val attachments: List<WallWallpostAttachment>? = null,
)
