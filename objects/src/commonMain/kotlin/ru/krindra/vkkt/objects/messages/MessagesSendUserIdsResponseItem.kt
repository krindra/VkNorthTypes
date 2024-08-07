package ru.krindra.vkkt.objects.messages

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseMessageError

/**
 *
 * @param peerId 
 * @param messageId 
 * @param conversationMessageId 
 * @param error 
 */
@Serializable
data class MessagesSendUserIdsResponseItem (
    @SerialName("peer_id") val peerId: Int,
    @SerialName("message_id") val messageId: Int,
    @SerialName("error") val error: BaseMessageError? = null,
    @SerialName("conversation_message_id") val conversationMessageId: Int? = null,
)
