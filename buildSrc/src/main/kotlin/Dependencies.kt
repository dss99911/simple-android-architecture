object deps {
    object kotlin {
        val gradle = depKotlin("gradle-plugin", versions.kotlin.version)
        val serializationGradle = depKotlin("serialization", versions.kotlin.version)
        val stdlib = depKotlin("stdlib")
        val stdlibCommon = depKotlin("stdlib-common")
        val stdlibWithVersion = depKotlin("stdlib", versions.kotlin.version)
        val stdlibJdk8 = depKotlin("stdlib-jdk8", versions.kotlin.version)
        val stdlibJs = depKotlin("stdlib-js", versions.kotlin.version)
        val coroutineCoreCommon = depKotlinx("coroutines-core-common", versions.kotlin.coroutine)
        val coroutineCore = depKotlinx("coroutines-core", versions.kotlin.coroutine)
        val coroutineAndroid = depKotlinx("coroutines-android", versions.kotlin.coroutine)
        val coroutineCoreNative = depKotlinx("coroutines-core-native", versions.kotlin.coroutine)
        val coroutineCoreJs = depKotlinx("coroutines-core-js", versions.kotlin.coroutine)
        val coroutineTest = depKotlinx("coroutines-test", versions.kotlin.coroutine)
        val serializationRuntimeCommon = depKotlinx("serialization-runtime-common", versions.kotlin.serialization)
        val serializationRuntime = depKotlinx("serialization-runtime", versions.kotlin.serialization)
        val serializationRuntimeNative = depKotlinx("serialization-runtime-native", versions.kotlin.serialization)
        val serializationRuntimeJs = depKotlinx("serialization-runtime-js", versions.kotlin.serialization)
        val reflect = depKotlin("reflect", versions.kotlin.version)
        val testJunit = depKotlin("test-junit", versions.kotlin.version)
        val test = depKotlin("test", versions.kotlin.version)
    }

    object ktor {
        const val gson = "io.ktor:ktor-gson:${versions.kotlin.ktor}"
        const val serialization = "io.ktor:ktor-serialization:${versions.kotlin.ktor}"
        const val serverNetty = "io.ktor:ktor-server-netty:${versions.kotlin.ktor}"
        const val auth = "io.ktor:ktor-auth:${versions.kotlin.ktor}"
        const val serverSessions = "io.ktor:ktor-server-sessions:${versions.kotlin.ktor}"

        const val clientCore = "io.ktor:ktor-client-core:${versions.kotlin.ktor}"
        const val clientCoreJvm = "io.ktor:ktor-client-core-jvm:${versions.kotlin.ktor}"
        const val clientIos = "io.ktor:ktor-client-ios:${versions.kotlin.ktor}"
        const val clientJs = "io.ktor:ktor-client-js:${versions.kotlin.ktor}"
        const val clientAndroid = "io.ktor:ktor-client-android:${versions.kotlin.ktor}"
        const val clientGson = "io.ktor:ktor-client-gson:${versions.kotlin.ktor}"
        const val clientLogging = "io.ktor:ktor-client-logging:${versions.kotlin.ktor}"
        const val clientLoggingJvm = "io.ktor:ktor-client-logging-jvm:${versions.kotlin.ktor}"
        const val clientLoggingNative = "io.ktor:ktor-client-logging-native:${versions.kotlin.ktor}"
        const val clientLoggingJs = "io.ktor:ktor-client-logging-js:${versions.kotlin.ktor}"
        const val clientSerialization = "io.ktor:ktor-client-serialization:${versions.kotlin.ktor}"
        const val clientSerializationJvm = "io.ktor:ktor-client-serialization-jvm:${versions.kotlin.ktor}"
        const val clientSerializationNative = "io.ktor:ktor-client-serialization-native:${versions.kotlin.ktor}"
        const val clientSerializationJs = "io.ktor:ktor-client-serialization-js:${versions.kotlin.ktor}"
    }

    object android {
        const val buildToolGradle = "com.android.tools.build:gradle:${versions.android.buildTool}"
        const val supportCompat = "com.android.support:support-compat:28.0.0"
        const val appCompat = "androidx.appcompat:appcompat:${versions.android.xBase}"
        const val core = "androidx.core:core-ktx:1.3.0"
        const val vectordrawable = "androidx.vectordrawable:vectordrawable:${versions.android.xBase}"
        const val material = "com.google.android.material:material:${versions.android.material}"
        const val work = "androidx.work:work-runtime-ktx:2.3.1"

        const val anko = "org.jetbrains.anko:anko:0.10.8"
        const val timber = "com.jakewharton.timber:timber:4.7.1"

        val testCommon = listOf(
            "androidx.arch.core:core-testing:2.1.0",
            "androidx.test.ext:junit-ktx:1.1.1",
            "androidx.test:core-ktx:${versions.android.xTest}",
            "androidx.test:core:${versions.android.xTest}",
            "androidx.test:rules:${versions.android.xTest}",
            "androidx.test:runner:${versions.android.xTest}",
            "org.mockito:mockito-core:3.2.4",
            kotlin.coroutineTest,
            "com.google.truth:truth:1.0.1"
        )

        val compose = listOf(
            "androidx.ui:ui-layout:${versions.android.compose}",
            "androidx.ui:ui-tooling:${versions.android.compose}",
            "androidx.ui:ui-material:${versions.android.compose}",
            "androidx.ui:ui-material-icons-extended:${versions.android.compose}"
        )
    }

    object simpleArch {
        val common = depSimpleArchitecture(version = versions.simpleArch)

        val jvm = depSimpleArchitecture("jvm", versions.simpleArch)
        val android = depSimpleArchitecture("android", versions.simpleArch)

        val pluginShared = depSimpleArchitecture("gradle-plugin-api-shared", versions.simpleArch)
        val pluginApi = depSimpleArchitecture("gradle-plugin-api", versions.simpleArch)
        val pluginApiNative = depSimpleArchitecture("gradle-plugin-api-native", versions.simpleArch)
        val pluginGradle = depSimpleArchitecture("gradle-plugin", versions.simpleArch)
        val annotation = depSimpleArchitecture("annotation", versions.simpleArch)
        val annotationJvm = depSimpleArchitecture("annotation-jvm", versions.simpleArch)
    }

    object plugin {
        val gradleApi = depKotlin("gradle-plugin-api", versions.kotlin.version)
        val compilerEmbeddable = depKotlin("compiler-embeddable", versions.kotlin.version)
        val compiler = depKotlin("compiler", versions.kotlin.version)
        const val auto = "com.google.auto.service:auto-service:1.0-rc6"
        const val gradlePublish = "com.gradle.publish:plugin-publish-plugin:0.12.0"
    }

    object sqldelight {
        const val runtime = "com.squareup.sqldelight:runtime:${versions.sqldelight}"
        const val coroutine = "com.squareup.sqldelight:coroutines-extensions:${versions.sqldelight}"
        const val gradle = "com.squareup.sqldelight:gradle-plugin:${versions.sqldelight}"
        const val android = "com.squareup.sqldelight:android-driver:${versions.sqldelight}"
        const val native = "com.squareup.sqldelight:native-driver:${versions.sqldelight}"
        const val jvm = "com.squareup.sqldelight:sqlite-driver:${versions.sqldelight}"
    }

    const val shadowGradle = "com.github.jengelman.gradle.plugins:shadow:${versions.shadow}"
    const val gson = "com.google.code.gson:gson:2.8.6"
    const val logback = "ch.qos.logback:logback-classic:1.2.3"
    const val junit = "junit:junit:4.12"

}

private fun depKotlin(module: String, version: String? = null): String =
    "org.jetbrains.kotlin:kotlin-$module${version?.let { ":$version" } ?: ""}"


private fun depKotlinx(module: String, version: String? = null): String =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$version" } ?: ""}"

private fun depSimpleArchitecture(module: String? = null, version: String? = null): String =
    "kim.jeonghyeon:kotlin-simple-architecture${module?.let { "-$module" } ?: ""}${version?.let { ":$version" } ?: ""}"

fun String.getGroupId(): String = split(':')[0]
fun String.getArtifactId(): String = split(':')[1]
fun String.getVersion(): String = split(':')[2]