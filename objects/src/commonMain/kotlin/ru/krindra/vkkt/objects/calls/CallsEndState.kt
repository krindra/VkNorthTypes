package ru.krindra.vkkt.objects.calls

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * State in which call ended up
 * 
 */
@Serializable
enum class CallsEndState(val value: String){
    @SerialName("canceled_by_initiator") CANCELED_BY_INITIATOR("canceled_by_initiator"),
    @SerialName("canceled_by_receiver") CANCELED_BY_RECEIVER("canceled_by_receiver"),
    @SerialName("reached") REACHED("reached"),
}
