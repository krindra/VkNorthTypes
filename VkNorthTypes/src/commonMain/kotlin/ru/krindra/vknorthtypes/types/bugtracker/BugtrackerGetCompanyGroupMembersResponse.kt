package ru.krindra.vknorthtypes.types.bugtracker

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUserFull


@Serializable
data class BugtrackerGetCompanyGroupMembersResponse (
    val response: BugtrackerGetCompanyGroupMembersRawResponse
) {
    /**
     *
     * @param userIds 
     * @param profiles 
     */
    @Serializable
    data class BugtrackerGetCompanyGroupMembersRawResponse (
        @SerialName("user_ids") val userIds: List<Int>,
        @SerialName("profiles") val profiles: List<UsersUserFull>? = null,
    )
}

