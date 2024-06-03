package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param name 
 * @param setting 
 */
@Serializable
data class GroupsTokenPermissionSetting (
    @SerialName("name") val name: String,
    @SerialName("setting") val setting: Int,
)
