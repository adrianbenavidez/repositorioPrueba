package com.gruposancorseguros.portalclientes.banksAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.notNullValue;


public class GetCBU {

    @Test
    public void requestGetCBU(){

        String bearerToken = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16ZEdOalkyUWtReU9EQTBRVGt6UWpFNVEwSXlSR" +
                "VpFTmtFek9URXhOREF6TnpKRlJUWXhSZyJ9.eyJpc3MiOiJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29t" +
                "LyIsInN1YiI6ImF1dGgwfDYyYzVkZDQ4NGY3ZGQ3MTMwMGM1ZTJiOSIsImF1ZCI6WyJodHRwczovL2xvZ2luLWRldi5ncnVwb" +
                "3NhbmNvcnNlZ3Vyb3MuY29tL2FwaS92Mi8iLCJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tL3VzZXJ" +
                "pbmZvIl0sImlhdCI6MTY2MjY1OTg4NSwiZXhwIjoxNjYyNjk1ODg1LCJhenAiOiIwTU5CNHV3SEJJUFgzc2E2TzllalV0SWZ5T" +
                "EFCazZFVyIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwifQ.bKEubBW9QpvhZraNQztw43Am_wmp_G90d9uqcJ0nj3wy3" +
                "r78lhNlfQy9lFWckOQ9qYiSrkvPZSHtDH2ckIznfnkxcHZaderezq2Q7XA3SN0Vqw_CxhUTfM4fBKROwkJWA9zYVAxolfdFOFv8_" +
                "7xKHBDyf--X9HSnz61iKVtPeAhjKYylymVe8qkwv_5Ef1ixIhtZaQvF4HYabuBZoWKFpDJpPggKW8hVsNyuZKWbCIWlSTv14On48" +
                "hRIe8bLAwHRRC2sknoAugIDopr77-cOUPHnECD_d14mRkOBTHk0a2xQhkOSxB87HTO9ecQZQtEmyPY-XeNPnKWdpfp27d0D0Q";

        String tokenInfo = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29t" +
                "L3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOjE1LCJleHAiOjE2NjI3NDYzMzN9.xIs2lp5sSCAGzTOKbYO1tEonB7" +
                "a-eK2-msw3ZIpqjn4";

        String tokenESB = "";

        RestAssured
                .given()
                .contentType(ContentType.JSON)
                .queryParam("bupId","550351")
                .headers("ApplicationId","17",
                        "CompanyCode","1",
                        "ClientTypeId","1",
                        "Authorization", "Bearer " + bearerToken,
                        "AuthorizationInfo", tokenInfo,
                        "AuthorizationESB", tokenESB
                )
                .log().all()
                .when()
                .get("https://portalclientes-pre-api.gruposancorseguros.com/api/v2/bankaccount/cbu")
                .then()
                .statusCode(200)
                //.body("registeredName", notNullValue())
                //.body("[0]bankIdentificationCodes",notNullValue())
                .log().all();
    }
}
