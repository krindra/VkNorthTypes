package ru.krindra.vknorthtypes.types.database

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseCountry


typealias DatabaseGetCountriesByIdRawResponse = List<BaseCountry>
@Serializable
data class DatabaseGetCountriesByIdResponse (
    val response: DatabaseGetCountriesByIdRawResponse
)

