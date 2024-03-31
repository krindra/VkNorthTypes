package ru.krindra.vknorthtypes.types.likes

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LikesAddResponse (
    val response: LikesAddRawResponse
) {
    /**
     *
     * @param likes Total likes number
     */
    @Serializable
    data class LikesAddRawResponse (
        @SerialName("likes") val likes: Int,
    )
}

