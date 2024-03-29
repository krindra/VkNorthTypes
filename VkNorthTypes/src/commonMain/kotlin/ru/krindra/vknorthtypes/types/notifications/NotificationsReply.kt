package ru.krindra.vknorthtypes.types.notifications

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param date Date when the reply has been created in Unixtime
 * @param id Reply ID
 * @param text Reply text
 */
@Serializable
data class NotificationsReply (
    @SerialName("text") val text: Int? = null,
    @SerialName("date") val date: Int? = null,
    @SerialName("id") val id: Long? = null,
)
