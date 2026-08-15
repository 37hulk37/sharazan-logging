plugins {
    kotlin("jvm") version "2.3.0"
    `maven-publish`
}

group = "com.sharazan"
version = "1.0-SNAPSHOT"

val gitVersion: String = try {
    providers.exec {
        commandLine("git", "describe", "--tags", "--abbrev=0")
    }.standardOutput.asText.get().trim()
} catch (_: Exception) {
    "0.0.0-dev"
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    api("org.slf4j:slf4j-api:2.0.17")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-slf4j:1.10.2")

    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}

publishing {
    publications {
        create<MavenPublication>("publish") {
            from(components["java"])
            groupId = "com.github.37hulk37"
            artifactId = "sharazan-${project.name}"
            version = gitVersion
        }
    }

    repositories {
        mavenLocal()
    }
}

tasks.test {
    useJUnitPlatform()
}
