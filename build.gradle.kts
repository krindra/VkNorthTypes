plugins {
    id("root.publication")
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.dokka).apply(false)
    alias(libs.plugins.nmcp)
}

buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }
}

nmcp {
    publishAllProjectsProbablyBreakingProjectIsolation {
        username.set(findProperty("sonatypeUsername") as String)
        password.set(findProperty("sonatypePassword") as String)
    }
}
