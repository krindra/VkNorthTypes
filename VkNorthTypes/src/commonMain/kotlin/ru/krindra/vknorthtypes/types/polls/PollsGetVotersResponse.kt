package ru.krindra.vknorthtypes.types.polls

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.Serializable

typealias PollsGetVotersRawResponse = List<PollsVoters>
@Serializable
data class PollsGetVotersResponse (
    val response: PollsGetVotersRawResponse
)

