plugins {
    id("java")
}

group = "sv.com.celip"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile> {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
    options.encoding = "UTF-8"
}

tasks.named<Jar>("jar") {
    manifest.attributes(
        mapOf("Main-Class" to "sv.com.celip.Main",
            "Implementation-Version" to version,
            "Implementation-Vendor" to "Webster Farid Pineda Moreno",
            "Class-Path" to "lib/byte-buddy-1.14.9.jar lib/jackson-annotations-2.17.0.jar lib/jackson-core-2.17.0.jar lib/jackson-databind-2.17.0.jar lib/jackson-datatype-jsr310-2.17.0.jar"
        )
    )
}

tasks.register<Copy>("copyDependencies") {
    group = "distribution"
    into(layout.buildDirectory.dir("libs/lib"))
    from(configurations.runtimeClasspath)
}