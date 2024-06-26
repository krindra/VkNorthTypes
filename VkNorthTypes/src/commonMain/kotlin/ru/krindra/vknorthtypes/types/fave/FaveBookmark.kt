package ru.krindra.vknorthtypes.types.fave

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.wall.WallWallpostFull
import ru.krindra.vknorthtypes.types.base.BaseLink
import ru.krindra.vknorthtypes.types.market.MarketMarketItem
import ru.krindra.vknorthtypes.types.video.VideoVideoFull

/**
 *
 * @param addedDate Timestamp, when this item was bookmarked
 * @param link 
 * @param post 
 * @param product 
 * @param seen Has user seen this item
 * @param tags 
 * @param type Item type
 * @param video 
 */
@Serializable
data class FaveBookmark (
    @SerialName("seen") val seen: Boolean,
    @SerialName("tags") val tags: List<FaveTag>,
    @SerialName("added_date") val addedDate: Int,
    @SerialName("link") val link: BaseLink? = null,
    @SerialName("type") val type: FaveBookmarkType,
    @SerialName("post") val post: WallWallpostFull? = null,
    @SerialName("video") val video: VideoVideoFull? = null,
    @SerialName("product") val product: MarketMarketItem? = null,
)
