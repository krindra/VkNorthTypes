package ru.krindra.vknorthtypes.types.leadForms

// **********
// THIS FILE IS AUTOGENERATED!!! DO NOT EDIT IT!!!
// **********
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 * @param key 
 * @param answer 
 */
@Serializable
data class LeadFormsAnswer (
    @SerialName("key") val key: String,
    @SerialName("answer") val answer: LeadFormsAnswerOneOf,
)
