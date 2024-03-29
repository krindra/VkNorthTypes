package ru.krindra.vknorthtypes.methods

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********


import ru.krindra.vknorthtypes.types.calls.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Calls(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param callId 
     */
    suspend fun forceFinish(callId: String): BaseOkResponse {
        val response = method("forceFinish", mapOf("call_id" to callId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param groupId 
     */
    suspend fun start(groupId: Long? = 0): CallsStartResponse {
        val response = method("start", mapOf("group_id" to groupId))
        return json.decodeFromString<CallsStartResponse>(response)
    }

}
