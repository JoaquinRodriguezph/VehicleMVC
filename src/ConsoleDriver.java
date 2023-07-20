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

    }
}