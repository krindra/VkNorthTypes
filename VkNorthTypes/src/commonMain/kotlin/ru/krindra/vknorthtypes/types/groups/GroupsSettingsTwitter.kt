package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param status 
 * @param name 
 */
@Serializable
data class GroupsSettingsTwitter (
    @SerialName("status") val status: String,
    @SerialName("name") val name: String? = null,
)
