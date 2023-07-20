public class Passenger {
    public Passenger (int km) {
        distance = km;
    }

    public int getDistance() {
        return distance;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void travel(int km) {
        distance -= km;
        distanceTraveled += km;
    }

    private int distanceTraveled;
    private int distance;
}
