package ru.krindra.vknorthtypes.types.friends

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FriendsGetRequestsResponse (
    val response: FriendsGetRequestsRawResponse
) {
    /**
     *
     * @param count Total requests number
     * @param items 
     * @param countUnread Total unread requests number
     * @param lastViewed Friend requests last viewed timestamp
     */
    @Serializable
    data class FriendsGetRequestsRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<Int>,
        @SerialName("count_unread") val countUnread: Int? = null,
        @SerialName("last_viewed") val lastViewed: Int? = null,
    )
}

