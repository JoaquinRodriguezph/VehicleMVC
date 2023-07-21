import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleDriver {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many vehicles would you like to create? ");
        int option = -1;

        while (option != 0){
            System.out.println("=====Vehicle Menu=====");
            System.out.println("0 - Exit");
            System.out.println("1 - Bus");
            System.out.println("2 - Jeepney");
            System.out.println("3 - Helicopter");
            System.out.println("4 - Show All Vehicles");
            System.out.println("5 - Choose Vehicle (travel)");
            try{
                option = sc.nextInt();
                if (option < 0 || option > 4)

                System.out.println("Enter the start point: ");
                String startPoint = sc.next();
                System.out.println("Enter the end point");
                String endPoint = sc.next();

                switch (option){
                    case 1:
                        System.out.println("You created a Bus");
                        vehicles.add(new Bus(startPoint, endPoint));
                        break;
                    case 2:
                        System.out.println("You created a Jeepney");
                        vehicles.add(new Jeepney(startPoint, endPoint));
                        break;
                    case 3:
                        System.out.println("You created a Helicopter");
                        vehicles.add(new Helicopter(startPoint, endPoint));
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Please input only from 1 to 4");
            }

        }

        System.out.println("\nVehicle Information:\n");
        for (Vehicle vehicle : vehicles) {
            String type;
            if (vehicle instanceof Jeepney)
                type = "Jeepney";
            else if (vehicle instanceof Helicopter)
                type = "Helicopter";
            else if (vehicle instanceof Bus)
                type = "Bus";
            System.out.println("Type: " + type);
            System.out.println("Capacity: " + vehicle.getCapacity());
            System.out.println("Start Point: " + vehicle.getStartPoint());
            System.out.println("End Point: " + vehicle.getEndPoint());


            System.out.println();
        }
    }
}
