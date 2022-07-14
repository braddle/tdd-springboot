package com.github.braddle.learning;

import com.github.braddle.learning.entites.Thing;
import com.github.braddle.learning.repositories.ThingRepository;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {})
class LearningApplicationTests {

    public static final String NAME = "Testing 123";
    public static final int NUMBER = 42;
    public static final double PI = 3.14;
    public static final boolean BOOL = false;
    @LocalServerPort
    private int randomPort;

    @Autowired
    private ThingRepository thingRepository;

    @BeforeEach
    void setUp() {
        thingRepository.deleteAll();
        port = randomPort;
    }

    @Test
    void contextLoads() {
    }

    @Test
    void Health() {
        get("/health")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("status", equalTo("OK"));
    }

    @Test
    void GetThingThatDoesNotExists() {
        get("/thing/1")
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    void GetThingThatDoesExists() {
        Thing t = new Thing(NAME, NUMBER, PI, BOOL);

        thingRepository.save(t);

        get("/thing/1")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(NAME))
                .body("number", equalTo(NUMBER))
                .body("decimal", equalTo((float) PI))
                .body("bool", equalTo(BOOL));
    }

    @Test
    void CreateAThing() throws Exception {
        Response r = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"name\": \"Testing Testing 123\",\n" +
                        "    \"number\": 42,\n" +
                        "    \"decimal\": 3.1415,\n" +
                        "    \"bool\": true\n" +
                        "}")
                .post("/thing");

        r.then().statusCode(HttpStatus.SC_OK);

        Long id = r.body().jsonPath().getLong("id");
        Thing t = thingRepository.findById(id).orElseThrow(() -> new Exception("Could not find Thing in Repo"));

        assertEquals("Testing Testing 123", t.getName());
        assertEquals(42, t.getNumber());
        assertEquals(3.1415, t.getDecimal());
        assertEquals(true, t.isBool());
    }
}
