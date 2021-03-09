plugins {
    kotlin("jvm") version "1.4.31"
}

group = "dev.dreamhopping.kswing"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

tasks.withType<Test> { enabled = false }
