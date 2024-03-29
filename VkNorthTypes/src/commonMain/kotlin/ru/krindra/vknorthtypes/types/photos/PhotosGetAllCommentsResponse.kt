package ru.krindra.vknorthtypes.types.photos

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.wall.WallWallComment


@Serializable
data class PhotosGetAllCommentsResponse (
    val response: PhotosGetAllCommentsRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class PhotosGetAllCommentsRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<WallWallComment>,
    )
}

