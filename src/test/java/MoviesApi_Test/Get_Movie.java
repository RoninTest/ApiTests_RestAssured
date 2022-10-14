package MoviesApi_Test;

import baseURL_Store.MoviesUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.junit.Test;
import testData_Store.Movies_testData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class Get_Movie extends MoviesUrl {

    protected Response response;
    protected JSONObject expBody;
    protected JsonPath actBody;

    @Test
    @Description("Status Code and JSON Test")
    public  void Test001(){


        //SAVE RESPONSE
        response = given().spec(specMoviesUrl).when().get();
        response.prettyPrint();

        //EXPECTED DATA
        Movies_testData movies_testData=new Movies_testData();
        expBody=movies_testData.expectedData();

        //ASSERTIONS
        actBody=response.jsonPath();
        response.then().assertThat().contentType(ContentType.JSON);
        assertEquals(movies_testData.statusCode,response.statusCode());


    }
    @Test
    @Description("Year and Director Test")
    public void Test002(){


        response = given().spec(specMoviesUrl).when().get();
        response.prettyPrint();

        Movies_testData movies_testData=new Movies_testData();
        expBody=movies_testData.expectedData();
        //ASSERTIONS
        actBody=response.jsonPath();
        assertEquals(expBody.get("Year"),actBody.get("Year"));
        assertEquals(expBody.get("Director"),actBody.get("Director"));
    }

    @Test
    @Description("Year and Name of Movie")
    public void Test003(){


        response = given().spec(specMoviesUrl).when().get();
        response.prettyPrint();

        Movies_testData movies_testData=new Movies_testData();
        expBody=movies_testData.expectedData();
        //ASSERTIONS
        actBody=response.jsonPath();
        assertEquals(expBody.get("Year"),actBody.get("Year"));
        assertEquals(expBody.get("Released"),actBody.get("Released"));
    }
}
