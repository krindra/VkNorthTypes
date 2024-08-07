package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param userId User ID
 */
@Serializable
data class BaseUserId (
    @SerialName("user_id") val userId: Int? = null,
)
