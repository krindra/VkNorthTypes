package ru.krindra.vknorthtypes.types.newsfeed

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.wall.WallWallpostFull


@Serializable
data class NewsfeedSearchStrictResponse (
    val response: NewsfeedSearchStrictRawResponse
) {
    /**
     *
     * @param items 
     * @param suggestedQueries 
     * @param nextFrom 
     * @param count Filtered number
     * @param totalCount Total number
     */
    @Serializable
    data class NewsfeedSearchStrictRawResponse (
        @SerialName("items") val items: List<WallWallpostFull>,
        @SerialName("suggested_queries") val suggestedQueries: List<String>? = null,
        @SerialName("next_from") val nextFrom: String? = null,
        @SerialName("count") val count: Int,
        @SerialName("total_count") val totalCount: Int? = null,
    )
}

