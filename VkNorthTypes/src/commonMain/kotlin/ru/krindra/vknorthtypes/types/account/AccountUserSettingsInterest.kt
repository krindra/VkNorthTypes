package ru.krindra.vknorthtypes.types.account

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
