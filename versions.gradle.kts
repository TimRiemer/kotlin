
extra["versions.intellijSdk"] = "173.4674.33"
extra["versions.androidBuildTools"] = "r23.0.1"
extra["versions.idea.NodeJS"] = "172.3757.32"
//extra["versions.androidStudioRelease"] = "3.1.0.5"
//extra["versions.androidStudioBuild"] = "173.4506631"


val platformBuildVersion = extra["versions.intellijSdk"] as String
val platformMajorVersion = platformBuildVersion.substring(0, 3)
val platformYearVersion = "20${platformMajorVersion.substring(0, 2)}.${platformMajorVersion.substring(2, 3)}"

extra["versions.platformMajorVersion"] = platformMajorVersion
extra["versions.platformYearVersion"] = platformYearVersion

val androidStudioMajorVersion = if (extra.has("versions.androidStudioRelease"))
    (extra["versions.androidStudioRelease"] as? String)?.split(".")?.take(2)?.joinToString()
else
    null

if (androidStudioMajorVersion != null) {
    extra["versions.androidStudioMajorVersion"] = androidStudioMajorVersion
}

val platform = androidStudioMajorVersion?.replace(".", "")?.let { "AS$it" }
        ?: platformMajorVersion

val gradleJars = listOf(
    "gradle-api",
    "gradle-tooling-api",
    "gradle-base-services",
    "gradle-wrapper",
    "gradle-core",
    "gradle-base-services-groovy"
)

when (platform) {
    "181" -> {
        extra["versions.jar.guava"] = "21.0"
        extra["versions.jar.groovy-all"] = "2.4.12"
        extra["versions.jar.lombok-ast"] = "0.2.3"
        extra["versions.jar.swingx-core"] = "1.6.2-2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.5"
        extra["versions.jar.gson"] = "2.8.2"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "4.4"
        }
    }
    "173" -> {
        extra["versions.jar.guava"] = "21.0"
        extra["versions.jar.groovy-all"] = "2.4.12"
        extra["versions.jar.lombok-ast"] = "0.2.3"
        extra["versions.jar.swingx-core"] = "1.6.2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.5"
        extra["versions.jar.gson"] = "2.8.2"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "4.0"
        }
        extra["ignore.jar.lombok-ast-0.2.3"] = true
    }
    "172" -> {
        extra["versions.jar.guava"] = "21.0"
        extra["versions.jar.groovy-all"] = "2.4.6"
        extra["versions.jar.lombok-ast"] = "0.2.3"
        extra["versions.jar.swingx-core"] = "1.6.2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.2"
        extra["versions.jar.gson"] = "2.5"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "3.5"
        }
    }
    "171" -> {
        extra["versions.jar.guava"] = "19.0"
        extra["versions.jar.groovy-all"] = "2.4.6"
        extra["versions.jar.lombok-ast"] = "0.2.3"
        extra["versions.jar.swingx-core"] = "1.6.2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.2"
        extra["versions.jar.gson"] = "2.5"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "3.3"
        }
    }
    "AS30" -> {
        extra["versions.jar.guava"] = "19.0"
        extra["versions.jar.groovy-all"] = "2.4.6"
        extra["versions.jar.lombok-ast"] = "0.2.3"
        extra["versions.jar.swingx-core"] = "1.6.2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.2"
        extra["versions.jar.gson"] = "2.5"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "3.5"
        }

        extra["ignore.jar.common"] = true
    }
    "AS31" -> {
        extra["versions.jar.guava"] = "21.0"
        extra["versions.jar.groovy-all"] = "2.4.12"
        extra["versions.jar.swingx-core"] = "1.6.2"
        extra["versions.jar.kxml2"] = "2.3.0"
        extra["versions.jar.streamex"] = "0.6.5"
        extra["versions.jar.gson"] = "2.8.2"
        for (jar in gradleJars) {
            extra["versions.jar.$jar"] = "4.0"
        }

        extra["ignore.jar.common"] = true
        extra["ignore.jar.lombok-ast"] = true
    }
}

if (!extra.has("versions.androidStudioRelease")) {
    extra["ignore.jar.android-base-common"] = true
}
