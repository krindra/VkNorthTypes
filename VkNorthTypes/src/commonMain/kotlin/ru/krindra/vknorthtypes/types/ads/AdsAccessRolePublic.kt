package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Current user's role
 * 
 */
@Serializable
enum class AdsAccessRolePublic(val value: String){
    @SerialName("manager") MANAGER("manager"),
    @SerialName("reports") REPORTS("reports"),
}
