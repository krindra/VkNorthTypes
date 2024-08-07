package ru.krindra.vkkt.objects.notifications

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param userId User ID
 * @param status Notification status
 * @param error 
 */
@Serializable
data class NotificationsSendMessageItem (
    @SerialName("user_id") val userId: Int? = null,
    @SerialName("status") val status: Boolean? = null,
    @SerialName("error") val error: NotificationsSendMessageError? = null,
)
