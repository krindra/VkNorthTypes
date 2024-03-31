package ru.krindra.vknorthtypes.types.ads

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param id Ad ID
 * @param errorCode Error code
 * @param errorDesc Error description
 */
@Serializable
data class AdsUpdateAdsStatus (
    @SerialName("error_code") val errorCode: Int? = null,
    @SerialName("error_desc") val errorDesc: String? = null,
    @SerialName("id") val id: Long,
)
