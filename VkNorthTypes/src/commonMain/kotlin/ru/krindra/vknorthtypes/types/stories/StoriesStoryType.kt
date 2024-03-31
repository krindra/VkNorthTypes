package ru.krindra.vknorthtypes.types.stories

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Story type.
 * 
 */
@Serializable
enum class StoriesStoryType(val value: String){
    @SerialName("photo") PHOTO("photo"),
    @SerialName("video") VIDEO("video"),
    @SerialName("live_active") LIVE_ACTIVE("live_active"),
    @SerialName("live_finished") LIVE_FINISHED("live_finished"),
}
