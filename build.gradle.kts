plugins {
    kotlin("jvm") version "2.0.0"
}

group = "com.michaljanecek"
version = "1.0"

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
    jvmToolchain(19)
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.michaljanecek.persons.MainKt"
    }
}


tasks.jar {
    manifest.attributes["Main-Class"] = "com.michaljanecek.persons.MainKt"
    val dependencies = configurations
        .runtimeClasspath
        .get()
        .map(::zipTree) // OR .map { zipTree(it) }
    from(dependencies)
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}