public class TestPlanet {

    /** Tests the pairwise force between two planets. */
    public static void main(String[] args) {
        checkPlanet();
    }

    /** 
     * Checks whether or not two Doubles are equal and prints the results.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    private static void checkPlanet() {
        System.out.println("Testing Planet...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 133.4, "Planet()", 0.01);
        checkEquals(p1.calcForceExertedBy(p3), 6.67e-11, "Planet()", 0.01);
    }
}
