package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Follow event stats
 * 
 * @param eventType Event type
 * @param rhash Event hash
 */
@Serializable
data class AdsStoryItemStatsFollow (
    @SerialName("rhash") val rhash: String? = null,
    @SerialName("event_type") val eventType: String? = null,
)
