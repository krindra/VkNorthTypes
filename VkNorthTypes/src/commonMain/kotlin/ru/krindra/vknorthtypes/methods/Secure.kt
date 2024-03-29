package ru.krindra.vknorthtypes.methods

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********


import ru.krindra.vknorthtypes.types.secure.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseBoolResponse
import ru.krindra.vknorthtypes.types.base.BaseOkResponse
import ru.krindra.vknorthtypes.BaseMultivariateResponse

class Secure(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * Adds user activity information to an application
     * 
     * @param userId ID of a user to save the data.
     * @param activityId there are 2 default activities: , * 1 - level. Works similar to ,, * 2 - points, saves points amount, Any other value is for saving completed missions.
     * @param value depends on activity_id: * 1 - number, current level number,, * 2 - number, current user's points amount, , Any other value is ignored.
     */
    suspend fun addAppEvent(activityId: Long, userId: Long? = null, value: Int? = null): BaseOkResponse {
        val response = method("addAppEvent", mapOf("user_id" to userId, "activity_id" to activityId, "value" to value))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Checks the user authentication in 'IFrame' and 'Flash' apps using the 'access_token' parameter.
     * 
     * @param token client 'access_token'.
     * @param ip user 'ip address'. Note that user may access using the 'ipv6' address, in this case it is required to transmit the 'ipv6' address. If not transmitted, the address will not be checked.
     */
    suspend fun checkToken(token: String? = null, ip: String? = null): SecureCheckTokenResponse {
        val response = method("checkToken", mapOf("token" to token, "ip" to ip))
        return json.decodeFromString<SecureCheckTokenResponse>(response)
    }

    /**
     *
     * Returns payment balance of the application in hundredth of a vote.
     * 
     */
    suspend fun getAppBalance(): SecureGetAppBalanceResponse {
        val response = method("getAppBalance", mapOf())
        return json.decodeFromString<SecureGetAppBalanceResponse>(response)
    }

    /**
     *
     * Shows a list of SMS notifications sent by the application using [vk.com/dev/secure.sendSMSNotification|secure.sendSMSNotification] method.
     * 
     * @param userId 
     * @param dateFrom filter by start date. It is set as UNIX-time.
     * @param dateTo filter by end date. It is set as UNIX-time.
     * @param limit number of returned posts. By default - 1000.
     */
    suspend fun getSMSHistory(userId: Long? = null, dateFrom: Int? = null, dateTo: Int? = null, limit: Int? = 1000): SecureGetSMSHistoryResponse {
        val response = method("getSMSHistory", mapOf("user_id" to userId, "date_from" to dateFrom, "date_to" to dateTo, "limit" to limit))
        return json.decodeFromString<SecureGetSMSHistoryResponse>(response)
    }

    /**
     *
     * Shows history of votes transaction between users and the application.
     * 
     * @param type 
     * @param uidFrom 
     * @param uidTo 
     * @param dateFrom 
     * @param dateTo 
     * @param limit 
     */
    suspend fun getTransactionsHistory(type: Int? = null, uidFrom: Int? = null, uidTo: Int? = null, dateFrom: Int? = null, dateTo: Int? = null, limit: Int? = 1000): SecureGetTransactionsHistoryResponse {
        val response = method("getTransactionsHistory", mapOf("type" to type, "uid_from" to uidFrom, "uid_to" to uidTo, "date_from" to dateFrom, "date_to" to dateTo, "limit" to limit))
        return json.decodeFromString<SecureGetTransactionsHistoryResponse>(response)
    }

    /**
     *
     * Returns one of the previously set game levels of one or more users in the application.
     * 
     * @param userIds 
     */
    suspend fun getUserLevel(userIds: List<Int>): SecureGetUserLevelResponse {
        val response = method("getUserLevel", mapOf("user_ids" to userIds))
        return json.decodeFromString<SecureGetUserLevelResponse>(response)
    }

    /**
     *
     * Opens the game achievement and gives the user a sticker
     * 
     * @param userIds 
     * @param achievementId 
     */
    suspend fun giveEventSticker(userIds: List<Int>, achievementId: Long): SecureGiveEventStickerResponse {
        val response = method("giveEventSticker", mapOf("user_ids" to userIds, "achievement_id" to achievementId))
        return json.decodeFromString<SecureGiveEventStickerResponse>(response)
    }

    /**
     *
     * Sends notification to the user.
     * 
     * @param userIds 
     * @param userId 
     * @param message notification text which should be sent in 'UTF-8' encoding ('254' characters maximum).
     * @param notificationId 
     * @param promoId 
     */
    suspend fun sendNotification(message: String, userIds: List<Int>? = null, userId: Long? = null, notificationId: Long? = 0, promoId: Long? = 0): SecureSendNotificationResponse {
        val response = method("sendNotification", mapOf("user_ids" to userIds, "user_id" to userId, "message" to message, "notification_id" to notificationId, "promo_id" to promoId))
        return json.decodeFromString<SecureSendNotificationResponse>(response)
    }

    /**
     *
     * Sends 'SMS' notification to a user's mobile device.
     * 
     * @param userId ID of the user to whom SMS notification is sent. The user shall allow the application to send him/her notifications (, +1).
     * @param message 'SMS' text to be sent in 'UTF-8' encoding. Only Latin letters and numbers are allowed. Maximum size is '160' characters.
     */
    suspend fun sendSMSNotification(userId: Long, message: String): BaseOkResponse {
        val response = method("sendSMSNotification", mapOf("user_id" to userId, "message" to message))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Sets a counter which is shown to the user in bold in the left menu.
     * 
     * @param counters 
     * @param userId 
     * @param counter counter value.
     * @param increment 
     */
    suspend fun setCounter(counters: List<String>? = null, userId: Long? = null, counter: Int? = null, increment: Boolean? = false): SetcounterResponse {
        val response = method("setCounter", mapOf("counters" to counters, "user_id" to userId, "counter" to counter, "increment" to increment))
        return SetcounterResponse(response, json)
    }
    class SetcounterResponse(
        private val rawResponse: String, json: Json
    ): BaseMultivariateResponse(json) {
        fun SecureSetCounterArrayResponse(): SecureSetCounterArrayResponse? {
            return try {
                getResponse(SecureSetCounterArrayResponse.serializer(), rawResponse)
            } catch(e: Exception) { null }
        }
        fun BaseBoolResponse(): BaseBoolResponse? {
            return try {
                getResponse(BaseBoolResponse.serializer(), rawResponse)
            } catch(e: Exception) { null }
        }
    }

}
