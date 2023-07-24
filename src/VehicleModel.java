import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VehicleModel {
    private ArrayList<Vehicle> vehicleList;

    public VehicleModel(){this.vehicleList = new ArrayList<Vehicle>();}

    public boolean addVehicle(String startpoint, String endpoint, String choice1){
        boolean result = false;
        int choice = Integer.parseInt(choice1);
        switch (choice){
            case 1 -> {
                try{
                    vehicleList.add(new Bus(startpoint, endpoint));
                    result = true;
                }
                catch (Exception e){

                }
            }
            case 2 -> {
                try{
                    vehicleList.add(new Jeepney(startpoint,endpoint));
                    result = true;
                }
                catch (Exception e){

                }
            }
            case 3 -> {
                try{
                    vehicleList.add(new Helicopter(startpoint,endpoint));
                    result = true;
                }
                catch (Exception e){

                }
            }
            default -> {

            }
        }

        return result;
    }



}
