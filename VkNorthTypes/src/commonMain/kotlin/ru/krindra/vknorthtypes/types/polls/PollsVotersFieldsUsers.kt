package ru.krindra.vknorthtypes.types.polls

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.users.UsersUserFull

/**
 *
 * @param count Votes number
 * @param items 
 */
@Serializable
data class PollsVotersFieldsUsers (
    @SerialName("items") val items: List<UsersUserFull>? = null,
    @SerialName("count") val count: Int? = null,
)
