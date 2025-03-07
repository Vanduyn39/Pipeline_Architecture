plugins {
    java
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "org.company"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.2")

    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")
    implementation("com.zaxxer:HikariCP")
    implementation("com.microsoft.sqlserver:mssql-jdbc:12.4.2.jre11")
    implementation("org.json:json:20240303")
    implementation("com.rabbitmq:amqp-client:5.24.0")
    implementation("org.springframework.boot:spring-boot-starter-amqp")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
