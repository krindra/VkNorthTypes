package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.Serializable
import ru.krindra.vkkt.utils.EnumAsIntSerializer

/**
 *
 * Review status
 * 
 */
private class AdsAdApprovedSerializer: EnumAsIntSerializer<AdsAdApproved>(
    "AdsAdApproved", { it.value }, { v -> AdsAdApproved.values().first { it.value == v } }
)

@Serializable(with = AdsAdApprovedSerializer::class)
enum class AdsAdApproved(val value: Int){
    NOT_MODERATED(0),
    PENDING_MODERATION(1),
    APPROVED(2),
    REJECTED(3),
}
