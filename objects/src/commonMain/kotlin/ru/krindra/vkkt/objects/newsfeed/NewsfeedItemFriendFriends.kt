package ru.krindra.vkkt.objects.newsfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.base.BaseUserId

/**
 *
 * @param count Number of friends has been added
 * @param items 
 */
@Serializable
data class NewsfeedItemFriendFriends (
    @SerialName("count") val count: Int? = null,
    @SerialName("items") val items: List<BaseUserId>? = null,
)
