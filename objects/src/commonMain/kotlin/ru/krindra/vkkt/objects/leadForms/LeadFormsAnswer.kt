package ru.krindra.vkkt.objects.leadForms

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
