package com.gruposancorseguros.portalclientes.policyAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.notNullValue;


public class PostElectronicDispatchPoliciesids {

    @Test
    public void requestPostElectronicDispatchids(){

        String bearerToken = "Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6Ik16ZEdOalkyUWtReU9EQTBRVGt6UWpFNVEwSXlSRVpFTmtFek9URXhOREF6TnpKRlJUWXhSZyJ9.eyJpc3MiOiJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tLyIsInN1YiI6ImF1dGgwfDYyYzVkZDQ4NGY3ZGQ3MTMwMGM1ZTJiOSIsImF1ZCI6WyJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tL2FwaS92Mi8iLCJodHRwczovL2xvZ2luLWRldi5ncnVwb3NhbmNvcnNlZ3Vyb3MuY29tL3VzZXJpbmZvIl0sImlhdCI6MTY2MjY0NjExNCwiZXhwIjoxNjYyNjgyMTE0LCJhenAiOiIwTU5CNHV3SEJJUFgzc2E2TzllalV0SWZ5TEFCazZFVyIsInNjb3BlIjoib3BlbmlkIHByb2ZpbGUgZW1haWwifQ.qXRtXDgWZeD5KEr_Wfpqz4jMynduJGVPnNYH1DKBdIhV_aNSFA4ZH8wMcL85PQQGG2UwSchP9elN6RkX7GPRsKwRc6vPuqjTQuphlFk8RzPS8YV8h_Ti_Kdu6f9Asuy_T7TRvm7CRxV_UYM2HaK5moyB_yFCgeano3EAU3NMPsaVufYioM9WjWOnQo9-aSTzg1H6Myct_GHd8qVDF_0p4jzF2qBdC-FqBiNmxfs7xJ1mL1F_C7UphAXUO4umq3IuoKNbItTwFe3rIELNi57W-nl_0lnkqhl-xB-sj9RlVIsvyZS8ltFIKsl3I7Ub4U8eVrJU41JD8kpgJz_kQahmLQ";

        String tokenInfo = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy5taWNyb3NvZnQuY29tL3dzLzIwMDgvMDYvaWRlbnRpdHkvY2xhaW1zL3JvbGUiOjE1LCJleHAiOjE2NjI3Mjk0Mzh9.jsdnC7OqQhtThtYWcuiaFpOZ8zK7F__NS6ylpAZAx1A";

        String tokenESB = "eyJ1c2VyTmFtZSI6InRlc3RiZW5lZmljaW8xQHlvcG1haWwuY29tIiwiYnVwSWQiOiIxNTY2MzcyNyJ9";

        RestAssured
                .given()
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                        "    \"electronicDispatch\": {\n" +
                        "        \"bupId\": 550351\n" +
                        "    }\n" +
                    "}")
                    .headers("ApplicationId","17",
                        "CompanyCode","1",
                        "ClientTypeId","1",
                        "Authorization", "Bearer " + bearerToken,
                        "AuthorizationInfo", tokenInfo,
                        "AuthorizationESB", tokenESB
                    )
                .when()
                    .post("https://portalclientes-tst0-api.gruposancorseguros.com/api/v2/policytime/electronicdispatchpoliciesids")
                .then()
                    .statusCode(200)
                //.body("bupId", notNullValue())

                    .log().all();

    }


}
