package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseLink

/**
 *
 * @param id 
 * @param groupId 
 * @param userId 
 * @param displayOrderId 
 * @param date 
 * @param status 
 * @param itemsCount 
 * @param trackNumber 
 * @param trackLink 
 * @param comment 
 * @param address 
 * @param merchantComment 
 * @param weight 
 * @param totalPrice 
 * @param discount 
 * @param previewOrderItems Several order items for preview
 * @param cancelInfo Information for cancel and revert order
 * @param commentForUser Seller comment for user
 * @param isViewedByAdmin 
 * @param dateViewed 
 * @param canAddReview Extended field. Can current viewer add review for at least one item in this order
 */
@Serializable
data class MarketOrder (
    @SerialName("cancel_info") val cancelInfo: BaseLink? = null,
    @SerialName("display_order_id") val displayOrderId: String? = null,
    @SerialName("track_link") val trackLink: String? = null,
    @SerialName("is_viewed_by_admin") val isViewedByAdmin: Boolean? = null,
    @SerialName("group_id") val groupId: Long,
    @SerialName("can_add_review") val canAddReview: Boolean? = null,
    @SerialName("address") val address: String? = null,
    @SerialName("preview_order_items") val previewOrderItems: List<MarketOrderItem>? = null,
    @SerialName("items_count") val itemsCount: Int,
    @SerialName("date") val date: Int,
    @SerialName("track_number") val trackNumber: String? = null,
    @SerialName("user_id") val userId: Long,
    @SerialName("discount") val discount: MarketPrice? = null,
    @SerialName("total_price") val totalPrice: MarketPrice,
    @SerialName("merchant_comment") val merchantComment: String? = null,
    @SerialName("status") val status: Int,
    @SerialName("comment") val comment: String? = null,
    @SerialName("id") val id: Long,
    @SerialName("comment_for_user") val commentForUser: String? = null,
    @SerialName("date_viewed") val dateViewed: Int? = null,
    @SerialName("weight") val weight: Int? = null,
)
