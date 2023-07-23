import java.util.ArrayList;

/**
 * The abstract Vehicle class represents a general vehicle that can carry passengers.
 * It defines the common properties and methods for all types of vehicles.
 */
public abstract class Vehicle {

    /**
    * Constructs a Vehicle object with the given capacity, start point, and end point.
    *
    * @param capacity    The maximum capacity of passengers that the vehicle can carry.
    * @param startPoint  The starting point of the vehicle's travel distance.
    * @param endPoint    The ending point of the vehicle's travel distance.
    */
    protected Vehicle(int capacity, String startPoint, String endPoint) {
        this.CAPACITY = capacity;
        this.passengers = new ArrayList<Passenger>();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    /**
     * Gets the maximum capacity of passengers that the vehicle can carry.
     *
     * @return The capacity of the vehicle.
     */
    public int getCapacity() {
        return CAPACITY;
    }

    /**
     * Gets the ending point of the vehicle.
     *
     * @return The ending point of the vehicle.
     */
    public String getEndPoint() {
        return endPoint;
    }

    /**
     * Gets the starting point of the vehicle.
     *
     * @return The starting point of the vehicle.
     */
    public String getStartPoint() {
        return startPoint;
    }


    /**
     * Gets the list of passengers currently on the vehicle.
     *
     * @return An ArrayList containing the passengers on the vehicle.
     */
    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Checks if the vehicle is full, all passenger seats are occupied.
     *
     * @return True if the vehicle is full, false otherwise.
     */
    public boolean isFull() {
        return CAPACITY == passengers.size();
    }

    /**
     * Checks if the vehicle is empty, there are no passengers on board.
     *
     * @return True if the vehicle is empty, false otherwise.
     */
    public boolean isEmpty() {
        return passengers.size() == 0;
    }

    /**
     * Adds a passenger to the vehicle if there is available space.
     *
     * @param passenger The Passenger object to be added to the vehicle.
     * @return True if the passenger was added successfully, false otherwise.
     */
    public boolean addPassenger(Passenger passenger) {
        boolean b = !isFull();

        if (b)
            passengers.add(passenger);

        return b;
    }

    /**
     * The maximum capacity of passengers that the vehicle can carry.
     */
    protected final int CAPACITY;
    /**
     * The starting point of the vehicle
     */
    protected String startPoint;
    /**
     * The ending point of the vehicle
     */
    protected String endPoint;
    /**
     * The list of passengers currently on the vehicle.
     */
    protected ArrayList<Passenger> passengers;
}
