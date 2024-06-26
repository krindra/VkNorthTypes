package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Community type
 * 
 */
@Serializable
enum class GroupsGroupType(val value: String){
    @SerialName("group") GROUP("group"),
    @SerialName("page") PAGE("page"),
    @SerialName("event") EVENT("event"),
}
