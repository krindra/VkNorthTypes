package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupsGetByIdObjectResponse (
    val response: GroupsGetByIdObjectRawResponse
) {
    /**
     *
     * @param groups 
     * @param profiles 
     */
    @Serializable
    data class GroupsGetByIdObjectRawResponse (
        @SerialName("groups") val groups: List<GroupsGroupFull>? = null,
        @SerialName("profiles") val profiles: List<GroupsProfileItem>? = null,
    )
}

