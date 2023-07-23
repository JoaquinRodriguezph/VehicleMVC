import java.util.ArrayList;

/**
* The Helicopter class represents a helicopter that extends the Vehicle class and implements the Private interface.
* It provides methods to find the travel distance for passengers traveling on the helicopter.
*/
public class Helicopter extends Vehicle implements Private {

    /**
    * Constructs a Helicopter object with the given travelled starting point and ending point.
    *
    * @param startPoint The starting point of the helicopter's travelled distance.
    * @param endPoint   The end point of the helicopter's travelled distance.
    */
    public Helicopter(String startPoint, String endPoint) {
        super(3, startPoint, endPoint);
    }

    /**
    * Travels a certain distance in kilometers by the helicopter and updates the distance traveled for each passenger.
    *
    * @param km The distance traveled by the helicopter in kilometers.
    */
    @Override
    public void travel(int km) {
        ArrayList<Passenger> passengerArrayList = new ArrayList<Passenger>();
        for (Passenger p : passengers) {
            p.travel(km);
            if (p.getDistance() > 0)
                passengerArrayList.add(p);
        }
        passengers = passengerArrayList;
    }
}
