import java.util.ArrayList;

public class Helicopter extends Vehicle implements Private {
    public Helicopter(int capacity, int passengers, String startPoint, String endPoint) {
        super(capacity, passengers, startPoint, endPoint);
    }

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
