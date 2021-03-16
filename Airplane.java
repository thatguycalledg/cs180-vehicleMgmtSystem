/**
 * Project 3 -- Airplane
 *
 * This program is a class that stores the created
 * airplanes. It also adds the passengers to the airplane when
 * commanded to do so, and after upgrades.
 *
 * @author Gaurang Vinayak, lab sec 19
 *
 * @version March 22, 2019
 *
 */

public class Airplane implements Vehicle {

    private int capacity;               // The maximum number of passengers this vehicle can hold
    private Passenger[] passengers;     // The array of Passengers that have booked a trip on this vehicle
    private int count;                  // The number of passengers currently assigned to this vehicle
    private Route route;                // The route on which this Vehicle will travel

    public Airplane(Route route, int capacity) {

        this.route = route;
        this.capacity = capacity;
        count = 0;
        passengers = new Passenger[0];
    }

    public int getCapacity() {

        return this.capacity;
    }

    public Route getRoute() {

        return this.route;
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

        count = this.getCount();

        if (!person.getRoute().equals(this.route) || count >= capacity) {

            person.cancel();
            return false;
        }

        Passenger[] tempo = new Passenger[count + 1];

        for (int i = 0; i < count; i++) {

            tempo[i] = passengers[i];
            passengers[i].confirm();
        }

        person.confirm();
        tempo[count] = person;
        passengers = tempo;

        return true;
    }

    public boolean addPassenger(Passenger person) {

        return (this.addPassenger(person, true));
    }

    public Vehicle upgrade(int newCapacity) {

        return null;
    }
}