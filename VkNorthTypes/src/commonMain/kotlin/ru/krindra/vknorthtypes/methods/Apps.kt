package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.apps.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.users.UsersFields
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Apps(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param userIds 
     * @param groupId 
     */
    suspend fun addUsersToTestingGroup(userIds: List<Int>, groupId: Long): BaseBoolResponse {
        val response = method("addUsersToTestingGroup", mapOf("user_ids" to userIds, "group_id" to groupId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Deletes all request notifications from the current app.
     * 
     */
    suspend fun deleteAppRequests(): BaseOkResponse {
        val response = method("deleteAppRequests", mapOf())
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Returns applications data.
     * 
     * @param appId Application ID.
     * @param appIds List of application ID.
     * @param platform platform. Possible values: *'ios' - iOS,, *'android' - Android,, *'winphone' - Windows Phone,, *'web' - приложения на vk.com. By default: 'web'.
     * @param extended 
     * @param returnFriends 
     * @param fields Profile fields to return. Sample values: 'nickname', 'screen_name', 'sex', 'bdate' (birthdate), 'city', 'country', 'timezone', 'photo', 'photo_medium', 'photo_big', 'has_mobile', 'contacts', 'education', 'online', 'counters', 'relation', 'last_seen', 'activity', 'can_write_private_message', 'can_see_all_posts', 'can_post', 'universities', (only if return_friends - 1).
     * @param nameCase Case for declension of user name and surname: 'nom' - nominative (default),, 'gen' - genitive,, 'dat' - dative,, 'acc' - accusative,, 'ins' - instrumental,, 'abl' - prepositional. (only if 'return_friends' = '1').
     * @param appFields List of app fields to return. Fields 'id', 'type' and 'title' will always be in response. Leave this field empty to get all fields.
     */
    suspend fun get(appId: Long? = null, appIds: List<Int>? = null, platform: String? = "web", extended: Boolean? = false, returnFriends: Boolean? = false, fields: List<UsersFields>? = null, nameCase: String? = null, appFields: List<AppsAppFields>? = null): AppsGetResponse {
        val response = method("get", mapOf("app_id" to appId, "app_ids" to appIds, "platform" to platform, "extended" to extended, "return_friends" to returnFriends, "fields" to fields, "name_case" to nameCase, "app_fields" to appFields))
        return json.decodeFromString<AppsGetResponse>(response)
    }

    /**
     *
     * Returns a list of applications (apps) available to users in the App Catalog.
     * 
     * @param sort Sort order: 'popular_today' - popular for one day (default), 'visitors' - by visitors number , 'create_date' - by creation date, 'growth_rate' - by growth rate, 'popular_week' - popular for one week.
     * @param offset Offset required to return a specific subset of apps.
     * @param count Number of apps to return.
     * @param platform 
     * @param extended '1' - to return additional fields 'screenshots', 'MAU', 'catalog_position', and 'international'. If set, 'count' must be less than or equal to '100'. '0' - not to return additional fields (default).
     * @param returnFriends 
     * @param fields 
     * @param nameCase 
     * @param q Search query string.
     * @param genreId 
     * @param filter 'installed' - to return list of installed apps (only for mobile platform).
     */
    suspend fun getCatalog(sort: String? = null, offset: Int? = null, count: Int? = 100, platform: String? = null, extended: Boolean? = false, returnFriends: Boolean? = false, fields: List<UsersFields>? = null, nameCase: String? = null, q: String? = null, genreId: Long? = null, filter: String? = null): AppsGetCatalogResponse {
        val response = method("getCatalog", mapOf("sort" to sort, "offset" to offset, "count" to count, "platform" to platform, "extended" to extended, "return_friends" to returnFriends, "fields" to fields, "name_case" to nameCase, "q" to q, "genre_id" to genreId, "filter" to filter))
        return json.decodeFromString<AppsGetCatalogResponse>(response)
    }

    /**
     *
     * Creates friends list for requests and invites in current app.
     * 
     * @param extended 
     * @param count List size.
     * @param offset 
     * @param type List type. Possible values: * 'invite' - available for invites (don't play the game),, * 'request' - available for request (play the game). By default: 'invite'.
     * @param fields Additional profile fields, see [vk.com/dev/fields|description].
     * @param query Search query string (e.g., 'Vasya Babich').
     */
    suspend fun getFriendsList(extended: Boolean? = false, count: Int? = 20, offset: Int? = 0, type: String? = "invite", fields: List<UsersFields>? = null, query: String? = null): GetfriendslistResponse {
        val response = method("getFriendsList", mapOf("extended" to extended, "count" to count, "offset" to offset, "type" to type, "fields" to fields, "query" to query))
        return GetfriendslistResponse(response, json)
    }
    class GetfriendslistResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(AppsGetFriendsListExtendedResponse.serializer(), AppsGetFriendsListResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun AppsGetFriendsListExtendedResponse(): AppsGetFriendsListExtendedResponse?{
            return if (response is AppsGetFriendsListExtendedResponse) response else null
        }
        fun AppsGetFriendsListResponse(): AppsGetFriendsListResponse?{
            return if (response is AppsGetFriendsListResponse) response else null
        }
    }

    /**
     *
     */
    suspend fun getLastUploadedVersion(): AppsGetLastUploadedVersionResponse {
        val response = method("getLastUploadedVersion", mapOf())
        return json.decodeFromString<AppsGetLastUploadedVersionResponse>(response)
    }

    /**
     *
     * Returns players rating in the game.
     * 
     * @param type Leaderboard type. Possible values: *'level' - by level,, *'points' - by mission points,, *'score' - by score ().
     * @param global_ Rating type. Possible values: *'1' - global rating among all players,, *'0' - rating among user friends.
     * @param extended 1 - to return additional info about users.
     */
    suspend fun getLeaderboard(type: String, global_: Boolean? = true, extended: Boolean? = false): GetleaderboardResponse {
        val response = method("getLeaderboard", mapOf("type" to type, "global_" to global_, "extended" to extended))
        return GetleaderboardResponse(response, json)
    }
    class GetleaderboardResponse(private val rawResponse: String, json: Json):
        BaseMultivariateResponse(json) {
        private val response: Any = response()
        private val responsesSerializers = listOf(AppsGetLeaderboardExtendedResponse.serializer(), AppsGetLeaderboardResponse.serializer())

        private fun response(): Any {
            for (i in responsesSerializers) {
                val r = getResponse(i, rawResponse)
                if (r != null) {
                    return r
                }
            }
            throw Exception()
        }
        
        fun AppsGetLeaderboardExtendedResponse(): AppsGetLeaderboardExtendedResponse?{
            return if (response is AppsGetLeaderboardExtendedResponse) response else null
        }
        fun AppsGetLeaderboardResponse(): AppsGetLeaderboardResponse?{
            return if (response is AppsGetLeaderboardResponse) response else null
        }
    }

    /**
     *
     * Returns policies and terms given to a mini app.
     * 
     * @param appId Mini App ID.
     */
    suspend fun getMiniAppPolicies(appId: Long): AppsGetMiniAppPoliciesResponse {
        val response = method("getMiniAppPolicies", mapOf("app_id" to appId))
        return json.decodeFromString<AppsGetMiniAppPoliciesResponse>(response)
    }

    /**
     *
     * Returns scopes for auth
     * 
     * @param type 
     */
    suspend fun getScopes(type: String? = "user"): AppsGetScopesResponse {
        val response = method("getScopes", mapOf("type" to type))
        return json.decodeFromString<AppsGetScopesResponse>(response)
    }

    /**
     *
     * Returns user score in app
     * 
     * @param userId 
     */
    suspend fun getScore(userId: Long? = null): AppsGetScoreResponse {
        val response = method("getScore", mapOf("user_id" to userId))
        return json.decodeFromString<AppsGetScoreResponse>(response)
    }

    /**
     *
     * @param groupId 
     */
    suspend fun getTestingGroups(groupId: Long? = null): AppsGetTestingGroupsResponse {
        val response = method("getTestingGroups", mapOf("group_id" to groupId))
        return json.decodeFromString<AppsGetTestingGroupsResponse>(response)
    }

    /**
     *
     * @param userId 
     */
    suspend fun isNotificationsAllowed(userId: Long? = null): AppsIsNotificationsAllowedResponse {
        val response = method("isNotificationsAllowed", mapOf("user_id" to userId))
        return json.decodeFromString<AppsIsNotificationsAllowedResponse>(response)
    }

    /**
     *
     * @param promoId Id of game promo action.
     * @param userId 
     */
    suspend fun promoHasActiveGift(promoId: Long, userId: Long? = null): BaseBoolResponse {
        val response = method("promoHasActiveGift", mapOf("promo_id" to promoId, "user_id" to userId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * @param promoId Id of game promo action.
     * @param userId 
     */
    suspend fun promoUseGift(promoId: Long, userId: Long? = null): BaseBoolResponse {
        val response = method("promoUseGift", mapOf("promo_id" to promoId, "user_id" to userId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * @param groupId 
     */
    suspend fun removeTestingGroup(groupId: Long): BaseBoolResponse {
        val response = method("removeTestingGroup", mapOf("group_id" to groupId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * @param userIds 
     */
    suspend fun removeUsersFromTestingGroups(userIds: List<Int>): BaseBoolResponse {
        val response = method("removeUsersFromTestingGroups", mapOf("user_ids" to userIds))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

    /**
     *
     * Sends a request to another user in an app that uses VK authorization.
     * 
     * @param userId id of the user to send a request.
     * @param text request text.
     * @param type request type. Values: 'invite' - if the request is sent to a user who does not have the app installed,, 'request' - if a user has already installed the app.
     * @param name 
     * @param key special string key to be sent with the request.
     * @param separate 
     */
    suspend fun sendRequest(userId: Long, text: String? = null, type: String? = "request", name: String? = null, key: String? = null, separate: Boolean? = false): AppsSendRequestResponse {
        val response = method("sendRequest", mapOf("user_id" to userId, "text" to text, "type" to type, "name" to name, "key" to key, "separate" to separate))
        return json.decodeFromString<AppsSendRequestResponse>(response)
    }

    /**
     *
     * @param groupId 
     * @param webview 
     * @param name 
     * @param platforms 
     * @param userIds 
     */
    suspend fun updateMetaForTestingGroup(webview: String, name: String, platforms: List<String>, groupId: Long? = null, userIds: List<Int>? = null): AppsCreatedGroupResponse {
        val response = method("updateMetaForTestingGroup", mapOf("group_id" to groupId, "webview" to webview, "name" to name, "platforms" to platforms, "user_ids" to userIds))
        return json.decodeFromString<AppsCreatedGroupResponse>(response)
    }

}
