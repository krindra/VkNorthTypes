import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.serialization)
    alias(libs.plugins.dokka)
    id("module.publication")
    id("maven-publish")
}

group = "ru.krindra"
version = "0.2.1"

kotlin {
    withSourcesJar(true)
    kotlin.applyDefaultHierarchyTemplate()
    jvm()
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    linuxX64()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(libs.kotlinx.serialization.json)
            }
        }
    }
}

android {
    namespace = "ru.krindra"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
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

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing {
    publications.forEach {
        if (it !is MavenPublication) {
            return@forEach
        }
        it.artifact(javadocJar)
    }
}
