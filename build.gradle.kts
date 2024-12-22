plugins {
    id("fabric-loom") version "1.8-SNAPSHOT"

    java
    //Optional
    kotlin("jvm") version "2.0.21"
}

group = "net.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val minecraft_version: String by project
    val yarn_mappings: String by project
    val kotlin_version: String by project
    val fabric_loader_version: String by project

    minecraft("com.mojang:minecraft:$minecraft_version")
    mappings("net.fabricmc:yarn:$yarn_mappings:v2")
    modImplementation("net.fabricmc:fabric-loader:$fabric_loader_version")

    //Optional
    modImplementation("net.fabricmc:fabric-language-kotlin:$kotlin_version")

    testImplementation(kotlin("test"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

tasks.processResources {
    filesMatching("**/fabric.mod.json") {
        expand("version" to project.version)
    }
}

//Optional
kotlin {
    jvmToolchain(17)
}