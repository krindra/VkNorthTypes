package ru.krindra.vknorthtypes.types.streaming

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param timestamp 
 * @param value 
 */
@Serializable
data class StreamingStatsPoint (
    @SerialName("timestamp") val timestamp: Int,
    @SerialName("value") val value: Int,
)
