package booking_Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.junit.Test;
import pojos.Booking;
import pojos.Bookingdates;
import pojos.Bookingid;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post_Creating_Booking extends Post_CreateBooking{

    Bookingdates bookingdates;
    Booking booking;
    Bookingid responseBody;
    Response response;



        @Test
        @Description("First / Last Name Control")
        public void TestP001(){
            specBooking.pathParam("p1","booking");

            bookingdates=new Bookingdates("2022-10-15","2022-10-20");
            booking=new Booking("John","Jack",2000,true,bookingdates);

            response=given().
                    contentType(ContentType.JSON).
                    spec(specBooking).
                    when().
                    body(booking).
                    post("{p1}");

            responseBody=response.as(Bookingid.class);
            assertEquals(booking.getFirstname(),responseBody.getBooking().getFirstname());
            assertEquals(booking.getLastname(),responseBody.getBooking().getLastname());

        }

        @Test
        @Description("Deposit Field Control")
        public void TestP002(){

            specBooking.pathParam("p1","booking");

            bookingdates=new Bookingdates("2022-10-15","2022-10-20");
            booking=new Booking("John","Jack",2000,true,bookingdates);

            response=given().
                    contentType(ContentType.JSON).
                    spec(specBooking).
                    when().
                    body(booking).
                    post("{p1}");
            responseBody=response.as(Bookingid.class);

            assertEquals(booking.isDepositpaid(),responseBody.getBooking().isDepositpaid());
        }


}
