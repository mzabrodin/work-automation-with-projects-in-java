plugins {
    id("java")
}

group = "com.lab3.gradle.password-utils"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.nulab-inc:zxcvbn:1.9.0")
    implementation("org.passay:passay:1.6.6")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}