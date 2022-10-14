package testData_Store;

import pojos.Booking;
import pojos.Bookingdates;

public class Booking_testData {

    Bookingdates bookingdates=new Bookingdates("2022-10-15","2022-10-20");
    Booking booking=new Booking("John","Jack",2000,true,bookingdates);
}
