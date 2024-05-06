plugins {
    id("java")
    id("application")
}

group = "uk.sauch"
version = "1.0-SNAPSHOT"

application {
    mainClass = "uk.sauch.ctf.Main"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.25.3")
}

tasks.test {
    useJUnitPlatform()
}