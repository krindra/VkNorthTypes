package ru.krindra.vknorthtypes.types.callback

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param ownerId 
 * @param pollId 
 * @param optionId 
 * @param userId 
 */
@Serializable
data class CallbackPollVoteNew (
    @SerialName("user_id") val userId: Long,
    @SerialName("owner_id") val ownerId: Long,
    @SerialName("option_id") val optionId: Long,
    @SerialName("poll_id") val pollId: Long,
)
