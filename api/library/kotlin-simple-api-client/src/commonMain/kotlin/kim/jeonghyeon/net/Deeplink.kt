package kim.jeonghyeon.net

import kim.jeonghyeon.type.ResourceError
import kotlinx.serialization.Serializable


fun errorDeeplink(info: DeeplinkInfo, cause: Throwable? = null): Nothing {
    throw DeeplinkError(info, cause)
}

/**
 * throw this error, then client will go to the link.
 */
class DeeplinkError(val deeplinkInfo: DeeplinkInfo, cause: Throwable? = null) :
    ResourceError(deeplinkInfo.message, cause)

@Serializable
data class DeeplinkInfo(
    val url: String,
    val message: String? = null,
    val redirectionInfo: RedirectionInfo = RedirectionInfo(RedirectionType.none)
)

/**
 * after navigate to the deeplink, when the screen closed with ok result, this redirection is performed
 * @param url if [RedirectionType.redirectionUrl], then this is required.
 * //todo need to handle cancel result as well?
 */
@Serializable
data class RedirectionInfo(val type: RedirectionType, val url: String? = null)

enum class RedirectionType {
    retry,//retry of the error
    redirectionUrl,
    //close,//todo close the screen required?
    none,
}
