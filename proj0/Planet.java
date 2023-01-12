import java.lang.Math;

public class Planet {
	public double xxPos, yyPos;
	public double xxVel, yyVel;
	public double mass;
	public String imgFileName;

	public static final double G = 6.67e-11;	// const declared as static final is a good practice.

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Planet b) {
		double dx = b.xxPos - xxPos;
		double dy = b.yyPos - yyPos;
		double square = dx * dx + dy * dy;
		return Math.sqrt(square);
	}

	public double calcForceExertedBy(Planet p) {
		double distance = calcDistance(p);
		return G * mass * p.mass / (distance * distance);
	}

	public double calcForceExertedByX(Planet p) {
		double dx = p.xxPos - xxPos;
		double distance = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * dx / distance;
	}

	public double calcForceExertedByY(Planet p) {
		double dy = p.yyPos - yyPos;
		double distance = calcDistance(p);
		double force = calcForceExertedBy(p);
		return force * dy / distance;
	}

	public double calcNetForceExertedByX(Planet[] p) {
		double netForce = 0;
		for (Planet planet: p) {
			// the planet can't exert gravity on itself
			if (this.equals(planet)) continue;
			netForce += calcForceExertedByX(planet);
		}
		return netForce;
	}

	public double calcNetForceExertedByY(Planet[] p) {
		double netForce = 0;
		for (Planet planet: p) {
			// the planet can't exert gravity on itself
			if (this.equals(planet)) continue;
			netForce += calcForceExertedByY(planet);
		}
		return netForce;
	}

	/**
	 * update velocity and position with acceleration.
	 * @param: fX and fY are netForce exerted by x and y axis.
	 */
	public void update(double dt, double fX, double fY) {
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += aX * dt;
		yyVel += aY * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}

	/**
	 * draw the planet on starfield
	 */
	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);

		// display on the onscreen
		// StdDraw.show();
	}
}
