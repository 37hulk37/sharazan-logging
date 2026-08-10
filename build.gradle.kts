plugins {
    kotlin("jvm") version "2.3.0"
    `maven-publish`
}

group = "com.sharazan"
version = "1.0-SNAPSHOT"

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
            groupId = project.group.toString()
            artifactId = project.name
            version = project.version.toString()
        }
    }

    repositories {
        mavenLocal()
    }
}

tasks.test {
    useJUnitPlatform()
}
