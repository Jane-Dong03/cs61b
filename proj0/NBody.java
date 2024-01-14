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

        String imageToDraw = "./images/starfield.jpg";

        StdDraw.setScale(-r, r);

        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();

        /** To draw all of the planets. */
        for (Planet p : allPlanets) {
            p.draw();
        }
    }

}
