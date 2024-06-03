package ru.krindra.vknorthtypes.types.newsfeed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.wall.WallWallpostFull

/**
 * @param items 
 * @param suggestedQueries 
 * @param nextFrom 
 * @param count Filtered number
 * @param totalCount Total number
 */
@Serializable
data class NewsfeedSearchStrictResponse (
    @SerialName("count") val count: Int,
    @SerialName("next_from") val nextFrom: String? = null,
    @SerialName("items") val items: List<WallWallpostFull>,
    @SerialName("total_count") val totalCount: Int? = null,
    @SerialName("suggested_queries") val suggestedQueries: List<String>? = null,
)

