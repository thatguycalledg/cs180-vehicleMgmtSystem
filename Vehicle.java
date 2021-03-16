/**
 * Project 3 -- Vehicle
 *
 * This program is an interface that ties
 * together both the bus and the airplanes stored.
 *
 * @author Gaurang Vinayak, lab sec 19
 *
 * @version March 22, 2019
 *
 */

interface Vehicle {

    public int getCapacity();

    public Route getRoute();

    public int getCount();

    public Passenger[] getPassengers();

    public boolean addPassenger(Passenger person, boolean waitingList);

    public boolean addPassenger(Passenger person);

    public Vehicle upgrade(int newCapacity);
}
