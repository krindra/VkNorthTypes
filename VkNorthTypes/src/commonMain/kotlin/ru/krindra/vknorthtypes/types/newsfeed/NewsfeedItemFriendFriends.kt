package ru.krindra.vknorthtypes.types.newsfeed

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseUserId

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
