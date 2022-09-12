package org.example.simple;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EjercicioIntegrador {


    @BeforeEach
    public void setupEach(){
      RestAssured.baseURI = "https://reqres.in";
      RestAssured.basePath = "api";

      RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }


    @Test
    public void getSingleUser(){

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .queryParam("page","2")
                    .log().all()
                .when()
                    .get("users")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("per_page", Matchers.equalTo(6),
                        "total",Matchers.greaterThan(10),
                        "data[0].id", Matchers.equalTo(7));
    }

    @Test
    public void postCreate(){

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"leader\"\n" +
                        "}")
                .when()
                    .post("users")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("job",Matchers.containsString("leader"));
    }

    @Test
    public void patchUpdateUser(){

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"name\": \"morpheus\",\n" +
                        "    \"job\": \"zion resident\"\n" +
                        "}")
                .when()
                .patch("users/2")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name",Matchers.containsString("morpheus"));




    }






}
