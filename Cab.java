import java.util.Scanner;

//* Created an abstract class which will serve as a base class */
//*  The base class Vehicle provides a general abstraction for all vehicles.*/
//* The method `getFareForTheCharge` is defined here and is reused by all subclasses.*/
//* This ensures that all subclasses can be treated as a Vehicle, adhering to LSP. */
abstract class Vehicle {
    protected Double baseCharge;
    protected Double chargesForTheNext15km;
    protected Double additionalDistanceCharge;
    protected Double userEnteredInput;

    public static int totalRides = 0;
    public static double totalFareCollected = 0.00;

    private final FareCalculator fareCalculator;

    //* The constructor accepts a FareCalculator object, promoting flexibility. */
    //* Subclasses can provide their specific FareCalculator implementations. */
    protected Vehicle(FareCalculator fareCalculator, Double userEnteredInput) {
        this.fareCalculator = fareCalculator;
        this.userEnteredInput = userEnteredInput;
        totalRides++;
    }

    public static void displayUserHistory(){
        System.out.println("Total Rides till Now. " + totalRides);
        System.out.println("Total Fare Collected till Now. " + totalFareCollected + " INR.");
    }

    //* The method `getFareForTheCharge` is defined in the base class but depends */
    //* on the FareCalculator interface. This ensures that the behavior can vary */
    //* based on the subclass while maintaining a consistent interface. */
    public Double getFareForTheCharge() {
        Double fare = fareCalculator.calculateFare(userEnteredInput);
        totalFareCollected += fare;
        return fare;
    }
}

//* The FareCalculator interface allows each subclass to define its own fare calculation logic. */
//* By introducing this interface, the base class (Vehicle) is not tightly coupled to any specific logic. */
//* This adheres to LSP, as any class implementing FareCalculator can seamlessly replace another. */
interface FareCalculator{
    Double calculateFare(Double userEnteredInput);
}


//* The MiniFareCalculator implements specific fare calculation logic for Mini vehicles. */ 
//* This adheres to LSP as Mini can be substituted anywhere Vehicle is used. */
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


//* The Mini class uses MiniFareCalculator for fare calculation. */
//* Mini can be substituted anywhere Vehicle is used because it overrides the behavior */
//* through the constructor, adhering to LSP. */
class Mini extends Vehicle {
    public Mini(Double userEnteredInput) {
        super(new MiniFareCalculator(), userEnteredInput);
    }
}
//* The SedanFareCalculator implements specific fare calculation logic for Sedan category vehicles. */ 
//* This adheres to LSP as Sedan can be substituted anywhere Vehicle is used. */
class SedanFareCalculator implements FareCalculator{
    final private Double CHARGES_FOR_THE_BASE_CASE = 80.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 12.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 10.00; //*Protected variable which can be used in the same class and the derived class */
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
            fare = CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            fare = CHARGES_FOR_THE_BASE_CASE * 5 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        return fare;
    }
}

//* The Sedan class uses SedanFareCalculator for fare calculation. */
//* Sedan can be substituted anywhere Vehicle is used because it overrides the behavior */
//* through the constructor, adhering to LSP. */
class Sedan extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public Sedan(Double userEnteredInput) {
        super(new SedanFareCalculator(), userEnteredInput);
    }

}

//* The Luxurious_SedanFareCalculator implements specific fare calculation logic for Luxurious_Sedan category vehicles. */ 
//* This adheres to LSP as Luxurious_Sedan can be substituted anywhere Vehicle is used. */
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

//* The Luxurious_Sedan class uses Luxurious_SedanFareCalculator for fare calculation. */
//* Luxurious_Sedan can be substituted anywhere Vehicle is used because it overrides the behavior */
//* through the constructor, adhering to LSP. */
class Luxurious_Sedan extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public Luxurious_Sedan(Double userEnteredInput) {
        super(new Luxurious_SedanFareCalculator(), userEnteredInput);
    }

}

//* The SUVFareCalculator implements specific fare calculation logic for SUV category vehicles. */ 
//* This adheres to LSP as SUV can be substituted anywhere Vehicle is used. */
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
//* The SUV class uses SUVFareCalculator for fare calculation. */
//* SUV can be substituted anywhere Vehicle is used because it overrides the behavior */
//* through the constructor, adhering to LSP. */
class SUV extends Vehicle {
    //* Using that initialized constructor using the super keyword */
    public SUV(Double userEnteredInput) {
        super(new SUVFareCalculator(), userEnteredInput);
    }

}

//* The OFFRoadFareCalculator implements specific fare calculation logic for OFFRoad category vehicles. */ 
//* This adheres to LSP as OFFRoad can be substituted anywhere Vehicle is used. */
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

//* The OFFRoad class uses OFFRoadFareCalculator for fare calculation. */
//* OFFRoad can be substituted anywhere Vehicle is used because it overrides the behavior */
//* through the constructor, adhering to LSP. */
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