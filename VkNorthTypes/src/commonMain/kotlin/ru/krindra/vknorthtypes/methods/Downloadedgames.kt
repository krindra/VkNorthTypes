package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.downloadedGames.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.JsonSingleton

class Downloadedgames(
    private val method: suspend (String, Map<String, Any?>?) -> String,
    private val json: Json = JsonSingleton.json
    ) {
    /**
     *
     * @param userId 
     */
    suspend fun getPaidStatus(userId: Long? = null): DownloadedGamesPaidStatusResponse {
        val response = method("downloadedGames.getPaidStatus", mapOf("user_id" to userId))
        return decodeResponse(response, json)
    }

}
