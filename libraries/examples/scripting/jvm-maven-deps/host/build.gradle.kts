import org.jetbrains.kotlin.gradle.dsl.Coroutinesapply {    plugin("kotlin")}dependencies {    compile(project(":examples:scripting-jvm-maven-deps:script"))    compile(project(":kotlin-scripting-jvm-host"))    compile(projectDist(":kotlin-stdlib"))    compile(projectDist(":kotlin-reflect"))    compileOnly(project(":compiler:util"))    runtime(projectDist(":kotlin-compiler"))    testCompile(commonDep("junit"))}sourceSets {    "main" { projectDefault() }    "test" { projectDefault() }}kotlin {    experimental.coroutines = Coroutines.ENABLE}