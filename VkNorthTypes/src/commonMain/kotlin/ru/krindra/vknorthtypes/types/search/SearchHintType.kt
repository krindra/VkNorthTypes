package ru.krindra.vknorthtypes.types.search

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Object type
 * 
 */
@Serializable
enum class SearchHintType(val value: String){
    @SerialName("group") GROUP("group"),
    @SerialName("profile") PROFILE("profile"),
    @SerialName("vk_app") VK_APP("vk_app"),
    @SerialName("app") APP("app"),
    @SerialName("html5_game") HTML5_GAME("html5_game"),
    @SerialName("link") LINK("link"),
}
