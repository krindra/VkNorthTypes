package ru.krindra.vkkt.objects.market

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vkkt.objects.photos.PhotosPhoto

/**
 *
 * @param ownerId 
 * @param itemId 
 * @param price 
 * @param quantity 
 * @param item 
 * @param title 
 * @param photo 
 * @param variants 
 * @param canAddReview Extended field. Can current viewer add review for this ordered item
 */
@Serializable
data class MarketOrderItem (
    @SerialName("item_id") val itemId: Int,
    @SerialName("owner_id") val ownerId: Int,
    @SerialName("quantity") val quantity: Int,
    @SerialName("price") val price: MarketPrice,
    @SerialName("item") val item: MarketMarketItem,
    @SerialName("title") val title: String? = null,
    @SerialName("photo") val photo: PhotosPhoto? = null,
    @SerialName("variants") val variants: List<String>? = null,
    @SerialName("can_add_review") val canAddReview: Boolean? = null,
)
