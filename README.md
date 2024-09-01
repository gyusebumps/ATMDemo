plugins {
    id 'java'
    id 'jacoco' // JaCoCo 플러그인 추가
}

group = 'org.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    testImplementation platform('org.junit:junit-bom:5.10.0')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}

test {
    useJUnitPlatform()
    finalizedBy jacocoTestReport // JaCoCo 리포트 생성
}

jacocoTestReport {
    dependsOn test

    reports {
        xml.required.set(true)
        csv.required.set(false)
        html.required.set(true)
    }
}
