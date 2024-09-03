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
        System.out.println("Welcome to WCAB Services");
        System.out.println("<---------------------------------------------------------------->");
        System.out.println("Press Any key and press enter to continue.");
        String demoInput = reader.nextLine();
        System.out.println("Choose Category of Vehicle:(Note Just Choose the Serial Number)");
        System.out.println("1.Sedan, 2.SUV, 3.OFF Road");
        String user_Selected_Category = reader.nextLine();
        switch (user_Selected_Category) {

            case "1":
                System.out.println("Choose your Sub-category of Sedans;");
                System.out.println("1.Mini Sedan, 2.City Sedan, 3.Luxurious Sedan");
                String user_Selected_Subcategory_Sedan = reader.nextLine();

                switch (user_Selected_Subcategory_Sedan) {

                    case "1":
                        System.out.println("Enter the total expected distance: ");
                        Double userInputForMiniSedan = reader.nextDouble();
                        Mini mini_Cab = new Mini(userInputForMiniSedan); 
                        System.out.println("Your total fair is: " + mini_Cab.getFareForTheCharge() + "INR.");
                        System.out.println("<---------------------------------------------------------------->");
                    break;

                    case "2":
                        System.out.println("Enter the total expected distance: ");
                        Double userInputForCitySedan = reader.nextDouble();
                        Sedan sedan_Cab = new Sedan(userInputForCitySedan);
                        System.out.println("Your total fair is: " + sedan_Cab.getFareForTheCharge() + "INR.");
                        System.out.println("<---------------------------------------------------------------->");
                    break;

                    case "3":
                        System.out.println("Enter the total expected distance: ");
                        Double userInputForLuxuriousSedan = reader.nextDouble();
                        Luxurious_Sedan luxury_Sedan_Cab = new Luxurious_Sedan(userInputForLuxuriousSedan);
                        System.out.println("Your total fair is: " + luxury_Sedan_Cab.getFareForTheCharge() + "INR.");
                        System.out.println("<---------------------------------------------------------------->");
                    break;

                }

                break;
        
            case "2":
                System.out.println("Enter the total expected distance: ");
                Double userInputForSUV = reader.nextDouble();
                SUV mySuv = new SUV(userInputForSUV);
                System.out.println("Your total fair is: " + mySuv.getFareForTheCharge() + "INR.");
                System.out.println("<---------------------------------------------------------------->");
            break;

            case "3":
                System.out.println("Enter the total expected distance: ");
                Double userInputOFFRoad = reader.nextDouble();
                OFFRoad myOFFRoadVehicle = new OFFRoad(userInputOFFRoad);
                System.out.println("Your total fair is: " + myOFFRoadVehicle.getFareForTheCharge() + "INR.");
                System.out.println("<---------------------------------------------------------------->");
            break;
        }
        reader.close();
    }
}
