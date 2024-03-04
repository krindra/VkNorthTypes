package ru.krindra.vknorthtypes.methods

import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseUndefinedResponse

class Execute(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     */
    suspend fun execute(): BaseUndefinedResponse {
        val response = method("execute", mapOf())
        return json.decodeFromString<BaseUndefinedResponse>(response)
    }

}
