plugins {
    `java-library`
    `maven-publish`
}

version = "0.1"

repositories {
    mavenCentral()

    maven {
        url = uri("https://maven.shadew.net/")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

java {
    withSourcesJar()
    withJavadocJar()
}

tasks.test {
    useJUnitPlatform()
}
