package ru.krindra.vknorthtypes.types.account

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param title 
 * @param value 
 */
@Serializable
data class AccountUserSettingsInterest (
    @SerialName("title") val title: String,
    @SerialName("value") val value: String,
)
