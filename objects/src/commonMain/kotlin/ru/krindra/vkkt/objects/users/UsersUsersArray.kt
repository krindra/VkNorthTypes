package ru.krindra.vkkt.objects.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param count Users number
 * @param items 
 */
@Serializable
data class UsersUsersArray (
    @SerialName("count") val count: Int,
    @SerialName("items") val items: List<Int>,
)
