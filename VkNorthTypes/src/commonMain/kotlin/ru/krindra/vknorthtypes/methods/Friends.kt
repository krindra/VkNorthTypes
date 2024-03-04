package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.friends.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.users.UsersFields
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Friends(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Approves or creates a friend request.
     * 
     * @param userId ID of the user whose friend request will be approved or to whom a friend request will be sent.
     * @param text Text of the message (up to 500 characters) for the friend request, if any.
     * @param follow '1' to pass an incoming request to followers list.
     */
    suspend fun add(userId: Long? = null, text: String? = null, follow: Boolean? = false): FriendsAddResponse {
        val response = method("add", mapOf("user_id" to userId, "text" to text, "follow" to follow))
        return json.decodeFromString<FriendsAddResponse>(response)
    }

    /**
     *
     * Creates a new friend list for the current user.
     * 
     * @param name Name of the friend list.
     * @param userIds IDs of users to be added to the friend list.
     */
    suspend fun addList(name: String, userIds: List<Int>? = null): FriendsAddListResponse {
        val response = method("addList", mapOf("name" to name, "user_ids" to userIds))
        return json.decodeFromString<FriendsAddListResponse>(response)
    }

    /**
     *
     * Checks the current user's friendship status with other specified users.
     * 
     * @param userIds IDs of the users whose friendship status to check.
     * @param needSign '1' - to return 'sign' field. 'sign' is md5("{id}_{user_id}_{friends_status}_{application_secret}"), where id is current user ID. This field allows to check that data has not been modified by the client. By default: '0'.
     * @param extended Return friend request read_state field.
     */
    suspend fun areFriends(userIds: List<Int>, needSign: Boolean? = false, extended: Boolean? = false): ArefriendsResponse {
        val response = method("areFriends", mapOf("user_ids" to userIds, "need_sign" to needSign, "extended" to extended))
        return ArefriendsResponse(response, json)
    }
    class ArefriendsResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FriendsAreFriendsExtendedResponse.serializer(), FriendsAreFriendsResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FriendsAreFriendsExtendedResponse(): FriendsAreFriendsExtendedResponse?{
            return if (response is FriendsAreFriendsExtendedResponse) response else null
        }
        fun FriendsAreFriendsResponse(): FriendsAreFriendsResponse?{
            return if (response is FriendsAreFriendsResponse) response else null
        }
    }

    /**
     *
     * Declines a friend request or deletes a user from the current user's friend list.
     * 
     * @param userId ID of the user whose friend request is to be declined or who is to be deleted from the current user's friend list.
     */
    suspend fun delete(userId: Long? = null): FriendsDeleteResponse {
        val response = method("delete", mapOf("user_id" to userId))
        return json.decodeFromString<FriendsDeleteResponse>(response)
    }

    /**
     *
     * Marks all incoming friend requests as viewed.
     * 
     */
    suspend fun deleteAllRequests(): BaseOkResponse {
        val response = method("deleteAllRequests", mapOf())
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Deletes a friend list of the current user.
     * 
     * @param listId ID of the friend list to delete.
     */
    suspend fun deleteList(listId: Long): BaseOkResponse {
        val response = method("deleteList", mapOf("list_id" to listId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits the friend lists of the selected user.
     * 
     * @param userId ID of the user whose friend list is to be edited.
     * @param listIds IDs of the friend lists to which to add the user.
     */
    suspend fun edit(userId: Long, listIds: List<Int>? = null): BaseOkResponse {
        val response = method("edit", mapOf("user_id" to userId, "list_ids" to listIds))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits a friend list of the current user.
     * 
     * @param name Name of the friend list.
     * @param listId Friend list ID.
     * @param userIds IDs of users in the friend list.
     * @param addUserIds (Applies if 'user_ids' parameter is not set.), User IDs to add to the friend list.
     * @param deleteUserIds (Applies if 'user_ids' parameter is not set.), User IDs to delete from the friend list.
     */
    suspend fun editList(listId: Long, name: String? = null, userIds: List<Int>? = null, addUserIds: List<Int>? = null, deleteUserIds: List<Int>? = null): BaseOkResponse {
        val response = method("editList", mapOf("name" to name, "list_id" to listId, "user_ids" to userIds, "add_user_ids" to addUserIds, "delete_user_ids" to deleteUserIds))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns a list of user IDs or detailed information about a user's friends.
     * 
     * @param userId User ID. By default, the current user ID.
     * @param order Sort order: , 'name' - by name (enabled only if the 'fields' parameter is used), 'hints' - by rating, similar to how friends are sorted in My friends section, , This parameter is available only for [vk.com/dev/standalone|desktop applications].
     * @param listId ID of the friend list returned by the [vk.com/dev/friends.getLists|friends.getLists] method to be used as the source. This parameter is taken into account only when the uid parameter is set to the current user ID. This parameter is available only for [vk.com/dev/standalone|desktop applications].
     * @param count Number of friends to return.
     * @param offset Offset needed to return a specific subset of friends.
     * @param fields Profile fields to return. Sample values: 'uid', 'first_name', 'last_name', 'nickname', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'domain', 'has_mobile', 'rate', 'contacts', 'education'.
     * @param ref 
     */
    suspend fun get(userId: Long? = null, order: String? = null, listId: Long? = null, count: Int? = 5000, offset: Int? = null, fields: List<UsersFields>? = null, ref: String? = null): GetResponse {
        val response = method("get", mapOf("user_id" to userId, "order" to order, "list_id" to listId, "count" to count, "offset" to offset, "fields" to fields, "ref" to ref))
        return GetResponse(response, json)
    }
    class GetResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FriendsGetFieldsResponse.serializer(), FriendsGetResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FriendsGetFieldsResponse(): FriendsGetFieldsResponse?{
            return if (response is FriendsGetFieldsResponse) response else null
        }
        fun FriendsGetResponse(): FriendsGetResponse?{
            return if (response is FriendsGetResponse) response else null
        }
    }

    /**
     *
     * Returns a list of IDs of the current user's friends who installed the application.
     * 
     */
    suspend fun getAppUsers(): FriendsGetAppUsersResponse {
        val response = method("getAppUsers", mapOf())
        return json.decodeFromString<FriendsGetAppUsersResponse>(response)
    }

    /**
     *
     * Returns a list of the current user's friends whose phone numbers, validated or specified in a profile, are in a given list.
     * 
     * @param phones List of phone numbers in MSISDN format (maximum 1000). Example: "+79219876543,+79111234567".
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online, counters'.
     */
    suspend fun getByPhones(phones: List<String>? = null, fields: List<UsersFields>? = null): FriendsGetByPhonesResponse {
        val response = method("getByPhones", mapOf("phones" to phones, "fields" to fields))
        return json.decodeFromString<FriendsGetByPhonesResponse>(response)
    }

    /**
     *
     * Returns a list of the user's friend lists.
     * 
     * @param userId User ID.
     * @param returnSystem '1' - to return system friend lists. By default: '0'.
     */
    suspend fun getLists(userId: Long? = null, returnSystem: Boolean? = false): FriendsGetListsResponse {
        val response = method("getLists", mapOf("user_id" to userId, "return_system" to returnSystem))
        return json.decodeFromString<FriendsGetListsResponse>(response)
    }

    /**
     *
     * Returns a list of user IDs of the mutual friends of two users.
     * 
     * @param sourceUid ID of the user whose friends will be checked against the friends of the user specified in 'target_uid'.
     * @param targetUid ID of the user whose friends will be checked against the friends of the user specified in 'source_uid'.
     * @param targetUids IDs of the users whose friends will be checked against the friends of the user specified in 'source_uid'.
     * @param order Sort order: 'random' - random order.
     * @param count Number of mutual friends to return.
     * @param offset Offset needed to return a specific subset of mutual friends.
     */
    suspend fun getMutual(sourceUid: Long? = null, targetUid: Long? = null, targetUids: List<Int>? = null, order: String? = null, count: Int? = null, offset: Int? = null): GetmutualResponse {
        val response = method("getMutual", mapOf("source_uid" to sourceUid, "target_uid" to targetUid, "target_uids" to targetUids, "order" to order, "count" to count, "offset" to offset))
        return GetmutualResponse(response, json)
    }
    class GetmutualResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FriendsGetMutualTargetUidsResponse.serializer(), FriendsGetMutualResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FriendsGetMutualTargetUidsResponse(): FriendsGetMutualTargetUidsResponse?{
            return if (response is FriendsGetMutualTargetUidsResponse) response else null
        }
        fun FriendsGetMutualResponse(): FriendsGetMutualResponse?{
            return if (response is FriendsGetMutualResponse) response else null
        }
    }

    /**
     *
     * Returns a list of user IDs of a user's friends who are online.
     * 
     * @param userId User ID.
     * @param listId Friend list ID. If this parameter is not set, information about all online friends is returned.
     * @param onlineMobile '1' - to return an additional 'online_mobile' field, '0' - (default),.
     * @param order Sort order: 'random' - random order.
     * @param count Number of friends to return.
     * @param offset Offset needed to return a specific subset of friends.
     */
    suspend fun getOnline(userId: Long? = null, listId: Long? = null, onlineMobile: Boolean? = false, order: String? = null, count: Int? = null, offset: Int? = null): GetonlineResponse {
        val response = method("getOnline", mapOf("user_id" to userId, "list_id" to listId, "online_mobile" to onlineMobile, "order" to order, "count" to count, "offset" to offset))
        return GetonlineResponse(response, json)
    }
    class GetonlineResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FriendsGetOnlineResponse.serializer(), FriendsGetOnlineOnlineMobileResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FriendsGetOnlineResponse(): FriendsGetOnlineResponse?{
            return if (response is FriendsGetOnlineResponse) response else null
        }
        fun FriendsGetOnlineOnlineMobileResponse(): FriendsGetOnlineOnlineMobileResponse?{
            return if (response is FriendsGetOnlineOnlineMobileResponse) response else null
        }
    }

    /**
     *
     * Returns a list of user IDs of the current user's recently added friends.
     * 
     * @param count Number of recently added friends to return.
     */
    suspend fun getRecent(count: Int? = 100): FriendsGetRecentResponse {
        val response = method("getRecent", mapOf("count" to count))
        return json.decodeFromString<FriendsGetRecentResponse>(response)
    }

    /**
     *
     * Returns information about the current user's incoming and outgoing friend requests.
     * 
     * @param offset Offset needed to return a specific subset of friend requests.
     * @param count Number of friend requests to return (default 100, maximum 1000).
     * @param extended '1' - to return response messages from users who have sent a friend request or, if 'suggested' is set to '1', to return a list of suggested friends.
     * @param needMutual '1' - to return a list of mutual friends (up to 20), if any.
     * @param out '1' - to return outgoing requests, '0' - to return incoming requests (default).
     * @param sort Sort order: '1' - by number of mutual friends, '0' - by date.
     * @param needViewed 
     * @param suggested '1' - to return a list of suggested friends, '0' - to return friend requests (default).
     * @param ref 
     * @param fields 
     */
    suspend fun getRequests(offset: Int? = null, count: Int? = 100, extended: Boolean? = false, needMutual: Boolean? = false, out: Boolean? = false, sort: Int? = null, needViewed: Boolean? = false, suggested: Boolean? = false, ref: String? = null, fields: List<UsersFields>? = null): GetrequestsResponse {
        val response = method("getRequests", mapOf("offset" to offset, "count" to count, "extended" to extended, "need_mutual" to needMutual, "out" to out, "sort" to sort, "need_viewed" to needViewed, "suggested" to suggested, "ref" to ref, "fields" to fields))
        return GetrequestsResponse(response, json)
    }
    class GetrequestsResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(FriendsGetRequestsNeedMutualResponse.serializer(), FriendsGetRequestsResponse.serializer(), FriendsGetRequestsExtendedResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun FriendsGetRequestsNeedMutualResponse(): FriendsGetRequestsNeedMutualResponse?{
            return if (response is FriendsGetRequestsNeedMutualResponse) response else null
        }
        fun FriendsGetRequestsResponse(): FriendsGetRequestsResponse?{
            return if (response is FriendsGetRequestsResponse) response else null
        }
        fun FriendsGetRequestsExtendedResponse(): FriendsGetRequestsExtendedResponse?{
            return if (response is FriendsGetRequestsExtendedResponse) response else null
        }
    }

    /**
     *
     * Returns a list of profiles of users whom the current user may know.
     * 
     * @param filter Types of potential friends to return: 'mutual' - users with many mutual friends , 'contacts' - users found with the [vk.com/dev/account.importContacts|account.importContacts] method , 'mutual_contacts' - users who imported the same contacts as the current user with the [vk.com/dev/account.importContacts|account.importContacts] method.
     * @param count Number of suggestions to return.
     * @param offset Offset needed to return a specific subset of suggestions.
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online', 'counters'.
     * @param nameCase Case for declension of user name and surname: , 'nom' - nominative (default) , 'gen' - genitive , 'dat' - dative , 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     */
    suspend fun getSuggestions(filter: List<String>? = null, count: Int? = 500, offset: Int? = null, fields: List<UsersFields>? = null, nameCase: String? = null): FriendsGetSuggestionsResponse {
        val response = method("getSuggestions", mapOf("filter" to filter, "count" to count, "offset" to offset, "fields" to fields, "name_case" to nameCase))
        return json.decodeFromString<FriendsGetSuggestionsResponse>(response)
    }

    /**
     *
     * Returns a list of friends matching the search criteria.
     * 
     * @param userId User ID.
     * @param q Search query string (e.g., 'Vasya Babich').
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'rate', 'contacts', 'education', 'online',.
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default), 'gen' - genitive , 'dat' - dative, 'acc' - accusative , 'ins' - instrumental , 'abl' - prepositional.
     * @param offset Offset needed to return a specific subset of friends.
     * @param count Number of friends to return.
     */
    suspend fun search(userId: Long? = null, q: String? = null, fields: List<UsersFields>? = null, nameCase: String? = null, offset: Int? = null, count: Int? = 20): FriendsSearchResponse {
        val response = method("search", mapOf("user_id" to userId, "q" to q, "fields" to fields, "name_case" to nameCase, "offset" to offset, "count" to count))
        return json.decodeFromString<FriendsSearchResponse>(response)
    }

}
