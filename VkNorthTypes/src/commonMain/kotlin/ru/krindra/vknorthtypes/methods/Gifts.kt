package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.gifts.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.JsonSingleton

class Gifts(
    private val method: suspend (String, Map<String, Any?>?) -> String,
    private val json: Json = JsonSingleton.json
    ) {
    /**
     *
     * Returns a list of user gifts.
     * 
     * @param userId User ID.
     * @param count Number of gifts to return.
     * @param offset Offset needed to return a specific subset of results.
     */
    suspend fun get(userId: Long? = null, count: Int? = null, offset: Int? = null): GiftsGetResponse {
        val response = method("gifts.get", mapOf("user_id" to userId, "count" to count, "offset" to offset))
        return decodeResponse(response, json)
    }

}
