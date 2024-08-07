package ru.krindra.vkkt.objects.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param topicOwnerId 
 * @param topicId 
 * @param id 
 */
@Serializable
data class CallbackBoardPostDelete (
    @SerialName("id") val id: Int,
    @SerialName("topic_id") val topicId: Int,
    @SerialName("topic_owner_id") val topicOwnerId: Int,
)
