package MoviesApi_Test;

import baseURL_Store.MoviesUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Description;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData_Store.Movies_testData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get_SearchMovie extends MoviesUrl {


    protected Response response;
    protected Movies_testData movies_testData;
    protected JSONObject expBody;
    protected JsonPath actBody;
    protected RequestSpecification specGet_SearchMovie_Url;

    @Test
    @Description("Status Code and JSON Format")
    public void Test001(){

        specGet_SearchMovie_Url= specMoviesUrl.
               param("s", "Never back down").
               param("type", "movie").
               param("y", "").
               param("r", "json").
               param("page", "1").
               param("callback", "").
               param("v", "1");


      //RESPONSE SAVE
        response=given().spec(specGet_SearchMovie_Url).when().get();
        response.prettyPrint();


      //ASSERTION
        response.then().assertThat().contentType(ContentType.JSON);
        Assert.assertEquals(200,response.statusCode());



    }

    @Test
    @Description("Response")
    public void Test002(){
        specGet_SearchMovie_Url= specMoviesUrl.
                param("s", "Never back down").
                param("type", "movie").
                param("y", "").
                param("r", "json").
                param("page", "1").
                param("callback", "").
                param("v", "1");

        response=given().spec(specGet_SearchMovie_Url).when().get();

        //EXPECTED BODY
        movies_testData=new Movies_testData();
        expBody=movies_testData.expected_SearchMovie();

        actBody=response.jsonPath();
        Assert.assertEquals(expBody.get("Response"),actBody.get("Response"));
    }

}
