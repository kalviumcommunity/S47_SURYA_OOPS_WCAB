import java.util.Scanner;

//* Created an abstract class which will serve as a base class */
abstract class Vehicle {
    protected Double baseCharge;
    protected Double chargesForTheNext15km;
    protected Double additionalDistanceCharge;
    protected Double userEnteredInput;

    public static int totalRides = 0;
    public static double totalFareCollected = 0.00;

    //* created a constructor */
    protected Vehicle(Double baseCharge, Double chargesForTheNext15km, Double additionalDistanceCharge, Double userEnteredInput) {
        this.baseCharge = baseCharge;
        this.chargesForTheNext15km = chargesForTheNext15km;
        this.additionalDistanceCharge = additionalDistanceCharge;
        this.userEnteredInput = userEnteredInput;
        totalRides++;
    }

    public static void displayUserHistory(){
        System.out.println("Total Rides till Now. " + totalRides);
        System.out.println("Total Fare Collected till Now. " + totalFareCollected + " INR.");
    }

    //* Creating a method which will have there own implementation in the derived class by using polymorphism  */
    public abstract Double getFareForTheCharge();
}

//* Implemented encapsulation by wrapping method and variables in the same class */
//* Implemented Multilevel inheritance by using the property of the base Vehicle class */ 
class Mini extends Vehicle {
    final private Double CHARGES_FOR_THE_BASE_CASE = 50.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 10.00; 
    final private Double OTHER_DISTANCE_CHARGES = 8.00; 
    private Double otherFifteenKm;
    private Double restDistance;
        
    //* Using that initialized constructor using the super keyword */
    public Mini(Double userEnteredInput) {
        super(50.00, 10.00, 8.00, userEnteredInput);
    }

    //*  Accessor for userEnteredInput */
    public Double getUserEnteredInput() {
        return userEnteredInput; 
    }

    //*  Mutator for userEnteredInput */
    public void setUserEnteredInput(Double userEnteredInput) {
        this.userEnteredInput = userEnteredInput;
    }

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    @Override
    public Double getFareForTheCharge() {
        double fare;
        if(userEnteredInput >= 75){
            fare = OTHER_DISTANCE_CHARGES * userEnteredInput;
        }else if (userEnteredInput <= 3) {
            fare = CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 18) {
            otherFifteenKm = userEnteredInput - 3;
            fare = CHARGES_FOR_THE_BASE_CASE * 3  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 18;
            fare = CHARGES_FOR_THE_BASE_CASE * 3 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
        totalFareCollected += fare;
        return  fare;
    }
}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Hierarchial inheritance by using the property of one of the Derived Mini class */
class Sedan extends Mini {

    final private Double CHARGES_FOR_THE_BASE_CASE = 80.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 12.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 10.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    //* Using that initialized constructor using the super keyword */

    public Sedan(Double userEnteredInput) {
        super(userEnteredInput);
    }

    //*  Accessor for userEnteredInput */
    public Double getUserEnteredInput() {
        return userEnteredInput; 
    }

    //*  Mutator for userEnteredInput */
    public void setUserEnteredInput(Double userEnteredInput) {
        this.userEnteredInput = userEnteredInput;
    }

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    @Override
    public Double getFareForTheCharge() {
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
        totalFareCollected += fare;
        return fare;
    }

}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Hierarchial inheritance by using the property of one of the Derived Mini class */
class Luxurious_Sedan extends Vehicle {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 25.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 25.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    //* Using that initialized constructor using the super keyword */
    public Luxurious_Sedan(Double userInputForLuxuriousSedan) {
        super(100.00, 25.00, 25.00, userInputForLuxuriousSedan);
    }

    //*  Accessor for userEnteredInput */
    public Double getUserEnteredInput() {
        return userEnteredInput; 
    }

    //*  Mutator for userEnteredInput */
    public void setUserEnteredInput(Double userEnteredInput) {
        this.userEnteredInput = userEnteredInput;
    }

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    @Override
    public Double getFareForTheCharge() {
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
        totalFareCollected += fare;
        return fare;
    }

}

//* Implemented encapsulation by wrapping method and variables in the same class */
//* Implemented Multilevel inheritance by using the property of base Vehicle class */
class SUV extends Vehicle {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 15.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 12.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    //* Using that initialized constructor using the super keyword */
    public SUV(Double userEnteredInput) {
        super(100.00, 15.00, 12.00, userEnteredInput);
    }

    //*  Accessor for userEnteredInput */
    public Double getUserEnteredInput() {
        return userEnteredInput; 
    }

    //*  Mutator for userEnteredInput */
    public void setUserEnteredInput(Double userEnteredInput) {
        this.userEnteredInput = userEnteredInput;
    }

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    @Override
    public Double getFareForTheCharge() {
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
        totalFareCollected += fare;
        return fare;
    }

}

//* Implemented encapsulation by wrapping method and variables in the same class */ 
//* Implemented Multilevel inheritance by using the property of base Vehicle class */
class OFFRoad extends Vehicle {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double CHARGES_FOR_THE_NEXT_15KM = 20.00; //*Protected variable which can be used in the same class and the derived class */
    final private Double OTHER_DISTANCE_CHARGES = 25.00; //*Protected variable which can be used in the same class and the derived class */
    private Double otherFifteenKm;
    private Double restDistance;

    //* Using that initialized constructor using the super keyword */
    public OFFRoad(Double userEnteredInput) {
        super(100.00, 20.00, 25.00, userEnteredInput);
    }

    //*  Accessor for userEnteredInput */
    public Double getUserEnteredInput() {
        return userEnteredInput; 
    }

    //*  Mutator for userEnteredInput */
    public void setUserEnteredInput(Double userEnteredInput) {
        this.userEnteredInput = userEnteredInput;
    }

    // * Using the concept of Run time polymorphism and creating a function which will be created during the run time  */
    @Override
    public Double getFareForTheCharge() {
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
        totalFareCollected += fare;
        return fare;
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