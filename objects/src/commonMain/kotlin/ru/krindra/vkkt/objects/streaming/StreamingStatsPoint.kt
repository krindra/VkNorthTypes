package ru.krindra.vkkt.objects.streaming

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param timestamp 
 * @param value 
 */
@Serializable
data class StreamingStatsPoint (
    @SerialName("value") val value: Int,
    @SerialName("timestamp") val timestamp: Int,
)
