package ru.krindra.vkkt.objects.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param userId 
 * @param joinType 
 */
@Serializable
data class CallbackGroupJoin (
    @SerialName("user_id") val userId: Int,
    @SerialName("join_type") val joinType: CallbackGroupJoinType,
)
