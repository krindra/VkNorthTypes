package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param comment Comment text
 * @param rules 
 */
@Serializable
data class AdsRejectReason (
    @SerialName("rules") val rules: List<AdsRules>? = null,
    @SerialName("comment") val comment: String? = null,
)
