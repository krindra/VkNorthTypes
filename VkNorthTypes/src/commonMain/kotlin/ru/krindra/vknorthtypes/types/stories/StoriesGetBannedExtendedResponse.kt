package ru.krindra.vknorthtypes.types.stories

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.groups.GroupsGroupFull

import ru.krindra.vknorthtypes.types.users.UsersUserFull


@Serializable
data class StoriesGetBannedExtendedResponse (
    val response: StoriesGetBannedExtendedRawResponse
) {
    /**
     *
     * @param count Stories count
     * @param items 
     * @param profiles 
     * @param groups 
     */
    @Serializable
    data class StoriesGetBannedExtendedRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<Int>,
        @SerialName("profiles") val profiles: List<UsersUserFull>,
        @SerialName("groups") val groups: List<GroupsGroupFull>,
    )
}

