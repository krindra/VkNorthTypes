package ru.krindra.vkkt.objects.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param adminId 
 * @param userId 
 * @param byEndDate 
 */
@Serializable
data class CallbackUserUnblock (
    @SerialName("user_id") val userId: Int,
    @SerialName("admin_id") val adminId: Int,
    @SerialName("by_end_date") val byEndDate: Int,
)
