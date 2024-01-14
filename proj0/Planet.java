public class Planet {
    public double xxPos; 
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G = 6.67e-11;

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

    /** 
     * To check whether if 'readPlanets' is true.
     * @Override
    public String toString() {
        return "Planet(xxPos:" + xxPos + ",yyPos:" + yyPos
                + ",xxVel:" + xxVel + ",yyVel:" + yyVel + 
                ",mass:" + mass + ",imgFileName:" + imgFileName + ")";
    }
    */
    

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
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        r2 = dx*dx + dy*dy;
        double r = Math.sqrt(r2);
        return r;
    }


    /** Take in a planet, returns a double 
     * describing the force exerted on this planet by the given planet. */
    public double calcForceExertedBy(Planet p) {
        double f;
        double r2 = this.calcDistance(p) * this.calcDistance(p);
        f = (G * this.mass * p.mass) / r2;
        return f;
    }

    public double calcForceExertedByX(Planet p) {
        double dX = p.xxPos - this.xxPos;
        double fX = this.calcForceExertedBy(p) * dX / this.calcDistance(p);
        return fX;
    }

    public double calcForceExertedByY(Planet p) {
        double dY = p.yyPos - this.yyPos;
        double fY = this.calcForceExertedBy(p) * dY / this.calcDistance(p);
        return fY;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netFX = 0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            } else {
                netFX += this.calcForceExertedByX(p);
            }
        }
        return netFX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netFY = 0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            } else {
                netFY += this.calcForceExertedByY(p);
            }
        }
        return netFY;
    }


    /** To update the planet's position and velocity. */
    public void update(double dt, double fX, double fY) {
        double aX = fX / this.mass;
        double aY = fY / this.mass;
        this.xxVel += dt * aX;
        this.yyVel += dt * aY;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }


    public void draw() {
        String imgToDraw = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, imgToDraw);
        StdDraw.show();
    }
}