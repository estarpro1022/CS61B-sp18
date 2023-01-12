/**
 * Test pairwise force between two planets.
 */
public class TestPlanet {
	// 写个Test漏洞百出，我人傻了
	public static void main(String[] args) {
		Planet a = new Planet(1.0, 2.0, 3.0, 4.0, 5.0, "juice.jpg");
		Planet b = new Planet(3.0, 6.0, 3.0, 4.0, 6.0, "coca.jpg");
		checkPairwiseForce(a, b);
	}

	public static void checkPairwiseForce(Planet a, Planet b) {
		double aForceX = a.calcForceExertedByX(b);
		double aForceY = a.calcForceExertedByY(b);
		double bForceX = b.calcForceExertedByX(a);
		double bForceY = b.calcForceExertedByY(a);

		checkEquals(aForceX, bForceX, "ForceX");
		checkEquals(aForceY, bForceY, "ForceY");
	}

	public static void checkEquals(double forceOne, double forceTwo, String label) {
		if (forceOne == -forceTwo) {
			System.out.println("PASS: Two planets's " + label + " is same. The Abs of force is " + Math.abs(forceOne));
		} else {
			System.out.println("FAIL: Two planets's " + label + " is not same. Two forces are " + forceOne + " and " + forceTwo);
		}
	}
}
