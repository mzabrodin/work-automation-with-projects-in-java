plugins {
    id("java")
}

group = "com.lab3.gradle.password-utils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":generator"))
    implementation(project(":hasher"))
    implementation(project(":validator"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
