package ru.krindra.vknorthtypes.types.groups

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseBoolInt

/**
 * @param enabled Information whether catalog is enabled for current user
 * @param categories 
 */
@Serializable
data class GroupsGetCatalogInfoResponse (
    @SerialName("enabled") val enabled: BaseBoolInt,
    @SerialName("categories") val categories: List<GroupsGroupCategory>? = null,
)

