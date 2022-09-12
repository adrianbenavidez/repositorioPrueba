package com.gruposancorseguros.portalclientes.banksAPI;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.notNullValue;


public class GetCBU {

    @BeforeEach
    public void setUp(){
        RestAssured.baseURI = "https://portalclientes-pre-api.gruposancorseguros.com";
        RestAssured.basePath = "/api/v2";

        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
    }

    @Test
    public void requestGetCBU(){

        String bearerToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16ZEdOalkyU" +
                "WtReU9EQTBRVGt6UWpFNVEwSXlSRVpFTmtFek9URXhOREF6TnpKRlJUWXhSZyJ9.eyJpc3MiO" +
                "iJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tLyIsInN1YiI6ImF1dGgwf" +
                "DYyYzVkZDQ4NGY3ZGQ3MTMwMGM1ZTJiOSIsImF1ZCI6WyJodHRwczovL2xvZ2luLWRldi5ncnVwb3Nhbm" +
                "NvcnNlZ3Vyb3MuY29tL2FwaS92Mi8iLCJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY2" +
                "9tL3VzZXJpbmZvIl0sImlhdCI6MTY2Mjk5MjEzNSwiZXhwIjoxNjYzMDI4MTM1LCJhenAiOiIwTU5CNHV3SEJJUF" +
                "gzc2E2TzllalV0SWZ5TEFCazZFVyIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwifQ.eRGKREs2e5D0Zpqnu1R" +
                "xbYNiTqskjunTQDPNWo2JJTXeR3zfqNMgLdOo99jvSNo-ES1hxXTdriWNn_u4Uvus-hG_wn9P0lHXezRoHTbnJRQs96C0dqJ" +
                "npq9fhUzSEz2nBZIAGQdx9erTJyUPLtY-fkjb57nq2XEOD2XU8tWA7jAJ2urOkwC8a2sfbxGEERl30Q8MYPo1PX_nieEteT3TXh" +
                "ZJ6SsrG8ATPxTJzeM0af4-7f52zSprJG7WGmQLaaVnMO8UbnYH46sYHriXuFCOZ7nuVS4heoehzeVgjumMRwrJAC7BqWf0t9HE9hZR" +
                "pSVw5WtopG4oWNGFKAm_HNunsQ";

        String tokenInfo = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaW" +
                "RlbnRpdHkvY2xhaW1zL3JvbGUiOjE1LCJleHAiOjE2NjMwNzY5NzN9.8_BE05EOEW6FWcoB275o-PcZcWj-nF3ik5RIQPCinw0";

        String tokenESB = "eyJ1c2VyTmFtZSI6InRlc3RiZW5lZmljaW8xQHlvcG1haWwuY29tIiwiYnVwSWQiOiIxNTY2MzcyNyJ9";

        RestAssured
                .given()
                .queryParam("bupId","550351")
                .headers("ApplicationId","17",
                        "CompanyCode","1",
                        "ClientTypeId","1",
                        "Authorization", "Bearer " + bearerToken,
                        "AuthorizationInfo", tokenInfo,
                        "AuthorizationESB", tokenESB
                )
                .when()
                .get("/bankaccount/cbu")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("bankAccount.bankIdentificationCodes[0].bankIdentificationCode",notNullValue());
    }
}
