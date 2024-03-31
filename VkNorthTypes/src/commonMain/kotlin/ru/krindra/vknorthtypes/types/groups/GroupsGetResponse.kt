package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupsGetResponse (
    val response: GroupsGetRawResponse
) {
    /**
     *
     * @param count Total communities number
     * @param items 
     */
    @Serializable
    data class GroupsGetRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<Int>,
    )
}

