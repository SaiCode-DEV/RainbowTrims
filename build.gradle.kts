import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version("2.0.0")
    id("fabric-loom") version("1.6-SNAPSHOT")
}

group = "net.nutils"
version = "1.3-1"

repositories {
    mavenCentral()
    maven(uri("https://maven.shedaniel.me/"))
    maven(uri("https://maven.terraformersmc.com/releases/"))
}

dependencies {
    minecraft("com.mojang", "minecraft", "1.20.6")
    mappings(loom.officialMojangMappings())
    modImplementation("net.fabricmc", "fabric-loader", "0.15.11")
    modImplementation("net.fabricmc.fabric-api", "fabric-api", "0.99.0+1.20.6")
    modApi("com.terraformersmc", "modmenu", "10.0.0-beta.1")
    modApi("me.shedaniel.cloth", "cloth-config-fabric", "14.0.126") {
        exclude("net.fabricmc.fabric-api")
    }
}

tasks {
    compileJava {
        options.release = 21
        options.encoding = Charsets.UTF_8.name()
    }
    compileKotlin {
        compilerOptions.jvmTarget = JvmTarget.JVM_21
    }
}