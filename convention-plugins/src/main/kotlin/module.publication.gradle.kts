import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // Provide artifacts information required by Maven Central
        pom {
            name.set("VkNorthTypes")
            description.set("Types for VK API")
            url.set("https://github.com/krindra/VkNorthTypes")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    name.set("Krindra")
                }
            }
            scm {
                url.set("https://github.com/krindra/VkNorthTypes")
            }
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications)
}
