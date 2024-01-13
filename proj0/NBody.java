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
}
