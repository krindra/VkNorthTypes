package ru.krindra.vknorthtypes.types.likes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersSubscriptionsItem

/**
 * @param count Total number
 * @param items 
 */
@Serializable
data class LikesGetListExtendedResponse (
    @SerialName("count") val count: Int,
    @SerialName("items") val items: List<UsersSubscriptionsItem>,
)

