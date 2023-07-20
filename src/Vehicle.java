public abstract class Vehicle {
    protected Vehicle(int capacity, int passengers) {
        this.CAPACITY = capacity;
        this.passengers = passengers;
    }
    private final int CAPACITY;
    private String startPoint;
    private String endPoint;
    private int passengers;
}
