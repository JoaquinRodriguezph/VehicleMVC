import java.util.ArrayList;

public class Jeepney extends Vehicle implements Public{
    public Jeepney(String startPoint, String endPoint) {
        super(20, startPoint, endPoint);
    }

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
