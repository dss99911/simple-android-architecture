package kim.jeonghyeon.net

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import kim.jeonghyeon.auth.ServiceAuthType
import kim.jeonghyeon.auth.SignInAuthType
import kotlinsimplearchitecture.generated.net.createSimple
import samplebase.generated.SimpleConfig
import samplebase.generated.net.create

val AUTH_TYPE_SIGN_IN = SignInAuthType.DIGEST
val AUTH_TYPE_SERVICE = ServiceAuthType.JWT

val client: HttpClient by lazy {
    httpClientSimple {
        defaultRequest {
            //this is called whenever api is called
            header(HEADER_KEY, headerKeyValue)
        }
    }
}

inline fun <reified API> api(baseUrl: String = SimpleConfig.serverUrl): API = client.create(baseUrl)
inline fun <reified API> apiSimple(baseUrl: String = SimpleConfig.serverUrl): API = client.createSimple(baseUrl)

//just for sample showing how to set common header
const val HEADER_KEY = "KEY"
var headerKeyValue = "Header test"