plugins {
    id("java")
}

group = "org.example"

repositories {
    mavenCentral()
}

dependencies {
    // Kafka clients
    implementation("org.apache.kafka:kafka-clients:3.5.1")
    // SLF4J API and Simple Binding
    implementation("org.slf4j:slf4j-api:2.0.7")
    implementation("org.slf4j:slf4j-simple:2.0.7")

    // Uncomment and add JUnit dependencies for testing
    // testImplementation(platform("org.junit:junit-bom:5.9.1"))
    // testImplementation("org.junit.jupiter:junit-jupiter")
}



tasks.test {
    useJUnitPlatform()
}