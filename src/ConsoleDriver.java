import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleDriver {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("How many vehicles would you like to create? ");
        int numofvehicles = 0;
        try{
            numofvehicles = sc.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("Invalid type. Please enter an integer.");
            return;
        }

        for (int i = 0; i < numofvehicles; i++){
            System.out.println("Please choose type of vehicle: ");
            System.out.println("1 - Bus");
            System.out.println("2 - Jeepney");
            System.out.println("3 - Helicopter");
            int choice = 0;
            try{
                choice = sc.nextInt();
            }
            catch(InputMismatchException e){
                System.out.println("Please input only from 1 to 4");
            }
            System.out.println("Enter the capacity of the vehicle: ");
            int capacity = sc.nextInt();
            System.out.println("Enter the number of passengers: ");
            int passengerCount = sc.nextInt();
            System.out.println("Enter the start point: ");
            String startPoint = sc.next();
            System.out.println("Enter the end point");
            String endPoint = sc.next();

            switch (choice){
                case 1:
                    System.out.println("You created a Bus");
                    vehicles.add(new Bus(capacity, passengers, startPoint, endPoint));
                    break;
                case 2:
                    System.out.println("You created a Jeepney");
                    vehicles.add(new Jeepney(capacity, passengers, startPoint, endPoint));
                    break;
                case 3:
                    System.out.println("You created a Helicopter");
                    vehicles.add(new Helicopter(capacity, passengers, startPoint, endPoint));
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    i--;
            }
        }

        System.out.println("\nVehicle Information:\n");
        for (Vehicle vehicle : vehicles) {
            System.out.println("Type: " + );
            System.out.println("Capacity: " + vehicle.getCapacity());
            System.out.println("Start Point: " + vehicle.getStartPoint());
            System.out.println("End Point: " + vehicle.getEndPoint());


            System.out.println();
        }
    }
}
