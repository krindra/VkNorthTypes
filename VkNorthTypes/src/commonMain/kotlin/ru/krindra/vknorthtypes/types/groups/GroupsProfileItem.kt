package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id User id
 * @param photo50 Url for user photo
 * @param photo100 Url for user photo
 * @param firstName User first name
 */
@Serializable
data class GroupsProfileItem (
    @SerialName("photo_100") val photo100: String,
    @SerialName("first_name") val firstName: String,
    @SerialName("photo_50") val photo50: String,
    @SerialName("id") val id: Long,
)
