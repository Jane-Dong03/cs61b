public class Planet {
    public double xxPos; 
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G = 6.67e-11;

    /** constructor 1 */
    public Planet(double xP, double yP, double xV,
                    double yV, double m, String img) {
                        xxPos = xP;
                        yyPos = yP;
                        xxVel = xV;
                        yyVel = yV;
                        mass = m;
                        imgFileName = img;
                    }

    /** constructor 2 - copy */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }


    /** Calculate the distance-r between two Planets. */
    public double calcDistance(Planet p) {
        double r2; // r2 = r * r
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        r2 = dx*dx + dy*dy;
        double r = Math.sqrt(r2);
        return r;
    }


    /** Take in a planet, returns a double 
     * describing the force exerted on this planet by the given planet. */
    public double calcForceExertedBy(Planet p) {
        double F;
        double r2 = this.calcDistance(p) * this.calcDistance(p);
        F = (G * this.mass * p.mass) / r2;
        return F;
    }
}