package ru.krindra.vkkt.objects.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Donut
 * 
 * @param isDonut Is donut
 */
@Serializable
data class AdsPostDonut (
    @SerialName("is_donut") val isDonut: Boolean? = null,
)
