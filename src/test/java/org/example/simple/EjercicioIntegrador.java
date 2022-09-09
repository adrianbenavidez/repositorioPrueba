package org.example.simple;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
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
    public void EjercicioComplementario(){

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .queryParam("page","2")
                    .log().all()
                .when()
                    .get("users")
                .then()
                .body("per_page", Matchers.equalTo(6),
                        "total",Matchers.greaterThan(10));

    }



}
