public class Bus extends Vehicle implements Public{
    public Bus(int capacity, int passengers, String startPoint, String endPoint) {
        super(capacity, passengers, startPoint, endPoint);
    }

    @Override
    public int computeFair(int km) {
        return 30;
    }
}