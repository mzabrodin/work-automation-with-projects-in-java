plugins {
    id("java")
}

group = "com.lab4.annotations"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":annotation-api"))
    implementation(project(":annotation-runtime"))
    annotationProcessor(project(":annotation-process"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}