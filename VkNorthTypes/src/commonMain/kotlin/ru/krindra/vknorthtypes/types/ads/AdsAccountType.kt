package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * Account type
 * 
 */
@Serializable
enum class AdsAccountType(val value: String){
    @SerialName("general") GENERAL("general"),
    @SerialName("agency") AGENCY("agency"),
}
