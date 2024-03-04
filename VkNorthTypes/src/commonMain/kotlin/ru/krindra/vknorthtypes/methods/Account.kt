package ru.krindra.vknorthtypes.methods

import ru.krindra.vknorthtypes.types.account.*
import kotlinx.serialization.json.Json
import ru.krindra.vknorthtypes.types.base.BaseOkResponse

class Account(private val method: suspend (String, Map<Any, Any?>) -> String, private val json: Json) {
    /**
     *
     * @param ownerId 
     */
    suspend fun ban(ownerId: Long? = null): BaseOkResponse {
        val response = method("ban", mapOf("owner_id" to ownerId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Changes a user password after access is successfully restored with the [vk.com/dev/auth.restore|auth.restore] method.
     * 
     * @param restoreSid Session id received after the [vk.com/dev/auth.restore|auth.restore] method is executed. (If the password is changed right after the access was restored).
     * @param changePasswordHash Hash received after a successful OAuth authorization with a code got by SMS. (If the password is changed right after the access was restored).
     * @param oldPassword Current user password.
     * @param newPassword New password that will be set as a current.
     */
    suspend fun changePassword(newPassword: String, restoreSid: String? = null, changePasswordHash: String? = null, oldPassword: String? = null): AccountChangePasswordResponse {
        val response = method("changePassword", mapOf("restore_sid" to restoreSid, "change_password_hash" to changePasswordHash, "old_password" to oldPassword, "new_password" to newPassword))
        return json.decodeFromString<AccountChangePasswordResponse>(response)
    }

    /**
     *
     * Returns a list of active ads (offers) which executed by the user will bring him/her respective number of votes to his balance in the application.
     * 
     * @param offset 
     * @param count Number of results to return.
     */
    suspend fun getActiveOffers(offset: Int? = 0, count: Int? = 100): AccountGetActiveOffersResponse {
        val response = method("getActiveOffers", mapOf("offset" to offset, "count" to count))
        return json.decodeFromString<AccountGetActiveOffersResponse>(response)
    }

    /**
     *
     * Gets settings of the user in this application.
     * 
     * @param userId User ID whose settings information shall be got. By default: current user.
     */
    suspend fun getAppPermissions(userId: Long? = null): AccountGetAppPermissionsResponse {
        val response = method("getAppPermissions", mapOf("user_id" to userId))
        return json.decodeFromString<AccountGetAppPermissionsResponse>(response)
    }

    /**
     *
     * Returns a user's blacklist.
     * 
     * @param offset Offset needed to return a specific subset of results.
     * @param count Number of results to return.
     */
    suspend fun getBanned(offset: Int? = null, count: Int? = 20): AccountGetBannedResponse {
        val response = method("getBanned", mapOf("offset" to offset, "count" to count))
        return json.decodeFromString<AccountGetBannedResponse>(response)
    }

    /**
     *
     * Returns non-null values of user counters.
     * 
     * @param filter Counters to be returned.
     */
    suspend fun getCounters(filter: List<String>? = null): AccountGetCountersResponse {
        val response = method("getCounters", mapOf("filter" to filter))
        return json.decodeFromString<AccountGetCountersResponse>(response)
    }

    /**
     *
     * Returns current account info.
     * 
     * @param fields Fields to return. Possible values: *'country' - user country,, *'https_required' - is "HTTPS only" option enabled,, *'own_posts_default' - is "Show my posts only" option is enabled,, *'no_wall_replies' - are wall replies disabled or not,, *'intro' - is intro passed by user or not,, *'lang' - user language. By default: all.
     */
    suspend fun getInfo(fields: List<String>? = null): AccountGetInfoResponse {
        val response = method("getInfo", mapOf("fields" to fields))
        return json.decodeFromString<AccountGetInfoResponse>(response)
    }

    /**
     *
     * Returns the current account info.
     * 
     */
    suspend fun getProfileInfo(): AccountGetProfileInfoResponse {
        val response = method("getProfileInfo", mapOf())
        return json.decodeFromString<AccountGetProfileInfoResponse>(response)
    }

    /**
     *
     * Gets settings of push notifications.
     * 
     * @param deviceId Unique device ID.
     */
    suspend fun getPushSettings(deviceId: String? = null): AccountGetPushSettingsResponse {
        val response = method("getPushSettings", mapOf("device_id" to deviceId))
        return json.decodeFromString<AccountGetPushSettingsResponse>(response)
    }

    /**
     *
     * Subscribes an iOS/Android/Windows Phone-based device to receive push notifications
     * 
     * @param token Device token used to send notifications. (for mpns, the token shall be URL for sending of notifications).
     * @param deviceModel String name of device model.
     * @param deviceYear Device year.
     * @param deviceId Unique device ID.
     * @param systemVersion String version of device operating system.
     * @param settings Push settings in a [vk.com/dev/push_settings|special format].
     * @param sandbox 
     */
    suspend fun registerDevice(token: String, deviceId: String, deviceModel: String? = null, deviceYear: Int? = null, systemVersion: String? = null, settings: String? = null, sandbox: Boolean? = false): BaseOkResponse {
        val response = method("registerDevice", mapOf("token" to token, "device_model" to deviceModel, "device_year" to deviceYear, "device_id" to deviceId, "system_version" to systemVersion, "settings" to settings, "sandbox" to sandbox))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Edits current profile info.
     * 
     * @param firstName User first name.
     * @param lastName User last name.
     * @param maidenName User maiden name (female only).
     * @param screenName User screen name.
     * @param cancelRequestId ID of the name change request to be canceled. If this parameter is sent, all the others are ignored.
     * @param sex User sex. Possible values: , * '1' - female,, * '2' - male.
     * @param relation User relationship status. Possible values: , * '1' - single,, * '2' - in a relationship,, * '3' - engaged,, * '4' - married,, * '5' - it's complicated,, * '6' - actively searching,, * '7' - in love,, * '0' - not specified.
     * @param relationPartnerId ID of the relationship partner.
     * @param bdate User birth date, format: DD.MM.YYYY.
     * @param bdateVisibility Birth date visibility. Returned values: , * '1' - show birth date,, * '2' - show only month and day,, * '0' - hide birth date.
     * @param homeTown User home town.
     * @param countryId User country.
     * @param cityId User city.
     * @param status Status text.
     */
    suspend fun saveProfileInfo(firstName: String? = null, lastName: String? = null, maidenName: String? = null, screenName: String? = null, cancelRequestId: Long? = null, sex: Int? = null, relation: Int? = null, relationPartnerId: Long? = null, bdate: String? = null, bdateVisibility: Int? = null, homeTown: String? = null, countryId: Long? = null, cityId: Long? = null, status: String? = null): AccountSaveProfileInfoResponse {
        val response = method("saveProfileInfo", mapOf("first_name" to firstName, "last_name" to lastName, "maiden_name" to maidenName, "screen_name" to screenName, "cancel_request_id" to cancelRequestId, "sex" to sex, "relation" to relation, "relation_partner_id" to relationPartnerId, "bdate" to bdate, "bdate_visibility" to bdateVisibility, "home_town" to homeTown, "country_id" to countryId, "city_id" to cityId, "status" to status))
        return json.decodeFromString<AccountSaveProfileInfoResponse>(response)
    }

    /**
     *
     * Allows to edit the current account info.
     * 
     * @param name Setting name.
     * @param value Setting value.
     */
    suspend fun setInfo(name: String? = null, value: String? = null): BaseOkResponse {
        val response = method("setInfo", mapOf("name" to name, "value" to value))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Marks a current user as offline.
     * 
     */
    suspend fun setOffline(): BaseOkResponse {
        val response = method("setOffline", mapOf())
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Marks the current user as online for 15 minutes.
     * 
     * @param voip '1' if videocalls are available for current device.
     */
    suspend fun setOnline(voip: Boolean? = false): BaseOkResponse {
        val response = method("setOnline", mapOf("voip" to voip))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Change push settings.
     * 
     * @param deviceId Unique device ID.
     * @param settings Push settings in a [vk.com/dev/push_settings|special format].
     * @param key Notification key.
     * @param value New value for the key in a [vk.com/dev/push_settings|special format].
     */
    suspend fun setPushSettings(deviceId: String, settings: String? = null, key: String? = null, value: List<String>? = null): BaseOkResponse {
        val response = method("setPushSettings", mapOf("device_id" to deviceId, "settings" to settings, "key" to key, "value" to value))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Mutes push notifications for the set period of time.
     * 
     * @param deviceId Unique device ID.
     * @param time Time in seconds for what notifications should be disabled. '-1' to disable forever.
     * @param peerId Destination ID. "For user: 'User ID', e.g. '12345'. For chat: '2000000000' + 'Chat ID', e.g. '2000000001'. For community: '- Community ID', e.g. '-12345'. ".
     * @param sound '1' - to enable sound in this dialog, '0' - to disable sound. Only if 'peer_id' contains user or community ID.
     */
    suspend fun setSilenceMode(deviceId: String? = null, time: Int? = null, peerId: Long? = null, sound: Int? = null): BaseOkResponse {
        val response = method("setSilenceMode", mapOf("device_id" to deviceId, "time" to time, "peer_id" to peerId, "sound" to sound))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * @param ownerId 
     */
    suspend fun unban(ownerId: Long? = null): BaseOkResponse {
        val response = method("unban", mapOf("owner_id" to ownerId))
        return json.decodeFromString<BaseOkResponse>(response)
    }

    /**
     *
     * Unsubscribes a device from push notifications.
     * 
     * @param deviceId Unique device ID.
     * @param sandbox 
     */
    suspend fun unregisterDevice(deviceId: String? = null, sandbox: Boolean? = false): BaseOkResponse {
        val response = method("unregisterDevice", mapOf("device_id" to deviceId, "sandbox" to sandbox))
        return json.decodeFromString<BaseOkResponse>(response)
    }

}
