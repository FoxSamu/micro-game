plugins {
    `java-platform`
    `maven-publish`
}

val rfxMavenHost: String by properties
val rfxMavenUser: String by properties
val rfxMavenPass: String by properties

group = "dev.runefox.micro"
version = "0.1"

subprojects {
    apply(plugin = "maven-publish")

    group = rootProject.group

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>(project.name) {
                    artifactId = project.name
                    groupId = "${project.group}"
                    version = "${project.version}"

                    from(components["java"])
                }
            }
            repositories {
                maven {
                    url = uri(rfxMavenHost)
                    credentials {
                        username = rfxMavenUser
                        password = rfxMavenPass
                    }
                }
            }
        }
    }
}

dependencies {
    subprojects.forEach {
        api(it)
    }
}

javaPlatform {
    allowDependencies()
}

publishing {
    publications {
        create<MavenPublication>("bom") {
            from(components["javaPlatform"])
            artifactId = "bom"
            groupId = "${project.group}"
            version = "${project.version}"
        }
    }
    repositories {
        maven {
            url = uri(rfxMavenHost)
            credentials {
                username = rfxMavenUser
                password = rfxMavenPass
            }
        }
    }
}

