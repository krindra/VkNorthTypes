package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.status.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Status(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Returns data required to show the status of a user or community.
     * 
     * @param userId User ID or community ID. Use a negative value to designate a community ID.
     * @param groupId 
     */
    suspend fun get(userId: Long? = null, groupId: Long? = null): StatusGetResponse {
        val response = method("get", mapOf("user_id" to userId, "group_id" to groupId))
        return json.decodeFromString<StatusGetResponse>(response)
    }

    /**
     *
     * Sets a new status for the current user.
     * 
     * @param text Text of the new status.
     * @param groupId Identifier of a community to set a status in. If left blank the status is set to current user.
     */
    suspend fun set(text: String? = null, groupId: Long? = null): BaseOkResponse {
        val response = method("set", mapOf("text" to text, "group_id" to groupId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
