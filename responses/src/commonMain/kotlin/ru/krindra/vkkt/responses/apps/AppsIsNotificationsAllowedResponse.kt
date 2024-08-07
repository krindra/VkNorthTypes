package ru.krindra.vkkt.responses.apps

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.apps.*

/**
 * @param isAllowed Whether notifications are allowed for current user from concrete app or not
 */
@Serializable
data class AppsIsNotificationsAllowedResponse (
    @SerialName("is_allowed") val isAllowed: Boolean,
)

