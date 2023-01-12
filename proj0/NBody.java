public class NBody {
	// remember to use data type
	private static final int waitMillions = 10;
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("You haven't given arguments!");
			System.out.println("Please enter arguments.");
			return;
		}
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);

		
		// Play music
		playBackgroundMusic("audio/2001.mid");
		
		// parameter type: double, so int to double is ok, but double to int may cause precision loss.
		StdDraw.setScale(-radius, radius);
		StdDraw.enableDoubleBuffering();
		StdDraw.clear();
		StdDraw.picture(0, 0, "images/starfield.jpg");
		StdDraw.show();

		for (Planet planet: planets) {
			planet.draw();
			StdDraw.show();
		}

		// create a new variable instead of using dx++ directly.
		double t = 0.0;

		while (t <= T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			
			for (int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}

			for (int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}

			StdDraw.clear();
			// the reason why there is only starfield because firstly I put it after planets's drawing!
			// pay attention to order of StdDraw.show(). It determines which is on the top.
			StdDraw.picture(0, 0, "images/starfield.jpg");
			for (Planet planet: planets) {
				planet.draw();
			}
			StdDraw.show();
			StdDraw.pause(waitMillions);

			// place show here. not above. or the screen will flicker
			t += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
		    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
		    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}	

	public static double readRadius(String path) {
		In in = new In(path);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String path) {
		In in = new In(path);
		int row = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[row];
		for (int i = 0; i < row; i++) {
			double xP, yP, xV, yV, mass;
			String img;
			xP = in.readDouble();
			yP = in.readDouble();
			xV = in.readDouble();
			yV = in.readDouble();
			mass= in.readDouble();
			img = in.readString();
			planets[i] = new Planet(xP, yP, xV, yV, mass, img);
		}
		return planets;
	}

	private static void playBackgroundMusic(String musicPath) {
		StdAudio.play(musicPath);
	}
}
