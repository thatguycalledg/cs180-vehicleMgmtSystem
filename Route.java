/**
 * Project 3 -- Route
 *
 * This program is a class that stores the route of travel
 * that is going to happen.
 *
 * @author Gaurang Vinayak, lab sec 19
 *
 * @version March 22, 2019
 *
 */

public class Route {

    private String from;  // The starting point of the Route
    private String to;    // The destination of the Route

    public Route(String from, String to) {

        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Route abc = (Route) obj;

        return (from.equals(abc.from) && to.equals(abc.to));
    }

    @Override
    public String toString() {

        return String.format("Route: From %s to %s\n", this.from, this.to);
    }
}