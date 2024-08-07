package ru.krindra.vkkt.objects.users

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param city City ID
 * @param class_ School class letter
 * @param classId School class id
 * @param country Country ID
 * @param id School ID
 * @param name School name
 * @param type School type ID
 * @param typeStr School type name
 * @param yearFrom Year the user started to study
 * @param yearGraduated Graduation year
 * @param yearTo Year the user finished to study
 * @param speciality 
 */
@Serializable
data class UsersSchool (
    @SerialName("id") val id: String? = null,
    @SerialName("city") val city: Int? = null,
    @SerialName("type") val type: Int? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("year_to") val yearTo: Int? = null,
    @SerialName("country") val country: Int? = null,
    @SerialName("class_") val class_: String? = null,
    @SerialName("class_id") val classId: Int? = null,
    @SerialName("year_from") val yearFrom: Int? = null,
    @SerialName("type_str") val typeStr: String? = null,
    @SerialName("speciality") val speciality: String? = null,
    @SerialName("year_graduated") val yearGraduated: Int? = null,
)
