package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.likes.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Likes(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Adds the specified object to the 'Likes' list of the current user.
     * 
     * @param type Object type: 'post' - post on user or community wall, 'comment' - comment on a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note, 'photo_comment' - comment on the photo, 'video_comment' - comment on the video, 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the [vk.com/dev/Like|Like widget] is installed.
     * @param ownerId ID of the user or community that owns the object.
     * @param itemId Object ID.
     * @param accessKey Access key required for an object owned by a private entity.
     */
    suspend fun add(type: String, itemId: Long, ownerId: Long? = null, accessKey: String? = null): LikesAddResponse {
        val response = method("add", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId, "access_key" to accessKey))
        return json.decodeFromString<LikesAddResponse>(response)
    }

    /**
     *
     * Deletes the specified object from the 'Likes' list of the current user.
     * 
     * @param type Object type: 'post' - post on user or community wall, 'comment' - comment on a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note, 'photo_comment' - comment on the photo, 'video_comment' - comment on the video, 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the [vk.com/dev/Like|Like widget] is installed.
     * @param ownerId ID of the user or community that owns the object.
     * @param itemId Object ID.
     * @param accessKey Access key required for an object owned by a private entity.
     */
    suspend fun delete(type: String, itemId: Long, ownerId: Long? = null, accessKey: String? = null): LikesDeleteResponse {
        val response = method("delete", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId, "access_key" to accessKey))
        return json.decodeFromString<LikesDeleteResponse>(response)
    }

    /**
     *
     * Returns a list of IDs of users who added the specified object to their 'Likes' list.
     * 
     * @param type , Object type: 'post' - post on user or community wall, 'comment' - comment on a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note, 'photo_comment' - comment on the photo, 'video_comment' - comment on the video, 'topic_comment' - comment in the discussion, 'sitepage' - page of the site where the [vk.com/dev/Like|Like widget] is installed.
     * @param ownerId ID of the user, community, or application that owns the object. If the 'type' parameter is set as 'sitepage', the application ID is passed as 'owner_id'. Use negative value for a community id. If the 'type' parameter is not set, the 'owner_id' is assumed to be either the current user or the same application ID as if the 'type' parameter was set to 'sitepage'.
     * @param itemId Object ID. If 'type' is set as 'sitepage', 'item_id' can include the 'page_id' parameter value used during initialization of the [vk.com/dev/Like|Like widget].
     * @param pageUrl URL of the page where the [vk.com/dev/Like|Like widget] is installed. Used instead of the 'item_id' parameter.
     * @param filter Filters to apply: 'likes' - returns information about all users who liked the object (default), 'copies' - returns information only about users who told their friends about the object.
     * @param friendsOnly Specifies which users are returned: '1' - to return only the current user's friends, '0' - to return all users (default).
     * @param extended Specifies whether extended information will be returned. '1' - to return extended information about users and communities from the 'Likes' list, '0' - to return no additional information (default).
     * @param offset Offset needed to select a specific subset of users.
     * @param count Number of user IDs to return (maximum '1000'). Default is '100' if 'friends_only' is set to '0', otherwise, the default is '10' if 'friends_only' is set to '1'.
     * @param skipOwn 
     * @param fields 
     */
    suspend fun getList(type: String, ownerId: Long? = null, itemId: Long? = null, pageUrl: String? = null, filter: String? = null, friendsOnly: Int? = 0, extended: Boolean? = false, offset: Int? = null, count: Int? = null, skipOwn: Boolean? = false, fields: List<String>? = null): GetlistResponse {
        val response = method("getList", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId, "page_url" to pageUrl, "filter" to filter, "friends_only" to friendsOnly, "extended" to extended, "offset" to offset, "count" to count, "skip_own" to skipOwn, "fields" to fields))
        return GetlistResponse(response, json)
    }
    class GetlistResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(LikesGetListExtendedResponse.serializer(), LikesGetListResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun LikesGetListExtendedResponse(): LikesGetListExtendedResponse?{
            return if (response is LikesGetListExtendedResponse) response else null
        }
        fun LikesGetListResponse(): LikesGetListResponse?{
            return if (response is LikesGetListResponse) response else null
        }
    }

    /**
     *
     * Checks for the object in the 'Likes' list of the specified user.
     * 
     * @param userId User ID.
     * @param type Object type: 'post' - post on user or community wall, 'comment' - comment on a wall post, 'photo' - photo, 'audio' - audio, 'video' - video, 'story' - story, 'note' - note, 'photo_comment' - comment on the photo, 'video_comment' - comment on the video, 'topic_comment' - comment in the discussion.
     * @param ownerId ID of the user or community that owns the object.
     * @param itemId Object ID.
     */
    suspend fun isLiked(type: String, itemId: Long, userId: Long? = null, ownerId: Long? = null): LikesIsLikedResponse {
        val response = method("isLiked", mapOf("user_id" to userId, "type" to type, "owner_id" to ownerId, "item_id" to itemId))
        return json.decodeFromString<LikesIsLikedResponse>(response)
    }

}
