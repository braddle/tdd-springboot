package com.github.braddle.learning;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {})
class LearningApplicationTests {

    @LocalServerPort
    private int randomPort;
    @BeforeEach
    void setUp() {
        port = randomPort;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void Health() {
        get("/health")
                .then()
                .statusCode(200)
                .body("status", equalTo("OK"));
    }


}
