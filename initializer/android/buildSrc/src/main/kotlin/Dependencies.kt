object versions {
    const val simpleArch = "1.1.0"

    object kotlin {
        const val version = "1.4.10"
    }

    object android {
        const val buildTool = "4.2.0-alpha13"
    }

    const val sqldelight = "1.4.2"
}

object deps {
    object kotlin {
        val gradle = depKotlin("gradle-plugin", versions.kotlin.version)
        val serializationGradle = depKotlin("serialization", versions.kotlin.version)
    }

    object android {
        const val buildToolGradle = "com.android.tools.build:gradle:${versions.android.buildTool}"
    }

    object simpleArch {
        val common = depSimpleArchitecture(version = versions.simpleArch)
        val pluginGradle = depSimpleArchitecture("gradle-plugin", versions.simpleArch)
    }

    object sqldelight {
        const val gradle = "com.squareup.sqldelight:gradle-plugin:${versions.sqldelight}"
    }

}

private fun depKotlin(module: String, version: String? = null): String =
    "org.jetbrains.kotlin:kotlin-$module${version?.let { ":$version" } ?: ""}"


private fun depKotlinx(module: String, version: String? = null): String =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

private fun depSimpleArchitecture(module: String? = null, version: String? = null): String =
    "kim.jeonghyeon:kotlin-simple-architecture${module?.let { "-$module" } ?: ""}${version?.let { ":$version" } ?: ""}"