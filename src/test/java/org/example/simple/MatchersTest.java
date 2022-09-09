package org.example.simple;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class MatchersTest {

    @Test
    public void matchersTest1(){
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .queryParam("id","6")
                .when()
                    .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                    .statusCode(200)
                .log().all();
    }


    @Test
    public void matchersTest4(){
        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .statusCode(200)
                .body("[15].postId",Matchers.greaterThan(2))
                .log().all();
    }



    @Test
    public void matchersTest2(){
        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .queryParam("postId","2")
                .when()
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .statusCode(200)
                .body("[0].email", Matchers.containsString("Mueller"));
    }




}
