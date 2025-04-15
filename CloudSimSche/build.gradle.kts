plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(files("lib/cloudsim-7.0.0-alpha.jar"))
    //runtimeOnly(files("lib/cloudsim-7.0.0-alpha.jar"))
}

application {
    mainClass.set("CloudSimSche") // Update with your actual main class
}
tasks.jar {
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
    }
}

tasks.register<JavaExec>("runWithInput") {
    mainClass.set("CloudSimSche")
    classpath = sourceSets["main"].runtimeClasspath
    standardInput = System.`in`
}

tasks.test {
    useJUnitPlatform()
}
