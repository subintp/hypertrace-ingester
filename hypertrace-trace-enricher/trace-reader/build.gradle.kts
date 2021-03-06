plugins {
  `java-library`
  jacoco
  id("org.hypertrace.jacoco-report-plugin")
  id("org.hypertrace.publish-plugin")
}

dependencies {
  api("org.hypertrace.core.attribute.service:attribute-service-api:0.8.7")
  api("org.hypertrace.core.attribute.service:caching-attribute-service-client:0.8.7")
  implementation("org.hypertrace.core.datamodel:data-model:0.1.12")
  implementation("org.hypertrace.core.attribute.service:attribute-projection-registry:0.8.7")
  implementation("org.hypertrace.entity.service:entity-type-service-rx-client:0.2.5")
  implementation("org.hypertrace.entity.service:entity-data-service-rx-client:0.2.5")
  implementation("org.hypertrace.core.grpcutils:grpc-client-rx-utils:0.3.3")
  implementation("org.hypertrace.core.grpcutils:grpc-context-utils:0.3.3")
  implementation("io.reactivex.rxjava3:rxjava:3.0.7")
  constraints {
    implementation("com.google.guava:guava:30.1-jre") {
      because("Information Disclosure [Medium Severity][https://snyk.io/vuln/SNYK-JAVA-COMGOOGLEGUAVA-1015415] in com.google.guava:guava@29.0-android")
    }
  }

  testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
  testImplementation("org.mockito:mockito-core:3.6.28")
  testImplementation("org.mockito:mockito-junit-jupiter:3.6.28")
  testRuntimeOnly("org.apache.logging.log4j:log4j-slf4j-impl:2.14.0")

  tasks.test {
    useJUnitPlatform()
  }
}