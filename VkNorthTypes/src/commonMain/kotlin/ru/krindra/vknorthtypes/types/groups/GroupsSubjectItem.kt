package ru.krindra.vknorthtypes.types.groups

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Subject ID
 * @param name Subject title
 */
@Serializable
data class GroupsSubjectItem (
    @SerialName("name") val name: String,
    @SerialName("id") val id: Long,
)
