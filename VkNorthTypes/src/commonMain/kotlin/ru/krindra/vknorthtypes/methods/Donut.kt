package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.donut.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.groups.GroupsGetMembersFieldsResponse
import ru.krindra.vknorthtypes.types.base.BaseUserGroupFields
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse

class Donut(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param ownerId 
     * @param offset 
     * @param count 
     * @param fields 
     */
    suspend fun getFriends(ownerId: Long, offset: Int? = 0, count: Int? = 10, fields: List<String>? = null): GroupsGetMembersFieldsResponse {
        val response = method("getFriends", mapOf("owner_id" to ownerId, "offset" to offset, "count" to count, "fields" to fields))
        return json.decodeFromString<GroupsGetMembersFieldsResponse>(response)
    }

    /**
     *
     * @param ownerId 
     */
    suspend fun getSubscription(ownerId: Long): DonutGetSubscriptionResponse {
        val response = method("getSubscription", mapOf("owner_id" to ownerId))
        return json.decodeFromString<DonutGetSubscriptionResponse>(response)
    }

    /**
     *
     * Returns a list of user's VK Donut subscriptions.
     * 
     * @param fields 
     * @param offset 
     * @param count 
     */
    suspend fun getSubscriptions(fields: List<BaseUserGroupFields>? = null, offset: Int? = 0, count: Int? = 10): DonutGetSubscriptionsResponse {
        val response = method("getSubscriptions", mapOf("fields" to fields, "offset" to offset, "count" to count))
        return json.decodeFromString<DonutGetSubscriptionsResponse>(response)
    }

    /**
     *
     * @param ownerId 
     */
    suspend fun isDon(ownerId: Long): BaseBoolResponse {
        val response = method("isDon", mapOf("owner_id" to ownerId))
        return json.decodeFromString<BaseBoolResponse>(response)
    }

}
