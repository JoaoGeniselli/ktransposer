import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("java")
    kotlin("jvm") version "1.7.0"
    id("io.gitlab.arturbosch.detekt") version "1.21.0-RC1"
    `maven-publish`
}

group = "com.dosei.music.ktransposer"
version = "1.1.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}



publishing {
    val secrets = Properties().apply {
        load(FileInputStream(file("${rootDir}/secret.properties")))
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/JoaoGeniselli/ktransposer")
            credentials {
                username = secrets["publishUser"] as String
                password = secrets["publishToken"] as String
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            from(components["java"])
        }
    }
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    source = files("src/main/kotlin")
}

tasks.withType<Detekt>().configureEach {
    exclude("**/test/**", "**/*.Test.kt")
}

tasks.getByName("check").dependsOn(tasks.getByName("detekt"))