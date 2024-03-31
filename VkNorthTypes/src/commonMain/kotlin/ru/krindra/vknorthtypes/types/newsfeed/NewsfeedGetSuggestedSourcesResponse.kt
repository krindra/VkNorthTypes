package ru.krindra.vknorthtypes.types.newsfeed

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersSubscriptionsItem


@Serializable
data class NewsfeedGetSuggestedSourcesResponse (
    val response: NewsfeedGetSuggestedSourcesRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class NewsfeedGetSuggestedSourcesRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<UsersSubscriptionsItem>,
    )
}

