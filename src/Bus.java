import java.util.ArrayList;
/**
 * The Bus class represents a bus that extends the Vehicle class and implements the Public interface.
 * It provides methods to compute the fare for passengers traveling on the bus.
 */
public class Bus extends Vehicle implements Public{
    /**
    * Constructs a Bus object with the given travelled starting point and ending point.
    *
    * @param startPoint The starting point of the bus's travelled distance.
    * @param endPoint   The end point of the bus's travelled distance.
    */
    public Bus(String startPoint, String endPoint) {
        super(30, startPoint, endPoint);
    }
    
    /**
    * Computes the fare for passengers traveling on the bus for a given distance.
    * Passengers who travelled on a bus will be charged a flat fee of 30.
    * Passengers who travelled on a bus will be charged based on their traveled distance.
    *
    * @param km The distance traveled by the bus in kilometers.
    * @return The total fare charged for all passengers on the bus.
    */
    @Override
    public int computeFair(int km) {
        int sum = 0;
        ArrayList<Passenger> passengerArrayList = new ArrayList<Passenger>();
        for (Passenger p : passengers) {
            if (p.getDistanceTraveled() == 0) //assuming bus can't travel 0 km
                sum += 30;
            p.travel(km);
            if (p.getDistance() > 0)
                passengerArrayList.add(p);
        }
        passengers = passengerArrayList;

        return sum;
    }
}
