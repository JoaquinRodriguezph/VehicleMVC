import java.util.ArrayList;

public abstract class Vehicle {
    protected Vehicle(int capacity, int passengers, String startPoint, String endPoint) {
        this.CAPACITY = capacity;
        this.passengers = new ArrayList<Passenger>();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public boolean addPassenger(Passenger passenger) {
        boolean b = passengers.size() < CAPACITY;

        if (b)
            passengers.add(passenger);

        return b;
    }

    protected final int CAPACITY;
    protected String startPoint;
    protected String endPoint;
    protected ArrayList<Passenger> passengers;
}
