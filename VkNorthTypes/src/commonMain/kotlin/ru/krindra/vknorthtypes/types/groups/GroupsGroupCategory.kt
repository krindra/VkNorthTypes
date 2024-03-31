package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Category ID
 * @param name Category name
 * @param subcategories 
 */
@Serializable
data class GroupsGroupCategory (
    @SerialName("name") val name: String,
    @SerialName("subcategories") val subcategories: List<GroupsGroupSubcategory>? = null,
    @SerialName("id") val id: Long,
)
