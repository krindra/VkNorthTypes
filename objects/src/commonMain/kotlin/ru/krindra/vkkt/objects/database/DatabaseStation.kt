package ru.krindra.vkkt.objects.database

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param cityId City ID
 * @param color Hex color code without #
 * @param id Station ID
 * @param name Station name
 */
@Serializable
data class DatabaseStation (
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("city_id") val cityId: Int? = null,
    @SerialName("color") val color: String? = null,
)
