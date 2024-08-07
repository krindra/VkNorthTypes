package ru.krindra.vkkt.objects.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Country ID
 * @param title Country title
 */
@Serializable
data class BaseCountry (
    @SerialName("id") val id: Int,
    @SerialName("title") val title: String,
)
