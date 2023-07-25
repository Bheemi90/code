plugins {
    kotlin("jvm") version "1.8.21"
    application
}

group = "loglass.co.jp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        (this).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

application {
    mainClass.set("MainKt")
}
