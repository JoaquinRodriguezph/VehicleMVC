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
                case 2:
                case 3:
                    System.out.println();
            }
        }

    }
}