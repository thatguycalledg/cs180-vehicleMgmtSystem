/**
 * Project 3 -- Bus
 *
 * This program is a class that stores the created
 * buses. It also adds the passengers to the bus when
 * commanded to do so, and upgrades if required.
 *
 * @author Gaurang Vinayak, lab sec 19
 *
 * @version March 22, 2019
 *
 */

public class Bus implements Vehicle {

    private int capacity;               // The maximum number of passengers this vehicle can hold
    private Passenger[] passengers;     // The array of Passengers assigned to this vehicle
    private int count;                  // The number of passengers currently assigned to this vehicle
    private Route route;                // The route on which this Vehicle will travel

    public Bus(Route route) {

        this.route = route;
        this.capacity = 2;
        this.passengers = new Passenger[0];
    }

    public Bus(Route route, int capacity) {

        this.route = route;
        this.capacity = capacity;
        this.passengers = new Passenger[0];
    }

    public int getCapacity() {

        return capacity;
    }

    public Route getRoute() {

        return route;
    }

    public int getCount() {

        count = 0;

        for (int i = 0; i < passengers.length; i++) {

            if (passengers[i] != null) count++;
        }

        return count;
    }

    public Passenger[] getPassengers() {

        int a = getCount();

        Passenger[] output = new Passenger[a];

        for (int i = 0; i < a; i++) output[i] = passengers[i];

        return output;
    }

    public boolean addPassenger(Passenger person, boolean waitingList) {

        count = getCount();

        if (!person.getRoute().equals(this.route)) {

            person.cancel();
            return false;
        }

        if (!waitingList && count >= capacity) {

            person.cancel();
            return false;
        }

        if (count >= capacity) {

            Passenger[] crescendo = new Passenger[count + 1];

            for (int i = 0; i < count; i++) crescendo[i] = passengers[i];

            crescendo[count] = person;
            passengers = crescendo;
            count++;

            return true;
        } else {
            Passenger[] crescendo = new Passenger[count + 1];

            for (int i = 0; i < count; i++) crescendo[i] = passengers[i];

            crescendo[count] = person;
            passengers = crescendo;
            count++;
            person.confirm();

            return true;
        }
    }

    public boolean addPassenger(Passenger person) {

        return (this.addPassenger(person, true));
    }

    public Vehicle upgrade(int newCapacity) {

        Airplane a = (new Airplane(getRoute(), newCapacity));

        for (int i = 0; i < getCount(); i++) a.addPassenger(passengers[i]);

        return a;
    }
}