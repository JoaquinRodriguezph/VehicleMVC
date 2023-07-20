public abstract class Vehicle {
    protected Vehicle(int capacity, int passengers, String startPoint, String endPoint) {
        this.CAPACITY = capacity;
        this.passengers = passengers;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getCapacity() {
        return CAPACITY;
    }

    public int getPassengers() {
        return passengers;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    private final int CAPACITY;
    private String startPoint;
    private String endPoint;
    private int passengers;
}
