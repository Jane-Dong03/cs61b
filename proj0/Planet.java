public class Planet {
    public double xxPos; 
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

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


    /** Calculate the distance between two Planets. */
    public double calcDistance(Planet pNow) {
        double r2; // r2 = r * r
        double dx = this.xxPos - pNow.xxPos;
        double dy = this.yyPos - pNow.yyPos;
        r2 = dx*dx + dy*dy;
        double r = Math.sqrt(r2);
        return r;
    }
}