package ru.krindra.vknorthtypes.types.orders

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OrdersGetUserSubscriptionsResponse (
    val response: OrdersGetUserSubscriptionsRawResponse
) {
    /**
     *
     * @param count Total number
     * @param items 
     */
    @Serializable
    data class OrdersGetUserSubscriptionsRawResponse (
        @SerialName("count") val count: Int,
        @SerialName("items") val items: List<OrdersSubscription>,
    )
}

