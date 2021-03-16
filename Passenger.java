/**
 * Project 3 -- Passenger
 *
 * This program is a class that stores the information of the passenger
 * such as the route they are travelling on, and their name, and status of
 * confirmation with the travel.
 *
 * @author Gaurang Vinayak, lab sec 19
 *
 * @version March 22, 2019
 *
 */

public class Passenger {

    public static final String CANCELED = "Canceled";
    public static final String WAITLIST = "Waitlist";
    public static final String CONFIRMED = "Confirmed";
    private String passengerName;   // The name of the Passenger
    private String bookingStatus;   // The status of the Passenger's booking
    private Route route;            // The Route on which the passenger wishes to travel

    public Passenger(String name, Route route) {

        passengerName = name;
        this.route = route;
        bookingStatus = WAITLIST;
    }

    public String getPassengerName() {

        return passengerName;
    }

    public Route getRoute() {

        return route;
    }

    public String getBookingStatus() {

        return bookingStatus;
    }

    public void confirm() {

        if (bookingStatus.equals(WAITLIST)) {

            bookingStatus = CONFIRMED;
        }
    }

    public void cancel() {

        if (bookingStatus.equals(WAITLIST)) {

            bookingStatus = CANCELED;
        }
    }
}