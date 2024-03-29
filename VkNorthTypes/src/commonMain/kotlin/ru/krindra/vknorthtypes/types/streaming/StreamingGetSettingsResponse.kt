package ru.krindra.vknorthtypes.types.streaming

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreamingGetSettingsResponse (
    val response: StreamingGetSettingsRawResponse
) {
    /**
     *
     * @param monthlyLimit streaming monthly tier
     */
    @Serializable
    data class StreamingGetSettingsRawResponse (
        @SerialName("monthly_limit") val monthlyLimit: String? = null,
    )
}

