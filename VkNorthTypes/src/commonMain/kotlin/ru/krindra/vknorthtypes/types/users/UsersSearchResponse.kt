package ru.krindra.vknorthtypes.types.users

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UsersSearchResponse (
    val response: UsersSearchRawResponse
) {
    /**
     *
     * @param count Total number of available results
     * @param items 
     */
    @Serializable
    data class UsersSearchRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<UsersUserFull>,
    )
}

