package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GroupsGetTokenPermissionsResponse (
    val response: GroupsGetTokenPermissionsRawResponse
) {
    /**
     *
     * @param mask 
     * @param permissions 
     */
    @Serializable
    data class GroupsGetTokenPermissionsRawResponse (
        @SerialName("mask") val mask: Int,
        @SerialName("permissions") val permissions: List<GroupsTokenPermissionSetting>,
    )
}

