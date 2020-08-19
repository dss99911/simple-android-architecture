package kim.jeonghyeon.pergist

import com.squareup.sqldelight.runtime.coroutines.asFlow
import kim.jeonghyeon.db.SimpleDB
import kim.jeonghyeon.extension.fromJsonString
import kim.jeonghyeon.extension.toJsonString
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.serialization.ImplicitReflectionSerializer

expect class Preference() : AbstractPreference {
    override val db: SimpleDB
}

abstract class AbstractPreference {
    abstract val db: SimpleDB
    private val queries by lazy { db.dictionaryQueries }

    fun has(key: String): Boolean {
        return getString(key) != null
    }

    fun getString(key: String): String? {
        return queries.get(key).executeAsOneOrNull()?.value
    }

    fun getString(key: String, defValue: String): String {
        return getString(key) ?: defValue
    }

    @ImplicitReflectionSerializer
    inline fun <reified T : Any> get(key: String): T? {
        return getString(key)?.fromJsonString()
    }

    //todo issue : if Preference is created multiple times, and other preference change value. then this won't be invoked.
    // make this preference singleton or check sqldelight implementation
    fun getStringFlow(key: String): Flow<String?> {
        return queries.get(key).asFlow().map { it.executeAsOneOrNull()?.value }
    }

    fun setString(key: String, value: String?) {
        queries.set(key, value)
    }

    @ImplicitReflectionSerializer
    inline fun <reified T : Any> set(key: String, value: T?) {
        setString(key, value?.toJsonString())
    }

    //TODO HYUN [KSA-95] : add encyption logic
    fun getEncryptedString(key: String): String? {
        return queries.get(key).executeAsOneOrNull()?.value
    }

    //TODO HYUN [KSA-95] : add encyption logic
    fun setEncryptedString(key: String, value: String?) {
        queries.set(key, value)
    }
}