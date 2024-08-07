package ru.krindra.vkkt.objects.friends

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param count Total mutual friends number
 * @param users 
 */
@Serializable
data class FriendsRequestsMutual (
    @SerialName("count") val count: Int? = null,
    @SerialName("users") val users: List<Int>? = null,
)
