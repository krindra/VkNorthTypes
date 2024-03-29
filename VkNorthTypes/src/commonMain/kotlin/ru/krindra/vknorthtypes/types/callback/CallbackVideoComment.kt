package ru.krindra.vknorthtypes.types.callback

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id 
 * @param fromId 
 * @param date 
 * @param text 
 * @param videoOwnerId 
 */
@Serializable
data class CallbackVideoComment (
    @SerialName("video_owner_id") val videoOwnerId: Long,
    @SerialName("text") val text: String,
    @SerialName("id") val id: Long,
    @SerialName("date") val date: Int,
    @SerialName("from_id") val fromId: Long,
)
