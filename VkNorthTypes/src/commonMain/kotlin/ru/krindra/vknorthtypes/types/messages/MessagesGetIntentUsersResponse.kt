package ru.krindra.vknorthtypes.types.messages

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUserFull


@Serializable
data class MessagesGetIntentUsersResponse (
    val response: MessagesGetIntentUsersRawResponse
) {
    /**
     *
     * @param count 
     * @param items 
     * @param profiles 
     */
    @Serializable
    data class MessagesGetIntentUsersRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<Int>,
        @SerialName("profiles") val profiles: List<UsersUserFull>? = null,
    )
}

