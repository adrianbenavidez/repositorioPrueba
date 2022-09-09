package org.example.simple;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class RestAssuredEjemplos {

    @Test
    public void testEjemploSimple() {
        String response = RestAssured
                .when().get("https://jsonplaceholder.typicode.com/comments?postId=1")
                .then().extract().asString();
        System.out.println(response);
    }


    @Test
    public void testEjemploConParametros() {

        String response = RestAssured
                .given().queryParam("postId", "1")
                .when().get("https://jsonplaceholder.typicode.com/comments")
                .then().extract().asString();
        System.out.println(response);
    }

    @Test
    public void testPost(){

        String response = RestAssured
                .given()
                    .contentType(ContentType.JSON).body("{\n" +
                        "    \"title\": \"Title ejemplo Post\",\n" +
                        "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur \"\n" +
                        "  }")
                .when()
                    .post("https://jsonplaceholder.typicode.com/posts")
                .then()
                    .extract().asString();

        System.out.println(response);

    }

    @Test
    public void usersPost(){

        String response = RestAssured.
                given()
                    .contentType(ContentType.JSON)
                            .body("{\n" +
                                    "    \"name\": \"Morpheous\",\n" +
                                    "    \"job\": \"Leader \"\n" +
                                    "  }")
                .when().post("https://reqres.in/api/users")
                .then().statusCode(201).extract().asString();
        System.out.println(response);
    }

    @Test
    public void userPut(){
        String response = RestAssured
                .given().contentType(ContentType.JSON).body("{\"name\": \"Morpheous\", \"job\": \"Leader\"}")
                .when().put("https://reqres.in/api/users/2")
                .then().statusCode(200).extract().asString();
        System.out.println(response);

    }







    
    

}
