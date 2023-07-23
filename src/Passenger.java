/**
* The Passenger class represents a passenger who can travel a certain distance using different vehicles.
* The passenger has a total distance to travel and the distance traveled.
*/
public class Passenger {
    
    /**
    * Constructs a Passenger object with the given total distance to travel.
    *
    * @param km The total distance to travel in kilometers.
    */
    public Passenger (int km) {
        distance = km;
    }
    
    /**
    * Get the distance the passenger needs to travel.
    *
    * @return The distance in kilometers.
    */
    public int getDistance() {
        return distance;
    }
    
    /**
    * Get the distance traveled by the passenger.
    *
    * @return The distance traveled in kilometers.
    */
    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    /**
    * Calculates the remaining distance and the distance traveled.
    *
    * @param km The distance traveled in kilometers.
    */
    public void travel(int km) {
        distance -= km;
        distanceTraveled += km;
    }

    private int distanceTraveled;
    private int distance;
}
