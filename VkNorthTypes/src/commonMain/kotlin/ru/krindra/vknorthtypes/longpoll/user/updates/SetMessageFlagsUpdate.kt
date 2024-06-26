package ru.krindra.vknorthtypes.longpoll.user.updates

import kotlinx.serialization.json.*
import ru.krindra.vknorthtypes.longpoll.user.*

data class SetMessageFlagsUpdate(
    val messageId: Int,
    val mask: Int,
    val peerId: Int,
): UserLPUpdate() {
    companion object {
        val code = 2
        fun fromJsonArray(jsonArray: JsonArray): SetMessageFlagsUpdate {
            return SetMessageFlagsUpdate(
                messageId = jsonArray[0].jsonPrimitive.int,
                mask = jsonArray[1].jsonPrimitive.int,
                peerId = jsonArray[2].jsonPrimitive.int,
            )
        }
    }
}
