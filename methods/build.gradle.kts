import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.dokka)
    id("convention.publication")
}

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_11)
                }
            }
        }
    }

    jvm()

    js {
        // KT-47038
        browser()
        nodejs()
    }

    iosX64()
    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    linuxX64()
    mingwX64()

    sourceSets {
        commonMain.dependencies {
            api(project(":vkkt-utils"))
            api(project(":vkkt-objects"))
            api(project(":vkkt-responses"))
            api(libs.kotlinx.serialization.json)
        }
    }

    //https://kotlinlang.org/docs/native-objc-interop.html#export-of-kdoc-comments-to-generated-objective-c-headers
    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        compilations["main"].compilerOptions.options.freeCompilerArgs.add("-Xexport-kdoc")
    }

}

android {
    namespace = "ru.krindra.vkkt"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            externalDocumentationLink("https://kotlinlang.org/api/kotlinx.coroutines/")
            suppressGeneratedFiles.set(false)
        }
        val commonMain by getting {
            platform.set(org.jetbrains.dokka.Platform.common)
        }
    }
}

val javadocJar by tasks.registering(Jar::class) {
    archiveClassifier.set("javadoc")
    from(tasks.dokkaHtml)
}

tasks.withType<AbstractPublishToMaven>().configureEach {
    val signingTasks = tasks.withType<Sign>()
    mustRunAfter(signingTasks)
}

publishing {
    publications.forEach {
        if (it !is MavenPublication) {
            return@forEach
        }
        it.artifact(javadocJar)
    }
}

