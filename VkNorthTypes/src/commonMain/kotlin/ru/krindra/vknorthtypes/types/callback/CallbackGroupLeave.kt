package ru.krindra.vknorthtypes.types.callback

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import ru.krindra.vknorthtypes.types.base.BaseBoolInt

/**
 *
 * @param userId 
 * @param self 
 */
@Serializable
data class CallbackGroupLeave (
    @SerialName("user_id") val userId: Long? = null,
    @SerialName("self") val self: BaseBoolInt? = null,
)
