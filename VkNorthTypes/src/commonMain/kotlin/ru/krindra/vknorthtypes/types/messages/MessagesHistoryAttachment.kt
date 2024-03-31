package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param attachment 
 * @param date Message sending time
 * @param messageId Message ID
 * @param messageExpireTtl Message Exipire ttl
 * @param cmid Conversation Message ID
 * @param fromId Message author's ID
 * @param forwardLevel Forward level (optional)
 * @param wasListened 
 * @param position Attachment position in the Message
 */
@Serializable
data class MessagesHistoryAttachment (
    @SerialName("cmid") val cmid: Long? = null,
    @SerialName("forward_level") val forwardLevel: Int? = null,
    @SerialName("was_listened") val wasListened: Boolean? = null,
    @SerialName("attachment") val attachment: MessagesHistoryMessageAttachment,
    @SerialName("message_id") val messageId: Long,
    @SerialName("message_expire_ttl") val messageExpireTtl: Int? = null,
    @SerialName("date") val date: Int,
    @SerialName("position") val position: Int? = null,
    @SerialName("from_id") val fromId: Long,
)
