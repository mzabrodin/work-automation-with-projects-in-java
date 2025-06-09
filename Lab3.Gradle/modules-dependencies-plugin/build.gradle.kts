plugins {
    id("java-gradle-plugin")
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

gradlePlugin {
    plugins {
        create("modulesDependencies") {
            id = "com.lab3.gradle.modules-dependencies-plugin"
            implementationClass = "com.lab3.gradle.passwordutils.plugin.DependencyTreePlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}