package ru.krindra.vknorthtypes.types.ads

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Category ID
 * @param name Category name
 * @param subcategories 
 */
@Serializable
data class AdsCategory (
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("subcategories") val subcategories: List<AdsCategory>? = null,
)
