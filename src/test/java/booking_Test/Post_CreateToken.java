package booking_Test;

import baseURL_Store.BookingUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Auth;

import static io.restassured.RestAssured.given;

public class Post_CreateToken extends BookingUrl {

    Response response;
    Auth auth;

   /* **********************************************
                      REQUEST
   *************************************************
    URL : https://restful-booker.herokuapp.com/auth
    "username" : "admin",
    "password" : "password123"
   *************************************************
                      RESPONSE
   *************************************************
    "token": "6b033fb072bc032"
   ********************************************** */

    @Test
    public void TestP001(){

        /*CREATE URL*/
        specBooking.pathParam("p1","auth");

        /*CREATE REQ BODY*/
        this.auth=new Auth("admin","password123");


        /*CREATE RESPONSE*/
        response=given().
                contentType(ContentType.JSON).
                spec(specBooking).
                when().
                body(auth).
                post("{p1}");

        Assert.assertEquals(statusCode,response.statusCode());
    }

}
