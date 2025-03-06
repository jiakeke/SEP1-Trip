import java.util.Scanner;

public class TripCostCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the distance of the trip in km: ");
        double distance = scanner.nextDouble();
        System.out.println("Enter the fuel price per litre: ");
        double fuelPrice = scanner.nextDouble();
        double fuelConsumptionPer100Km = 5.0;
        double totalCost = calculateCost(distance, fuelPrice, fuelConsumptionPer100Km);
        System.out.println("The total cost of the trip is: $" + totalCost);
    }

    public static double calculateCost(double distance, double fuelPrice, double fuelConsumptionPer100Km) {
        return distance / 100 * fuelConsumptionPer100Km * fuelPrice;
    }
}
