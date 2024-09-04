import java.util.*;

abstract class Cab {
    protected Double baseCharge;
    protected Double chargesForTheNext15km;
    protected Double additionalDistanceCharge;
    protected Double userEnteredInput;
    
    public Cab(Double baseCharge, Double chargesForTheNext15km, Double additionalDistanceCharge, Double userEnteredInput) {
        this.baseCharge = baseCharge;
        this.chargesForTheNext15km = chargesForTheNext15km;
        this.additionalDistanceCharge = additionalDistanceCharge;
        this.userEnteredInput = userEnteredInput;
    }

    public abstract Double getFareForTheCharge();
}

class Mini extends Cab {
    final private Double CHARGES_FOR_THE_BASE_CASE = 50.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 10.00; 
    final private Double OTHER_DISTANCE_CHARGES = 8.00; 
    private Double otherFifteenKm;
    private Double restDistance;
        
    public Mini(Double userEnteredInput) {
        super(50.00, 10.00, 8.00, userEnteredInput);
    }

    public Double getFareForTheCharge() {
        if(userEnteredInput >= 75){
            return OTHER_DISTANCE_CHARGES * userEnteredInput;
        }else if (userEnteredInput <= 3) {
            return CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 18) {
            otherFifteenKm = userEnteredInput - 3;
            return CHARGES_FOR_THE_BASE_CASE * 3  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 18;
            return CHARGES_FOR_THE_BASE_CASE * 3 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
    }
}

class Sedan extends Cab {

    final private Double CHARGES_FOR_THE_BASE_CASE = 80.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 12.00; 
    final private Double OTHER_DISTANCE_CHARGES = 10.00; 
    private Double otherFifteenKm;
    private Double restDistance;

    public Sedan(Double userEnteredInput) {
        super(80.00, 12.00, 10.00, userEnteredInput);
    }

    public Double getFareForTheCharge() {
        if(userEnteredInput >= 100){
            return OTHER_DISTANCE_CHARGES * userEnteredInput;
        } else if (userEnteredInput <= 5) {
            return CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            return CHARGES_FOR_THE_BASE_CASE * 5 + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
    }

}


class Luxurious_Sedan extends Cab {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 25.00; 
    final private Double OTHER_DISTANCE_CHARGES = 25.00; 
    private Double otherFifteenKm;
    private Double restDistance;

    public Luxurious_Sedan(Double userInputForLuxuriousSedan) {
        super(100.00, 25.00, 25.00, userInputForLuxuriousSedan);
    }

    public Double getFareForTheCharge() {
        if(userEnteredInput >= 100){
            return OTHER_DISTANCE_CHARGES * userEnteredInput;
        } else if (userEnteredInput <= 5) {
            return CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            return CHARGES_FOR_THE_BASE_CASE * 5 + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
    }

}


class SUV extends Cab {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 15.00; 
    final private Double OTHER_DISTANCE_CHARGES = 12.00; 
    private Double otherFifteenKm;
    private Double restDistance;

    public SUV(Double userEnteredInput) {
        super(100.00, 15.00, 12.00, userEnteredInput);
    }

    public Double getFareForTheCharge() {
        if (userEnteredInput <= 5) {
            return CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
    }

}


class OFFRoad extends Cab {

    final private Double CHARGES_FOR_THE_BASE_CASE = 100.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 20.00; 
    final private Double OTHER_DISTANCE_CHARGES = 25.00; 
    private Double otherFifteenKm;
    private Double restDistance;

    public OFFRoad(Double userEnteredInput) {
        super(100.00, 20.00, 25.00, userEnteredInput);
    }

    public Double getFareForTheCharge() {
        if (userEnteredInput <= 5) {
            return CHARGES_FOR_THE_BASE_CASE * userEnteredInput;
        } else if (userEnteredInput <= 20) {
            otherFifteenKm = userEnteredInput - 5;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (otherFifteenKm * CHARGES_FOR_THE_NEXT_15KM);
        } else {
            restDistance = userEnteredInput - 20;
            return CHARGES_FOR_THE_BASE_CASE * 5  + (CHARGES_FOR_THE_NEXT_15KM * 15) + (restDistance * OTHER_DISTANCE_CHARGES);
        }
    }

}

class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("<---------------------------------------------------------------->");
        System.out.println("Welcome to WCAB Services!!");
        System.out.println("Enter the total No. of Customers traveling and press enter to continue.");
        int totalUserInput = reader.nextInt();
        reader.nextLine();  // Consume the leftover newline character
        Cab[] cabs = new Cab[totalUserInput];

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
                            reader.nextLine();  // Consume the leftover newline character
                            cabs[i] = new Mini(userInputForMiniSedan);
                            break;
                        case "2":
                            System.out.println("Enter the total expected distance for City Sedan: ");
                            Double userInputForCitySedan = reader.nextDouble();
                            reader.nextLine();  // Consume the leftover newline character
                            cabs[i] = new Sedan(userInputForCitySedan);
                            break;
                        case "3":
                            System.out.println("Enter the total expected distance for Luxurious Sedan: ");
                            Double userInputForLuxuriousSedan = reader.nextDouble();
                            reader.nextLine();  // Consume the leftover newline character
                            cabs[i] = new Luxurious_Sedan(userInputForLuxuriousSedan);
                            break;
                        default:
                            System.out.println("Invalid Category Selected");
                            i--;  // Decrement counter to retry input for the same customer
                            break;
                    }
                    break;
                case "2":
                    System.out.println("Enter the total expected distance for SUV: ");
                    Double userInputForSUV = reader.nextDouble();
                    reader.nextLine();  // Consume the leftover newline character
                    cabs[i] = new SUV(userInputForSUV);
                    break;
                case "3":
                    System.out.println("Enter the total expected distance for OFF Road: ");
                    Double userInputOFFRoad = reader.nextDouble();
                    reader.nextLine();  // Consume the leftover newline character
                    cabs[i] = new OFFRoad(userInputOFFRoad);
                    break;
                default:
                    System.out.println("Invalid Category Selected");
                    i--;  // Decrement counter to retry input for the same customer
                    break;
            }
        }

        System.out.println("Total Fare Calculations:");
        for (int j = 0; j < totalUserInput; j++) {
            System.out.println("Customer " + (j + 1) + " fare: " + cabs[j].getFareForTheCharge() + " INR.");
        }
        System.out.println("<---------------------------------------------->");
        reader.close();
    }
}