package kim.jeonghyeon.simplearchitecture.plugin


import com.android.build.gradle.BaseExtension
import com.android.build.gradle.api.AndroidSourceSet
import org.gradle.api.Project
import org.gradle.api.file.SourceDirectorySet
import org.gradle.api.internal.HasConvention
import org.gradle.api.tasks.SourceSet
import org.gradle.api.tasks.SourceSetContainer
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KOTLIN_DSL_NAME
import org.jetbrains.kotlin.gradle.plugin.KOTLIN_JS_DSL_NAME
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet


fun Project.getSourceSetOptions(): List<SourceDirectorySetAndName> {

    // Multiplatform project.
    project.extensions.findByType(KotlinMultiplatformExtension::class.java)?.let {
        return it.sourceSets
            .filter {
                !it.name.contains(
                    "test",
                    true
                )
            }//ex) androidTest, androidTestDebug. androidTestRelease
            .map { SourceDirectorySetAndName(it.name, it.kotlin) }
    }

    // Android project.
    project.extensions.findByType(BaseExtension::class.java)?.let {
        return it.sourceSets
            .filter {
                !it.name.contains(
                    "test",
                    true
                )
            }//ex) androidTest, androidTestDebug. androidTestRelease
            .map { SourceDirectorySetAndName(it.name, it.kotlin!!) }
    }

    // Kotlin project.
    val sourceSets = project.property("sourceSets") as SourceSetContainer

    return listOf(SourceDirectorySetAndName("main", sourceSets.getByName("main").kotlin!!))
}

/**
 * 1. for native, [ApiGradleSubplugin.apply] is called before 'ios', 'mobile' sourceSet is created.
 * 2. so, It's difficult to figure out which sourceSet a class belongs to on native
 */
fun Project.getNativeSourceSetOptions(): List<SourceDirectorySetAndName> {
    return extensions.findByType(KotlinMultiplatformExtension::class.java)?.let { ext ->
        ext.targets
            .filter { it.platformType == KotlinPlatformType.native }
            .flatMap { it.compilations }
            .map { SourceDirectorySetAndName(NATIVE_TARGET_NAME, it.defaultSourceSet.kotlin) }
    } ?: emptyList()
}


fun SourceDirectorySetAndName.addGeneratedSourceDirectory(project: Project) {
    sourceDirectorySet.srcDir(generatedFilePath(project.buildDir.toString(), name))
}

internal val AndroidSourceSet.kotlin: SourceDirectorySet?
    get() = kotlinSourceSet

internal val SourceSet.kotlin: SourceDirectorySet?
    get() = kotlinSourceSet

private val Any.kotlinSourceSet: SourceDirectorySet?
    get() = (getKotlinSourceSet(KOTLIN_DSL_NAME) ?: getKotlinSourceSet(KOTLIN_JS_DSL_NAME))
        ?.kotlin

/**
 * `kotlinPlugin.javaClass.interfaces` has only 'org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet'
 * `convention.plugins` has only 'kotlin'
 */
private fun Any.getKotlinSourceSet(name: String): KotlinSourceSet? =
    (this as HasConvention).convention.plugins[name] as? KotlinSourceSet?


data class SourceDirectorySetAndName(val name: String, val sourceDirectorySet: SourceDirectorySet)

fun SourceDirectorySetAndName.toOption(): SourceSetOption =
    SourceSetOption(name, sourceDirectorySet.sourceDirectories.map { it.absolutePath }.toSet())
