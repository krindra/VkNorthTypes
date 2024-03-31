package ru.krindra.vknorthtypes.types.apps

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUser


@Serializable
data class AppsGetLeaderboardExtendedResponse (
    val response: AppsGetLeaderboardExtendedRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     * @param profiles 
     */
    @Serializable
    data class AppsGetLeaderboardExtendedRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<AppsLeaderboard>,
        @SerialName("profiles") val profiles: List<UsersUser>? = null,
    )
}

