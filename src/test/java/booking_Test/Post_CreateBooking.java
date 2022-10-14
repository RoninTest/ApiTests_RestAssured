package booking_Test;

import baseURL_Store.BookingUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Booking;
import pojos.Bookingdates;
import pojos.Bookingid;


import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_CreateBooking extends BookingUrl {

    Bookingdates bookingdates;
    Booking booking;
    Bookingid responseBody;
    Response response;

    @Test
    public void TestP003(){
        //CREATE URL
        specBooking.pathParam("p1","booking");
        //CREATE REQ BODY
        bookingdates=new Bookingdates("2022-10-15","2022-10-20");
        booking=new Booking("John","Jack",2000,true,bookingdates);


        //CREATE RESPONSE
        response=given().
                contentType(ContentType.JSON).
                spec(specBooking).
                when().
                body(booking).
                post("{p1}");

        responseBody=response.as(Bookingid.class);

        //ASSERTION
        response.then().assertThat().contentType(ContentType.JSON);
        assertEquals(ContentType.JSON,ContentType.JSON);
    }


}

