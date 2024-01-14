public class NBody {
    public static double readRadius(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int numberOfPlanets = in.readInt();
        double radius = in.readDouble();

        return radius;
    }

    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);

        int numOfPlanets = in.readInt();
        double radius = in.readDouble();

        Planet[] allPlanetsArray = new Planet[numOfPlanets];
        for (int i = 0; i < allPlanetsArray.length; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            allPlanetsArray[i] = new Planet(xP, yP, xV, yV, m, img);
        }

        return allPlanetsArray;
    }


    /** Takes in T, dt, and filename that you want to simulate. */
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] allPlanets = readPlanets(filename);
        double r = readRadius(filename);

        StdDraw.enableDoubleBuffering();

        double t = 0;
        while (t < T) {
            double[] xForces = new double[allPlanets.length];
            double[] yForces = new double[allPlanets.length];

            /** 
             * Calculates the net x and y forces for each planet.
             */
            for (int i = 0; i < allPlanets.length; i++) {
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }

            /** 
             * Updates each planet's pos, vel and acceleration.
             */
            for (int i = 0; i < allPlanets.length; i++) {
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }

            /** 
             * Draws the background image.
             */
            String imageToDraw = "./images/starfield.jpg";

            StdDraw.setScale(-r, r);

            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            StdDraw.show();

            /**
             * Draws all of the planets.
             */
            for (Planet p : allPlanets) {
                p.draw();
            }

            StdDraw.pause(10);

            t  = t + dt;
        }

        StdOut.printf("d\n", allPlanets.length);
        StdOut.printf(".2e\n", r);
        for (int i = 0; i < allPlanets.length; i++) {
            StdOut.printf("%15.4e %15.4e %15.4e %15.4e %15.4e %15s\n", 
                            allPlanets[i].xxPos, allPlanets[i].yyPos, 
                            allPlanets[i].xxVel, allPlanets[i].yyVel, 
                            allPlanets[i].mass, allPlanets[i].imgFileName);
        }

    }

}
