import java.util.*;


public class ConsoleDriver {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int option = -1;

        while (option != 0){
            System.out.println("=====Vehicle Menu=====");
            System.out.println("0 - Exit");
            System.out.println("1 - Create Vehicle");
            System.out.println("2 - Delete Vehicle");
            System.out.println("3 - Show All Vehicles");
            System.out.println("4 - Choose Vehicle Action");
            try{
                option = sc.nextInt();
                if (option < 0 || option > 4)
                    throw new IllegalArgumentException("Invalid Option");

                switch(option) {
                    case 1 -> {
                        int vehicleOpt = -1;
                        while (vehicleOpt != 0) {
                            try {
                                System.out.println("=====Create Vehicle=====");
                                System.out.println("0 - Back");
                                System.out.println("1 - Bus");
                                System.out.println("2 - Jeepney");
                                System.out.println("3 - Helicopter");
                                vehicleOpt = sc.nextInt();
                                if (vehicleOpt < 0 || vehicleOpt > 3)
                                    throw new IllegalArgumentException("Invalid Option");
                                else if (vehicleOpt > 0) {
                                    System.out.println("Enter the start point: ");
                                    String startPoint = sc.next();
                                    System.out.println("Enter the end point");
                                    String endPoint = sc.next();

                                    switch (vehicleOpt) {
                                        case 1 -> {
                                            System.out.println("You created a Bus");
                                            vehicles.add(new Bus(startPoint, endPoint));
                                        }
                                        case 2 -> {
                                            System.out.println("You created a Jeepney");
                                            vehicles.add(new Jeepney(startPoint, endPoint));
                                        }
                                        case 3 -> {
                                            System.out.println("You created a Helicopter");
                                            vehicles.add(new Helicopter(startPoint, endPoint));
                                        }
                                    }
                                }
                            }
                            catch (Exception e) {
                                if (e instanceof InputMismatchException)
                                    sc.nextLine();
                                System.out.println(e.toString());
                            }
                        }
                    }
                    case 2 -> {
                        int deleteOption = -1;
                        boolean delete = false;
                        while (deleteOption != 0) {
                            try {
                                if (vehicles.size() == 0) {
                                    deleteOption = 0;
                                    System.out.println("No Available Vehicles to Delete");
                                }
                                else {

                                    showVehicle(vehicles);

                                    System.out.print("0 - Back\nChoose Vehicle: ");
                                    deleteOption = sc.nextInt();

                                    if (deleteOption < 0 || deleteOption > vehicles.size())
                                        throw new IllegalArgumentException("Invalid Choice");
                                    else if (deleteOption > 0)
                                        removeVehicle(vehicles, deleteOption - 1);
                                }
                            }
                            catch(Exception e){
                                System.out.println(e.toString());
                            }
                        }
                    }
                    case 3 -> {
                        try {
                            if (vehicles.size() == 0) {
                                System.out.println("No Available Vehicles to be Shown");
                            }
                            else
                                showVehicle(vehicles);
                        }
                        catch (Exception e) {
                            System.out.println(e.toString());
                            if (e instanceof InputMismatchException)
                                sc.nextLine();
                        }
                    }
                    case 4 -> {
                        int actionChoice = -1;



                        while (actionChoice != 0) {
                            try {
                                if (vehicles.size() == 0) {
                                    actionChoice = 0;
                                    System.out.println("No Available Vehicles");
                                }
                                else {

                                    showVehicle(vehicles);


                                    System.out.print("0 - Back\nChoose Vehicle: ");
                                    actionChoice = sc.nextInt();

                                    if (actionChoice < 0 || actionChoice > vehicles.size())
                                        throw new IllegalArgumentException("Invalid Choice");

                                    int vehicleChoice = actionChoice;
                                    Vehicle vehicle = vehicles.get(vehicleChoice - 1);
                                    while (actionChoice != 0) {
                                        System.out.println("=====Vehicle Action - (" + vehicleChoice + ") " + vehicleSTR(vehicle) + " ======");
                                        System.out.println("0 - Back");
                                        System.out.println("1 - Add Passenger");
                                        System.out.println("2 - Travel (km)");
                                        System.out.println("3 - Show Vehicle Details");
                                        try {
                                            actionChoice = sc.nextInt();

                                            if (actionChoice > 3 || actionChoice < 0)
                                                throw new IllegalArgumentException("Invalid Option");

                                            switch (actionChoice) {
                                                case 1 -> {
                                                    try {
                                                        if (vehicle.isFull()) {
                                                            System.out.println("The " + vehicleSTR(vehicle) + " is at full capacity");
                                                            break;
                                                        }
                                                        int distance;

                                                        System.out.print("Passenger Travel Distance: ");
                                                        distance = sc.nextInt();
                                                        if (distance <= 0)
                                                            throw new IllegalArgumentException("Distance Cannot be Less than or Equal to 0");
                                                        if (vehicle.addPassenger(new Passenger(distance)))
                                                            System.out.println("New Passenger Added to the " + vehicleSTR(vehicle));
                                                        else
                                                            System.out.println("Passenger Cannot be Added to the " + vehicleSTR(vehicle));
                                                    } catch (Exception e) {
                                                        if (e instanceof InputMismatchException)
                                                            sc.nextLine();
                                                        System.out.println(e.toString());
                                                    }

                                                }
                                                case 2 -> {
                                                    //travel code - computes fair at vehicle traveling at km distance
                                                    try {
                                                        int distance;

                                                        System.out.print("0 - Back\nDistance to Travel: ");
                                                        distance = sc.nextInt();
                                                        if (distance == 0)
                                                            break;
                                                        if (distance < 0)
                                                            throw new IllegalArgumentException("Distance Can't be Negative");
                                                        else {
                                                            int ePassengers, iPassengers = vehicle.getPassengers().size();
                                                            System.out.println("Number of Passengers: " + iPassengers);
                                                            System.out.println("Traveling...");
                                                            if (vehicle instanceof Public) {
                                                                if (vehicle instanceof Jeepney) {
                                                                    Jeepney spec = (Jeepney) vehicle;
                                                                    System.out.println("Travel Fare (" + distance + " KM) : " + spec.computeFair(distance) + " PHP");
                                                                } else {
                                                                    Bus spec = (Bus) vehicle;
                                                                    System.out.println("Travel Fare (" + distance + " KM) : " + spec.computeFair(distance) + " PHP");
                                                                }
                                                            } else if (vehicle instanceof Private) {
                                                                Helicopter spec = (Helicopter) vehicle;
                                                                spec.travel(distance);
                                                            }
                                                            ePassengers = vehicle.getPassengers().size();

                                                            System.out.println("Travel Done!");
                                                            if (ePassengers == iPassengers)
                                                                System.out.println("No Passengers Has Gotten Off The " + vehicleSTR(vehicle));
                                                            else
                                                                System.out.println((iPassengers - ePassengers) + " Passenger/s Have Gotten Off The " + vehicleSTR(vehicle));
                                                            System.out.println("Current Number of Passengers in the " + vehicleSTR(vehicle) + ": " + ePassengers);

                                                        }
                                                    } catch (Exception e) {
                                                        if (e instanceof InputMismatchException)
                                                            sc.nextLine();
                                                        System.out.println(e.toString());
                                                    }
                                                }
                                                case 3 -> {
                                                    showVehicle(vehicle);
                                                }
                                            }
                                        } catch (Exception e) {
                                            if (e instanceof InputMismatchException)
                                                sc.nextLine();
                                            System.out.println(e.toString());
                                        }
                                    }
                                }
                            }
                            catch (Exception e) {
                                if (e instanceof InputMismatchException)
                                    sc.nextLine();
                                System.out.println(e.toString());
                            }
                        }
                    }
                }
            }
            catch(Exception e){
                if (e instanceof InputMismatchException)
                    sc.nextLine();
                System.out.println(e.toString());
            }

        }
    }

    public static void showVehicle(ArrayList<Vehicle> vehicles) throws IndexOutOfBoundsException{
        int count = 0;

        System.out.println("=====Vehicle Information=====");
        for (Vehicle vehicle : vehicles) {
            count++;
            System.out.println("===== (" + count + ") =====");
            showVehicle(vehicle);
        }
    }

    public static void showVehicle(Vehicle vehicle) {
        System.out.println("Type: " + vehicleSTR(vehicle));
        System.out.println("Capacity: " + vehicle.getCapacity());
        System.out.println("Start Point: " + vehicle.getStartPoint());
        System.out.println("End Point: " + vehicle.getEndPoint());
        System.out.println("Number of Passengers: " + vehicle.getPassengers().size());
    }

    public static String vehicleSTR(Vehicle vehicle) {
        String type = "Vehicle";
        if (vehicle instanceof Jeepney)
            type = "Jeepney";
        else if (vehicle instanceof Helicopter)
            type = "Helicopter";
        else if (vehicle instanceof Bus)
            type = "Bus";

        return type;
    }

    public static void removeVehicle(ArrayList<Vehicle> vehicles, int index) throws IndexOutOfBoundsException{

        vehicles.remove(index);

    }

}
