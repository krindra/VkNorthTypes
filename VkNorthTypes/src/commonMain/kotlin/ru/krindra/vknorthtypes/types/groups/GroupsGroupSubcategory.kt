package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseObjectWithName

/**
 *
 * @param id Object ID
 * @param name Object name
 * @param genders 
 */
@Serializable
data class GroupsGroupSubcategory (
    @SerialName("genders") val genders: List<BaseObjectWithName>? = null,
    @SerialName("name") val name: String,
    @SerialName("id") val id: Long,
)
