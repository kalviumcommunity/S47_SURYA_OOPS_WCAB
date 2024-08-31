abstract class Cab {
    protected Double baseCharge;
    protected Double chargesForTheNext15km;
    protected Double additionalDistanceCharge;
    protected Double userEnteredInput;
    

    public abstract Double getFareForTheCharge();
}

class Mini extends Cab {
    final private Double CHARGES_FOR_THE_BASE_CASE = 50.00; 
    final private Double CHARGES_FOR_THE_NEXT_15KM = 10.00; 
    final private Double OTHER_DISTANCE_CHARGES = 8.00; 
    private Double otherFifteenKm;
    private Double restDistance;
        

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

    }
}
