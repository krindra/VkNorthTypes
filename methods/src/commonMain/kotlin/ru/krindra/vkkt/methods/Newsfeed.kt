package ru.krindra.vkkt.methods

import ru.krindra.vkkt.responses.newsfeed.*
import ru.krindra.vkkt.objects.newsfeed.*
import ru.krindra.vkkt.utils.JsonSingleton
import kotlinx.serialization.json.Json
import ru.krindra.vkkt.objects.users.UsersFields
import ru.krindra.vkkt.responses.base.BaseOkResponse
import ru.krindra.vkkt.responses.base.BaseBoolResponse
import ru.krindra.vkkt.objects.base.BaseUserGroupFields

class Newsfeed(
    private val method: suspend (String, Map<String, Any?>?) -> String,
    private val json: Json = JsonSingleton.json
    ) {
    /**
     *
     * Prevents news from specified users and communities from appearing in the current user's newsfeed.
     * 
     * @param userIds 
     * @param groupIds 
     */
    suspend fun addBan(userIds: List<Int>? = null, groupIds: List<Int>? = null): BaseBoolResponse {
        val response = method("newsfeed.addBan", mapOf("user_ids" to userIds, "group_ids" to groupIds))
        return decodeResponse(response, json)
    }

    /**
     *
     * Allows news from previously banned users and communities to be shown in the current user's newsfeed.
     * 
     * @param userIds 
     * @param groupIds 
     */
    suspend fun deleteBan(userIds: List<Int>? = null, groupIds: List<Int>? = null): BaseOkResponse {
        val response = method("newsfeed.deleteBan", mapOf("user_ids" to userIds, "group_ids" to groupIds))
        return decodeResponse(response, json)
    }

    /**
     *
     * @param listId 
     */
    suspend fun deleteList(listId: Int): BaseOkResponse {
        val response = method("newsfeed.deleteList", mapOf("list_id" to listId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns data required to show newsfeed for the current user.
     * 
     * @param filters Filters to apply: 'post' - new wall posts, 'photo' - new photos, 'photo_tag' - new photo tags, 'wall_photo' - new wall photos, 'friend' - new friends.
     * @param returnBanned '1' - to return news items from banned sources.
     * @param startTime Earliest timestamp (in Unix time) of a news item to return. By default, 24 hours ago.
     * @param endTime Latest timestamp (in Unix time) of a news item to return. By default, the current time.
     * @param maxPhotos Maximum number of photos to return. By default, '5'.
     * @param sourceIds Sources to obtain news from, separated by commas. User IDs can be specified in formats '' or 'u' , where '' is the user's friend ID. Community IDs can be specified in formats '-' or 'g' , where '' is the community ID. If the parameter is not set, all of the user's friends and communities are returned, except for banned sources, which can be obtained with the [vk.com/dev/newsfeed.getBanned|newsfeed.getBanned] method.
     * @param startFrom identifier required to get the next page of results. Value for this parameter is returned in 'next_from' field in a reply.
     * @param count Number of news items to return (default 50, maximum 100). For auto feed, you can use the 'new_offset' parameter returned by this method.
     * @param fields Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     * @param section 
     */
    suspend fun get(filters: List<NewsfeedNewsfeedItemType>? = null, returnBanned: Boolean? = false, startTime: Int? = null, endTime: Int? = null, maxPhotos: Int? = null, sourceIds: String? = null, startFrom: String? = null, count: Int? = null, fields: List<BaseUserGroupFields>? = null, section: String? = null): NewsfeedGenericResponse {
        val response = method("newsfeed.get", mapOf("filters" to filters, "return_banned" to returnBanned, "start_time" to startTime, "end_time" to endTime, "max_photos" to maxPhotos, "source_ids" to sourceIds, "start_from" to startFrom, "count" to count, "fields" to fields, "section" to section))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of users and communities banned from the current user's newsfeed.
     * 
     * @param extended '1' - return extra information about users and communities.
     * @param fields Profile fields to return.
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default), 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     */
    suspend fun getBanned(extended: Boolean? = false, fields: List<UsersFields>? = null, nameCase: String? = null): GetBannedResponse {
        val response = method("newsfeed.getBanned", mapOf("extended" to extended, "fields" to fields, "name_case" to nameCase))
        return GetBannedResponse(response, json)
    }
    class GetBannedResponse(
        private val rawResponse: String, json: Json
    ): BaseMultivariateResponse(json) {
        fun NewsfeedGetBannedExtendedResponse(): NewsfeedGetBannedExtendedResponse? {
            return getResponseOrNull(NewsfeedGetBannedExtendedResponse.serializer(), rawResponse)
        }
        fun NewsfeedGetBannedResponse(): NewsfeedGetBannedResponse? {
            return getResponseOrNull(NewsfeedGetBannedResponse.serializer(), rawResponse)
        }
    }

    /**
     *
     * Returns a list of comments in the current user's newsfeed.
     * 
     * @param count Number of comments to return. For auto feed, you can use the 'new_offset' parameter returned by this method.
     * @param filters Filters to apply: 'post' - new comments on wall posts, 'photo' - new comments on photos, 'video' - new comments on videos, 'topic' - new comments on discussions, 'note' - new comments on notes,.
     * @param reposts Object ID, comments on repost of which shall be returned, e.g. 'wall1_45486'. (If the parameter is set, the 'filters' parameter is optional.),.
     * @param startTime Earliest timestamp (in Unix time) of a comment to return. By default, 24 hours ago.
     * @param endTime Latest timestamp (in Unix time) of a comment to return. By default, the current time.
     * @param lastCommentsCount 
     * @param startFrom Identificator needed to return the next page with results. Value for this parameter returns in 'next_from' field.
     * @param fields Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     */
    suspend fun getComments(count: Int? = 30, filters: List<NewsfeedCommentsFilters>? = null, reposts: String? = null, startTime: Int? = null, endTime: Int? = null, lastCommentsCount: Int? = 0, startFrom: String? = null, fields: List<BaseUserGroupFields>? = null): NewsfeedGetCommentsResponse {
        val response = method("newsfeed.getComments", mapOf("count" to count, "filters" to filters, "reposts" to reposts, "start_time" to startTime, "end_time" to endTime, "last_comments_count" to lastCommentsCount, "start_from" to startFrom, "fields" to fields))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns a list of newsfeeds followed by the current user.
     * 
     * @param listIds numeric list identifiers.
     * @param extended Return additional list info.
     */
    suspend fun getLists(listIds: List<Int>? = null, extended: Boolean? = false): GetListsResponse {
        val response = method("newsfeed.getLists", mapOf("list_ids" to listIds, "extended" to extended))
        return GetListsResponse(response, json)
    }
    class GetListsResponse(
        private val rawResponse: String, json: Json
    ): BaseMultivariateResponse(json) {
        fun NewsfeedGetListsExtendedResponse(): NewsfeedGetListsExtendedResponse? {
            return getResponseOrNull(NewsfeedGetListsExtendedResponse.serializer(), rawResponse)
        }
        fun NewsfeedGetListsResponse(): NewsfeedGetListsResponse? {
            return getResponseOrNull(NewsfeedGetListsResponse.serializer(), rawResponse)
        }
    }

    /**
     *
     * Returns a list of posts on user walls in which the current user is mentioned.
     * 
     * @param ownerId Owner ID.
     * @param startTime Earliest timestamp (in Unix time) of a post to return. By default, 24 hours ago.
     * @param endTime Latest timestamp (in Unix time) of a post to return. By default, the current time.
     * @param offset Offset needed to return a specific subset of posts.
     * @param count Number of posts to return.
     */
    suspend fun getMentions(ownerId: Int? = null, startTime: Int? = null, endTime: Int? = null, offset: Int? = null, count: Int? = 20): NewsfeedGetMentionsResponse {
        val response = method("newsfeed.getMentions", mapOf("owner_id" to ownerId, "start_time" to startTime, "end_time" to endTime, "offset" to offset, "count" to count))
        return decodeResponse(response, json)
    }

    /**
     *
     * , Returns a list of newsfeeds recommended to the current user.
     * 
     * @param startTime Earliest timestamp (in Unix time) of a news item to return. By default, 24 hours ago.
     * @param endTime Latest timestamp (in Unix time) of a news item to return. By default, the current time.
     * @param maxPhotos Maximum number of photos to return. By default, '5'.
     * @param startFrom 'new_from' value obtained in previous call.
     * @param count Number of news items to return.
     * @param fields Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     */
    suspend fun getRecommended(startTime: Int? = null, endTime: Int? = null, maxPhotos: Int? = null, startFrom: String? = null, count: Int? = null, fields: List<BaseUserGroupFields>? = null): NewsfeedGenericResponse {
        val response = method("newsfeed.getRecommended", mapOf("start_time" to startTime, "end_time" to endTime, "max_photos" to maxPhotos, "start_from" to startFrom, "count" to count, "fields" to fields))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns communities and users that current user is suggested to follow.
     * 
     * @param offset offset required to choose a particular subset of communities or users.
     * @param count amount of communities or users to return.
     * @param shuffle shuffle the returned list or not.
     * @param fields list of extra fields to be returned. See available fields for [vk.com/dev/fields|users] and [vk.com/dev/fields_groups|communities].
     */
    suspend fun getSuggestedSources(offset: Int? = null, count: Int? = 20, shuffle: Boolean? = false, fields: List<BaseUserGroupFields>? = null): NewsfeedGetSuggestedSourcesResponse {
        val response = method("newsfeed.getSuggestedSources", mapOf("offset" to offset, "count" to count, "shuffle" to shuffle, "fields" to fields))
        return decodeResponse(response, json)
    }

    /**
     *
     * Hides an item from the newsfeed.
     * 
     * @param type Item type. Possible values: *'wall' - post on the wall,, *'tag' - tag on a photo,, *'profilephoto' - profile photo,, *'video' - video,, *'audio' - audio.
     * @param ownerId Item owner's identifier (user or community), "Note that community id must be negative. 'owner_id=1' - user , 'owner_id=-1' - community ".
     * @param itemId Item identifier.
     */
    suspend fun ignoreItem(type: String, ownerId: Int? = 0, itemId: Int? = 0): NewsfeedIgnoreItemResponse {
        val response = method("newsfeed.ignoreItem", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId))
        return decodeResponse(response, json)
    }

    /**
     *
     * Creates and edits user newsfeed lists
     * 
     * @param listId numeric list identifier (if not sent, will be set automatically).
     * @param title list name.
     * @param sourceIds users and communities identifiers to be added to the list. Community identifiers must be negative numbers.
     * @param noReposts reposts display on and off ('1' is for off).
     */
    suspend fun saveList(title: String, listId: Int? = null, sourceIds: List<Int>? = null, noReposts: Boolean? = false): NewsfeedSaveListResponse {
        val response = method("newsfeed.saveList", mapOf("list_id" to listId, "title" to title, "source_ids" to sourceIds, "no_reposts" to noReposts))
        return decodeResponse(response, json)
    }

    /**
     *
     * Returns search results by statuses.
     * 
     * @param q Search query string (e.g., 'New Year').
     * @param extended '1' - to return additional information about the user or community that placed the post.
     * @param count Number of posts to return.
     * @param latitude Geographical latitude point (in degrees, -90 to 90) within which to search.
     * @param longitude Geographical longitude point (in degrees, -180 to 180) within which to search.
     * @param startTime Earliest timestamp (in Unix time) of a news item to return. By default, 24 hours ago.
     * @param endTime Latest timestamp (in Unix time) of a news item to return. By default, the current time.
     * @param startFrom 
     * @param fields Additional fields of [vk.com/dev/fields|profiles] and [vk.com/dev/fields_groups|communities] to return.
     */
    suspend fun search(q: String? = null, extended: Boolean? = false, count: Int? = 30, latitude: Double? = null, longitude: Double? = null, startTime: Int? = null, endTime: Int? = null, startFrom: String? = null, fields: List<BaseUserGroupFields>? = null): SearchResponse {
        val response = method("newsfeed.search", mapOf("q" to q, "extended" to extended, "count" to count, "latitude" to latitude, "longitude" to longitude, "start_time" to startTime, "end_time" to endTime, "start_from" to startFrom, "fields" to fields))
        return SearchResponse(response, json)
    }
    class SearchResponse(
        private val rawResponse: String, json: Json
    ): BaseMultivariateResponse(json) {
        fun NewsfeedSearchExtendedResponse(): NewsfeedSearchExtendedResponse? {
            return getResponseOrNull(NewsfeedSearchExtendedResponse.serializer(), rawResponse)
        }
        fun NewsfeedSearchExtendedStrictResponse(): NewsfeedSearchExtendedStrictResponse? {
            return getResponseOrNull(NewsfeedSearchExtendedStrictResponse.serializer(), rawResponse)
        }
        fun NewsfeedSearchResponse(): NewsfeedSearchResponse? {
            return getResponseOrNull(NewsfeedSearchResponse.serializer(), rawResponse)
        }
        fun NewsfeedSearchStrictResponse(): NewsfeedSearchStrictResponse? {
            return getResponseOrNull(NewsfeedSearchStrictResponse.serializer(), rawResponse)
        }
    }

    /**
     *
     * Returns a hidden item to the newsfeed.
     * 
     * @param type Item type. Possible values: *'wall' - post on the wall,, *'tag' - tag on a photo,, *'profilephoto' - profile photo,, *'video' - video,, *'audio' - audio.
     * @param ownerId Item owner's identifier (user or community), "Note that community id must be negative. 'owner_id=1' - user , 'owner_id=-1' - community ".
     * @param itemId Item identifier.
     * @param trackCode Track code of unignored item.
     */
    suspend fun unignoreItem(type: String, ownerId: Int, itemId: Int, trackCode: String? = null): BaseOkResponse {
        val response = method("newsfeed.unignoreItem", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId, "track_code" to trackCode))
        return decodeResponse(response, json)
    }

    /**
     *
     * Unsubscribes the current user from specified newsfeeds.
     * 
     * @param type Type of object from which to unsubscribe: 'note' - note, 'photo' - photo, 'post' - post on user wall or community wall, 'topic' - topic, 'video' - video.
     * @param ownerId Object owner ID.
     * @param itemId Object ID.
     */
    suspend fun unsubscribe(type: String, itemId: Int, ownerId: Int? = null): BaseOkResponse {
        val response = method("newsfeed.unsubscribe", mapOf("type" to type, "owner_id" to ownerId, "item_id" to itemId))
        return decodeResponse(response, json)
    }

}
