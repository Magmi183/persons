plugins {
    kotlin("jvm") version "2.0.0"
    id("org.springframework.boot") version "2.7.3"
    id("io.spring.dependency-management") version "1.0.12.RELEASE"
}

group = "com.michaljanecek"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    // Spring Boot Web dependency for REST APIs
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Kotlin standard library and reflection
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(19)
}

tasks.withType<org.springframework.boot.gradle.tasks.run.BootRun> {
    mainClass.set("com.example.demo.PersonApplicationKt")
}