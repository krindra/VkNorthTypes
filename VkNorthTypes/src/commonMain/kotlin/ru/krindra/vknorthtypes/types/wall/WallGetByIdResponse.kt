package ru.krindra.vknorthtypes.types.wall

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WallGetByIdResponse (
    val response: WallGetByIdRawResponse
) {
    /**
     *
     * @param items 
     */
    @Serializable
    data class WallGetByIdRawResponse (
        @SerialName("items") val items: List<WallWallItem>? = null,
    )
}

