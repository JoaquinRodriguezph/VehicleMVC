public class Main {
    public static void main(String[] args) {
        VehicleView vehicleView = new VehicleView();
        VehicleModel vehicleModel = new VehicleModel();
        VehicleController vehicleController = new VehicleController(vehicleView, vehicleModel);
    }
}
