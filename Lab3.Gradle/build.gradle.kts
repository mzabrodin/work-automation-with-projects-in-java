plugins {
    id("java")
    id("com.lab3.gradle.modules-dependencies-plugin")
}

group = "com.lab3.gradle.password-utils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}