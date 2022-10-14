package pexelApi_Test;

import baseURL_Store.PexelUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData_Store.Pexel_testData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_aPhoto extends PexelUrl {

    // photos/:id



    @Test
    public void Api_GetTest01(){

        //URL
        specPexel.pathParams("pp1","photos","pp2","id");
        specPexel.auth();

        //EXPECTED DATA
        Pexel_testData pexel_testData=new Pexel_testData();
        JSONObject expBody=pexel_testData.expectedData();

        //SAVE RESPONSE
        Response response=given()
                .spec(specPexel)
                .when()
                .header("Authorization",pexel_testData.autoh)
                .get("{pp1}/{pp2}");
        response.prettyPrint();

        //ASSERTION
        JsonPath actBody=response.jsonPath();
        response.then().assertThat().contentType(ContentType.JSON);
        assertEquals(200,pexel_testData.statusCode);
        assertEquals(expBody.get("status"),actBody.get("status"));
        assertEquals(expBody.get("error"),actBody.get("error"));

    }

}
