package ru.krindra.vknorthtypes.types.wall

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull

import ru.krindra.vknorthtypes.types.users.UsersUserFull


@Serializable
data class WallGetByIdExtendedResponse (
    val response: WallGetByIdExtendedRawResponse
) {
    /**
     *
     * @param items 
     * @param profiles 
     * @param groups 
     */
    @Serializable
    data class WallGetByIdExtendedRawResponse (
        @SerialName("items") val items: List<WallWallItem>,
        @SerialName("profiles") val profiles: List<UsersUserFull>,
        @SerialName("groups") val groups: List<GroupsGroupFull>,
    )
}

