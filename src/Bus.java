import java.util.ArrayList;

public class Bus extends Vehicle implements Public{
    public Bus(int capacity, int passengers, String startPoint, String endPoint) {
        super(capacity, passengers, startPoint, endPoint);
    }

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