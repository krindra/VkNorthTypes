package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.storage.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Storage(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Returns a value of variable with the name set by key parameter.
     * 
     * @param key 
     * @param keys 
     * @param userId 
     */
    suspend fun get(key: String? = null, keys: List<String>? = null, userId: Long? = null): StorageGetResponse {
        val response = method("get", mapOf("key" to key, "keys" to keys, "user_id" to userId))
        return json.decodeFromString<StorageGetResponse>(response)
    }

    /**
     *
     * Returns the names of all variables.
     * 
     * @param userId user id, whose variables names are returned if they were requested with a server method.
     * @param offset 
     * @param count amount of variable names the info needs to be collected from.
     */
    suspend fun getKeys(userId: Long? = null, offset: Int? = 0, count: Int? = 100): StorageGetKeysResponse {
        val response = method("getKeys", mapOf("user_id" to userId, "offset" to offset, "count" to count))
        return json.decodeFromString<StorageGetKeysResponse>(response)
    }

    /**
     *
     * Saves a value of variable with the name set by 'key' parameter.
     * 
     * @param key 
     * @param value 
     * @param userId 
     */
    suspend fun set(key: String, value: String? = null, userId: Long? = null): BaseOkResponse {
        val response = method("set", mapOf("key" to key, "value" to value, "user_id" to userId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
