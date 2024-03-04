package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.gifts.*
import kotlinx.serialization.json.Json

class Gifts(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Returns a list of user gifts.
     * 
     * @param userId User ID.
     * @param count Number of gifts to return.
     * @param offset Offset needed to return a specific subset of results.
     */
    suspend fun get(userId: Long? = null, count: Int? = null, offset: Int? = null): GiftsGetResponse {
        val response = method("get", mapOf("user_id" to userId, "count" to count, "offset" to offset))
        return json.decodeFromString<GiftsGetResponse>(response)
    }

}
