plugins {
    id("java")
}

group = "org.game"
version = "1.0"

repositories {
    mavenCentral()
}

java.toolchain.languageVersion.set(JavaLanguageVersion.of(23))

tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.game.RockScissorPaperGame"
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}