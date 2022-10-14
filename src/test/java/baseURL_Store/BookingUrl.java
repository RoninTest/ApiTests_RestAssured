package baseURL_Store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BookingUrl {

    protected RequestSpecification specBooking;
    protected int statusCode=200;

    @Before
    public void setUp(){

        specBooking=new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com/")
                .build();

    }
}
