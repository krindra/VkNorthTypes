plugins {
    `kotlin-dsl`
    alias(libs.plugins.dokka)
}

dependencies {
    implementation(libs.nexus.publish)
}