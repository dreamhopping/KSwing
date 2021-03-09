plugins {
    kotlin("jvm") version "1.4.31"
    `maven-publish`
}

group = "dev.dreamhopping.kswing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Test> { enabled = false }

tasks.compileKotlin {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
