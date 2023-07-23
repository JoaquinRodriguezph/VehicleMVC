import java.util.ArrayList;

/**
 * The Jeepney class represents a public vehicle that extends the Vehicle class and implements the Public interface.
 * It provides methods to compute the fare for passengers traveling on the jeepney.
 */
public class Jeepney extends Vehicle implements Public{

    /**
    * Constructs a Jeepney object with the given travelled starting point and ending point.
    *
    * @param startPoint The starting point of the Jeepney's travelled distance.
    * @param endPoint   The end point of the Jeepney's travelled distance.
    */
    public Jeepney(String startPoint, String endPoint) {
        super(20, startPoint, endPoint);
    }

    /**
     * Computes the fare for passengers traveling on the jeepney for a given distance.
     * The fare is P7 for the first 4 kilometers, and an additional P1 for every extra kilometer.
     *
     * @param km The distance traveled by the jeepney in kilometers.
     * @return The total fare charged for all passengers on the jeepney.
     */
    @Override
    public int computeFair(int km) {
        int sum = 0;

        ArrayList<Passenger> passengerArrayList = new ArrayList<Passenger>();
        for (Passenger p : passengers) {
            if (p.getDistanceTraveled() == 0) //assuming the jeepney can't travel 0km
                sum += 7;

            int localDistance;

            if (km > p.getDistance()) {
                localDistance = p.getDistance();
                p.travel(localDistance);
            }
            else {
                localDistance = km;
                p.travel(localDistance);
            }



            if (p.getDistanceTraveled() > 4) {
                if (p.getDistanceTraveled() - localDistance <= 4)
                    sum += localDistance - (4 - (p.getDistanceTraveled() - localDistance));
                else
                    sum += localDistance;
            }

            if (p.getDistance() > 0)
                passengerArrayList.add(p);
        }
        passengers = passengerArrayList;

        return sum;
    }
}
