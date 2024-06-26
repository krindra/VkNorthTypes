package ru.krindra.vknorthtypes.types.gifts

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param date Date when gist has been sent in Unixtime
 * @param fromId Gift sender ID
 * @param gift 
 * @param giftHash Hash
 * @param id Gift ID
 * @param message Comment text
 * @param privacy 
 */
@Serializable
data class GiftsGift (
    @SerialName("id") val id: Long? = null,
    @SerialName("date") val date: Int? = null,
    @SerialName("from_id") val fromId: Long? = null,
    @SerialName("gift") val gift: GiftsLayout? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("gift_hash") val giftHash: String? = null,
    @SerialName("privacy") val privacy: GiftsGiftPrivacy? = null,
)
