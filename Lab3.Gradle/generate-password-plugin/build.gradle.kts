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
        create("moduleDependencies") {
            id = "com.lab3.gradle.password-plugin"
            implementationClass = "com.lab3.gradle.passwordutils.plugin.ProjectDependencyTreePlugin"
        }
    }
}

tasks.test {
    useJUnitPlatform()
}