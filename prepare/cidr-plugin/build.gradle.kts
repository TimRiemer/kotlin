import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import groovy.lang.Closure
import java.io.FilterReader

description = "Kotlin AppCode & CLion plugin"

apply {
    plugin("kotlin")
}

val kotlinPlugin by configurations.creating
val pluginXmlPath = "META-INF/plugin.xml"

dependencies {
    kotlinPlugin(project(":prepare:idea-plugin", configuration = "runtimeJar"))
}

val pluginXml by tasks.creating {
    val placeholderRegex = """\<\!\-\- CLION\-PLUGIN\-PLACEHOLDER\-START \-\-\>(.*)\<\!\-\- CLION\-PLUGIN\-PLACEHOLDER\-END \-\-\>"""

    inputs.files(kotlinPlugin)
    outputs.files(File(buildDir, name, pluginXmlPath))

    doFirst {
        zipTree(inputs.files.singleFile)
            .matching { include(pluginXmlPath) }
            .singleFile
            .readText()
            .replace(Regex(placeholderRegex, RegexOption.DOT_MATCHES_ALL), "")
            .also { pluginXmlText ->
                outputs.files.singleFile.writeText(pluginXmlText)
            }
    }
}

val jar = runtimeJar {
    archiveName = "kotlin-plugin.jar"
    dependsOn(kotlinPlugin)
    from {
        zipTree(kotlinPlugin.singleFile).matching {
            exclude(pluginXmlPath)
        }
    }
    from(pluginXml) { into("META-INF") }
}
