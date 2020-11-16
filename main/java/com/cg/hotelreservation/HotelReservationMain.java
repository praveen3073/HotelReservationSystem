package com.cg.hotelreservation;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;

public class HotelReservationMain {
    public ArrayList<Hotel> hotelList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Welcome to Hotel Reservation System");
    }

    // Find cheapest hotel by weekday rates in between the given start and end date
    public Hotel findCheapestHotelByWeekdayRates(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.weekdayRate < hotel2.weekdayRate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }

    // Find cheapest hotel by weekend rates in between the given start and end date
    public Hotel findCheapestHotelByWeekendRates(String startDate, String endDate) {
        Optional<Hotel> cheapestHotel = hotelList.stream()
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.weekendRate < hotel2.weekendRate ? hotel1 : hotel2);
        if (cheapestHotel.isPresent())
            return cheapestHotel.get();
        return null;
    }

    // Find cheapest best rated hotel by weekday rates in given date range
    // Using Java stream, Regex and Exceptions
    public Hotel findCheapestBestRatedHotelByWeekdayRates(String startDate, String endDate) {
        double bestRating = hotelList.stream()
                .filter(h -> h.validate())
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .reduce((hotel1, hotel2) -> hotel1.rating > hotel2.rating ? hotel1 : hotel2).get().rating;
        Optional<Hotel> cheapestBestRatedHotel = hotelList.stream()
                .filter(h -> h.validate())
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .filter(h -> h.rating == bestRating)
                .reduce((hotel1, hotel2) -> hotel1.weekdayRate < hotel2.weekdayRate ? hotel1 : hotel2);
        if (cheapestBestRatedHotel.isPresent())
            return cheapestBestRatedHotel.get();
        return null;
    }

    // Validate input date: Should be of the format YYYY-MM-DD
    public boolean validateDate(String startDate) throws InvalidInputException {
        if (Pattern.matches("^[0-9]{4}[-][0-9]{2}[-][0-9]{2}$", startDate))
            return true;
        throw new InvalidInputException("Date should be of the format YYYY-MM-DD");
    }

    // Validate input customer type: Should be Regular or Reward
    public boolean validateCustomerType(String customerType) throws InvalidInputException {
        if (customerType.equalsIgnoreCase("regular") || customerType.equalsIgnoreCase("reward"))
            return true;
        throw new InvalidInputException("Customer can only be of the type Regular and Reward");
    }

    // Find cheapest best rated hotel by weekday rates in given date range for Reward customers
    // Using Java stream, Regex and Exceptions
    public Hotel findCheapestBestRatedHotelByWeekdayRatesForRewardCustomers(String startDate, String endDate) {
        double bestRating = hotelList.stream()
                .filter(h -> h.validate())
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .filter(h -> h.customerType.equalsIgnoreCase("reward"))
                .reduce((hotel1, hotel2) -> hotel1.rating > hotel2.rating ? hotel1 : hotel2).get().rating;
        Optional<Hotel> cheapestBestRatedHotel = hotelList.stream()
                .filter(h -> h.validate())
                .filter(h -> h.startDate.compareTo(startDate) > 0 && h.endDate.compareTo(endDate) < 0)
                .filter(h -> h.customerType.equalsIgnoreCase("reward"))
                .filter(h -> h.rating == bestRating)
                .reduce((hotel1, hotel2) -> hotel1.weekdayRate < hotel2.weekdayRate ? hotel1 : hotel2);
        if (cheapestBestRatedHotel.isPresent())
            return cheapestBestRatedHotel.get();
        return null;
    }
}
