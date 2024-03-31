package ru.krindra.vknorthtypes.types.photos

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosGetUserPhotosResponse (
    val response: PhotosGetUserPhotosRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class PhotosGetUserPhotosRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<PhotosPhoto>,
    )
}

