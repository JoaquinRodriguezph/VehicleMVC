public class Jeepney extends Vehicle implements Public{
    public Jeepney(int capacity, int passengers, String startPoint, String endPoint) {
        super(capacity, passengers, startPoint, endPoint);
    }

    @Override
    public int computeFair(int km) {
        km -= 4;
        if (km < 0)
            km = 0;
        return 7 + km;
    }
}
