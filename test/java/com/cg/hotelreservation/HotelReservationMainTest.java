package com.cg.hotelreservation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HotelReservationMainTest {
    HotelReservationMain hotelReservationMain;
    @Before
    public void setup() {
        hotelReservationMain = new HotelReservationMain();
    }
    @Test
    public void givenDetails_WhenHotelObjectCreated_ShouldReturnTrue() {
        String hotelName = "ITC";
        int rate = 10000;
        Hotel hotel = new Hotel(hotelName, rate);
        Assert.assertTrue(hotel != null);
    }

    @Test
    public void givenHotelList_ShouldReturnCheapestHotel() {
        hotelReservationMain.hotelList.add(new Hotel("ITC", 10000));
        hotelReservationMain.hotelList.add(new Hotel("Taj", 6000));
        hotelReservationMain.hotelList.add(new Hotel("Mahindra", 9000));
        String cheapestHotel = hotelReservationMain.findCheapestHotel();
        Assert.assertEquals("Taj", cheapestHotel);
    }
}
