import java.util.Scanner;

//* Created an abstract class which will serve as a base class */
abstract class Vehicle {
    protected Double baseCharge;
    protected Double chargesForTheNext15km;
    protected Double additionalDistanceCharge;
    protected Double userEnteredInput;

    public static int totalRides = 0;
    public static double totalFareCollected = 0.00;

    private final FareCalculator fareCalculator;

    //* created a constructor */
    protected Vehicle(FareCalculator fareCalculator, Double userEnteredInput) {
        this.fareCalculator = fareCalculator;
        this.userEnteredInput = userEnteredInput;
        totalRides++;
    }

    public static void displayUserHistory(){
        System.out.println("Total Rides till Now. " + totalRides);
        System.out.println("Total Fare Collected till Now. " + totalFareCollected + " INR.");
    }

    //* Creating a method which will have there own implementation in the derived class by using polymorphism  */
    //* This method will be serving as a virtual method */
    public Double getFareForTheCharge() {
        Double fare = fareCalculator.calculateFare(userEnteredInput);
        totalFareCollected += fare;
        return fare;
    }
}

//* Creating an interface for Fare calculation */
interface FareCalculator{
    Double calculateFare(Double userEnteredInput);
}


//* Creating a Separate class to calculate the fare for the Mini Class */
class MiniFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 50.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 10.00; 
    final private Double OTHER_DISTANCE_CHARGES = 8.00; 

    @Override
    public Double calculateFare(Double userEnteredInput) {
        double fare;
        if (userEnteredInput >= 75) {
            fare = OTHER_DISTANCE_CHARGES * userEnteredInput;
        } else if (userEnteredInput <= 3) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 18) {
            double otherFifteenKm = userEnteredInput - 3;
            fare = CHARGES_FOR_THE_BASE_CASE * 3 + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            double restDistance = userEnteredInput - 18;
            fare = CHARGES_FOR_THE_BASE_CASE * 3 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}


//* Implemented encapsulation by wrapping method and variables in the same class */
//* Implemented Multilevel inheritance by using the property of the base Vehicle class */ 
class Mini extends Vehicle {
    public Mini(Double userEnteredInput) {
        super(new MiniFareCalculator(), userEnteredInput);
    }
}

//* Similarly creating a separate class class to calculate the fare for the Mini Class */
class SedanFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 80.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 12.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 10.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    //* Using the concept of Virtual function and overriding this method in the derived class */
    @Override
    public Double calculateFare(Double userEnteredInput) {
        double fare;
        if(userEnteredInput >= 100){
            fare = OTHER_DISTANCE_CHARGES * userEnteredInput;
        } else if (userEnteredInput <= 5) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            fare = CHARGES_FOR_THE_BASE_CASE * 5 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Hierarchial inheritance by using the property of one of the Derived Mini class */
class Sedan extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public Sedan(Double userEnteredInput) {
        super(new SedanFareCalculator(), userEnteredInput);
    }

}

//* Similarly creating a Separate class to calculate the fare for the Mini Class */
class Luxurious_SedanFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 25.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 25.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance; 

    @Override
    public Double calculateFare(Double userEnteredInput) {
        double fare;
        if(userEnteredInput >= 100){
            fare = OTHER_DISTANCE_CHARGES * userEnteredInput;
        } else if (userEnteredInput <= 5) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            fare = CHARGES_FOR_THE_BASE_CASE * 5 + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Hierarchial inheritance by using the property of one of the Derived Mini class */
class Luxurious_Sedan extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public Luxurious_Sedan(Double userEnteredInput) {
        super(new Luxurious_SedanFareCalculator(), userEnteredInput);
    }

}

//* Similarly creating a Separate class to calculate the fare for the SUV Class */
class SUVFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 15.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 12.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    @Override
    public Double calculateFare(Double userEnteredInput) {
        double fare;
        if (userEnteredInput <= 5) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}
//* Implemented encapsulation by wrapping method and variables in the same class */
//* Implemented Multilevel inheritance by using the property of base Vehicle class */
class SUV extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public SUV(Double userEnteredInput) {
        super(new SUVFareCalculator(), userEnteredInput);
    }

}

//* Similarly creating a Separate class to calculate the fare for the OFFRoad Class */
class OFFRoadFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 20.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 25.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    @Override
    public Double calculateFare(Double userEnteredInput) {
        double fare;
        if (userEnteredInput <= 5) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Multilevel inheritance by using the property of base Vehicle class */
class OFFRoad extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public OFFRoad(Double userEnteredInput) {
        super(new OFFRoadFareCalculator(), userEnteredInput);
    }

}

public class Cab {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("<---------------------------------------------->");
        System.out.println("Welcome to WCAB Services!!");
        System.out.println("Enter the total No. of Customers traveling and press enter to continue.");
        int totalUserInput = reader.nextInt();
        reader.nextLine(); 
        Vehicle[] cabs = new Vehicle[totalUserInput];

        for (int i = 0; i < totalUserInput; i++) {
            System.out.println("Select the category of Vehicle for customer " + (i + 1) + ":");
            System.out.println("1.Sedan, 2.Suv, 3.OFF Road");
            String user_Selected_Category = reader.nextLine();
            
            switch (user_Selected_Category) {
                case "1":
                    System.out.println("Choose your Sub-category of Sedans:");
                    System.out.println("1.Mini Sedan, 2.City Sedan, 3.Luxurious Sedan");
                    String user_Selected_Subcategory_Sedan = reader.nextLine();

                    switch (user_Selected_Subcategory_Sedan) {
                        case "1":
                            System.out.println("Enter the total expected distance for Mini Sedan: ");
                            Double userInputForMiniSedan = reader.nextDouble();
                            reader.nextLine(); 
                            cabs[i] = new Mini(userInputForMiniSedan); // Implementing dynamic memory creation using the new keyword  for mini sedan cab
                            break;
                        case "2":
                            System.out.println("Enter the total expected distance for City Sedan: ");
                            Double userInputForCitySedan = reader.nextDouble();
                            reader.nextLine(); 
                            cabs[i] = new Sedan(userInputForCitySedan); // Implementing dynamic memory creation using the new keyword  for city sedan cab
                            break;
                        case "3":
                            System.out.println("Enter the total expected distance for Luxurious Sedan: ");
                            Double userInputForLuxuriousSedan = reader.nextDouble();
                            reader.nextLine(); 
                            cabs[i] = new Luxurious_Sedan(userInputForLuxuriousSedan); // Implementing dynamic memory creation using the new keyword  for Luxurious sedan
                            break;
                        default:
                            System.out.println("Invalid Category Selected");
                            i--;  
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Enter the total expected distance for SUV: ");
                    Double userInputForSUV = reader.nextDouble();
                    reader.nextLine(); 
                    cabs[i] = new SUV(userInputForSUV); // Implementing dynamic memory creation using the new keyword  for SUV Class
                    break;
                case "3":
                    System.out.println("Enter the total expected distance for OFF Road: ");
                    Double userInputOFFRoad = reader.nextDouble();
                    reader.nextLine(); 
                    cabs[i] = new OFFRoad(userInputOFFRoad); // Implementing dynamic memory creation using the new keyword  for OFF Road Class
                    break;
                default:
                    System.out.println("Invalid Category Selected");
                    i--;  
                    break;
            }
        }

        System.out.println("Total Fare Calculations:");
        for (int j = 0; j < totalUserInput; j++) {
            System.out.println("Customer " + (j + 1) + " fare: " + cabs[j].getFareForTheCharge() + " INR.");
        }
        Vehicle.displayUserHistory();
        System.out.println("<---------------------------------------------->");
        reader.close();
    }
}