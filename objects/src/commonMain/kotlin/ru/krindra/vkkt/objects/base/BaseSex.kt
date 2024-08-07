package ru.krindra.vkkt.objects.base

import kotlinx.serialization.Serializable
import ru.krindra.vkkt.utils.EnumAsIntSerializer

private class BaseSexSerializer: EnumAsIntSerializer<BaseSex>(
    "BaseSex", { it.value }, { v -> BaseSex.values().first { it.value == v } }
)

@Serializable(with = BaseSexSerializer::class)
enum class BaseSex(val value: Int){
    UNKNOWN(0),
    FEMALE(1),
    MALE(2),
}
