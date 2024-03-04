package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.auth.*
import kotlinx.serialization.json.Json

class Auth(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Allows to restore account access using a code received via SMS. " This method is only available for apps with [vk.com/dev/auth_direct|Direct authorization] access. "
     * 
     * @param phone User phone number.
     * @param lastName User last name.
     */
    suspend fun restore(phone: String, lastName: String): AuthRestoreResponse {
        val response = method("restore", mapOf("phone" to phone, "last_name" to lastName))
        return json.decodeFromString<AuthRestoreResponse>(response)
    }

}
