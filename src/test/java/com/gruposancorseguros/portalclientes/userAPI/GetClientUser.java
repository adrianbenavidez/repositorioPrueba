package com.gruposancorseguros.portalclientes.userAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class GetClientUser {

    @Test
    public void requestGetClientUser(){

        String bearerToken = "eyJhbGciO" +
                "iJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16ZEdOalkyUWtReU9EQTBRVGt6UWp" +
                "FNVEwSXlSRVpFTmtFek9URXhOREF6TnpKRlJUWXhSZyJ9.eyJpc3MiOiJodHRwczovL2xvZ2luLWRldi5ncnVwb" +
                "3NhbmNvcnNlZ3Vyb3MuY29tLyIsInN1YiI6ImF1dGgwfDYyYzVkZDQ4NGY3ZGQ3MTMwMGM1ZTJiOSIsImF1ZCI6WyJodHRwczovL2x" +
                "vZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tL2FwaS92Mi8iLCJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tL3Vz" +
                "ZXJpbmZvIl0sImlhdCI6MTY2MjU1OTE5OSwiZXhwIjoxNjYyNTk1MTk5LCJhenAiOiIwTU5CNHV3SEJJUFgzc2E2TzllalV0SWZ5TEFCazZF" +
                "VyIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwifQ.iqJ-9Sfxo-joKfwZHBKXCAzaB6Ee8Lr4No_my70gRWd_4AYVtFqHBqa6jVEIBE" +
                "j0r6vkv7Bhs-wRXEHHgRPvbbyU-mSz3-0WsozeHqdzca5ChO7CphFCSSKaNLr08zjBx2-I6MQcWIn3FL7n1fNhlDONmhn195FnjHa" +
                "8kto5VyF7LkGyjoFClqvV2M2sGuTgHikeYkNwJnjKbZLI0QLgCtrYmxvjbu32lLWtM0xrpBJqJ9QOgDaVYkLmP7GRqg94u" +
                "wm20wxS4CRHz19djX8tYbm0Zu7iy5P2ZmCfZM54BOq6XoMja-w1WaxisB2Tgxp8Ow8X9SJyTaxFJLjKIF2Z5A";

        String tokenInfo = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJod" +
                "HRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1" +
                "zL3JvbGUiOjE1LCJleHAiOjE2NjI2NDUyMjl9.1IQpKuZp1BLLS400L713IuXoqfvM5DVUuChH28zPqr0";

        String tokenESB = "eyJ1c2VyTmFtZSI6InRlc3RiZW5lZmljaW8xQHlvcG1haWwuY29tIiwiYnVwSWQiOiIxNTY2MzcyNyJ9";

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
                //.log().all()
                .when()
                .get("https://portalclientes-tst0-api.gruposancorseguros.com/api/v2/users/client/user")
                .then()
                .statusCode(200)
                .log().all();


    }


}
