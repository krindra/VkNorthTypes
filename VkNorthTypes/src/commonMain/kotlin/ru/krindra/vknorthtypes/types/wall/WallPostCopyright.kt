package ru.krindra.vknorthtypes.types.wall

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id 
 * @param link 
 * @param name 
 * @param type 
 */
@Serializable
data class WallPostCopyright (
    @SerialName("link") val link: String,
    @SerialName("name") val name: String,
    @SerialName("type") val type: String,
    @SerialName("id") val id: Long? = null,
)
