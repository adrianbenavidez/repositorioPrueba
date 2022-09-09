package org.example.simple;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class LogEjemplos {


    @Test
    public void logGetEjemplo(){

        RestAssured
                .given()
                    .contentType(ContentType.JSON)

                    .queryParam("postId","2")
                    .log().all()
                .when()
                    .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .log().all();

    }



}
