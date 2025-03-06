import static org.junit.jupiter.api.Assertions.*;

class TripCostCalculatorTest {

    @org.junit.jupiter.api.Test
    void calculateCost() {
        assertEquals(20.0, TripCostCalculator.calculateCost(200, 2, 5));
        assertEquals(40.0, TripCostCalculator.calculateCost(400, 2, 5));
        assertEquals(60.0, TripCostCalculator.calculateCost(600, 2, 5));
        assertEquals(128.0, TripCostCalculator.calculateCost(800, 2, 8));
    }
}