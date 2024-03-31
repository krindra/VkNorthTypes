package ru.krindra.vknorthtypes.types.market

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseCity
import ru.krindra.vknorthtypes.types.base.BaseCountry

/**
 *
 * @param city 
 * @param country 
 */
@Serializable
data class MarketGlobalSearchFilters (
    @SerialName("country") val country: BaseCountry? = null,
    @SerialName("city") val city: BaseCity? = null,
)
