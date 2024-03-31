package ru.krindra.vknorthtypes.types.calls

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CallsStartResponse (
    val response: CallsStartRawResponse
) {
    /**
     *
     * @param callId Call id
     * @param joinLink Join link
     * @param broadcastVideoId video id for link
     * @param broadcastOvId video id for streaming
     */
    @Serializable
    data class CallsStartRawResponse (
        @SerialName("call_id") val callId: String? = null,
        @SerialName("join_link") val joinLink: String,
        @SerialName("broadcast_video_id") val broadcastVideoId: String? = null,
        @SerialName("broadcast_ov_id") val broadcastOvId: String? = null,
    )
}

