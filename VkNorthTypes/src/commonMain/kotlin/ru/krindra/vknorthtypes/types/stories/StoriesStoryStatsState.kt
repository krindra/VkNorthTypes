package ru.krindra.vknorthtypes.types.stories

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Statistic state
 * 
 */
@Serializable
enum class StoriesStoryStatsState(val value: String){
    @SerialName("on") ON("on"),
    @SerialName("off") OFF("off"),
    @SerialName("hidden") HIDDEN("hidden"),
}
