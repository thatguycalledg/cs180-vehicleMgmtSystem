/**
 * Project 3 -- Vehicle Management
 * <p>
 * This program manages which route to create, and
 * on which route to add the passenger to.
 *
 * @author Gaurang Vinayak, lab sec 19
 * @version March 22, 2019
 */

public class VehicleManagement {

    private Vehicle[] vehicles;         // The array of Vehicles that have been assigned a Route
    private int count;                  // The no. of vehicles in the array (and therefore assigned to a Route)
    private int bus;                    // The number of buses that are available (not assigned to a Route)
    private int plane;                  // The number of airplanes that available (not assigned to a Route)

    public VehicleManagement(int bus, int plane) {

        vehicles = new Vehicle[0];
        this.bus = bus;
        this.plane = plane;
        this.count = 0;
    }

    public boolean createRoute(Route route, int capacity) {

        count = getCount();

        if (bus == 0) {
            return false;
        }

        for (int i = 0; i < count; i++) {

            if ((vehicles[i].getRoute()).equals(route)) {
                return false;
            }
        }

        Vehicle[] temp = new Vehicle[count + 1];

        for (int i = 0; i < count; i++) {
            temp[i] = vehicles[i];
        }

        temp[count] = new Bus(route, capacity);
        vehicles = temp;
        count++;
        bus--;

        return true;
    }

    public boolean addPassengerToVehicle(Passenger person) {

        if (lookupVehicle(person.getRoute()) == -1) {

            person.cancel();
            return false;
        }

        int i = lookupVehicle(person.getRoute());

        if (plane != 0) {

            boolean out = vehicles[i].addPassenger(person);
            if (!out) return false;
        }

        return (vehicles[i].addPassenger(person));
    }

    public Vehicle[] getVehicles() {

        Vehicle[] temp = new Vehicle[getCount()];

        for (int i = 0; i < getCount(); i++) temp[i] = vehicles[i];

        vehicles = temp;

        return vehicles;
    }

    public int getCount() {

        int c = 0;

        for (int i = 0; i < vehicles.length; i++) {

            if (vehicles[i] != null) c++;
        }

        return c;
    }

    public int lookupVehicle(Route route) {

        for (int i = 0; i < getCount(); i++) {

            if (route == vehicles[i].getRoute()) {

                return i;
            }
        }

        return -1;
    }

    public int getAvailableBus() {

        return bus;
    }

    public int getAvailablePlane() {

        return plane;
    }
}