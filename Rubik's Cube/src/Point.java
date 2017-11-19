/**
 * A point representing a location in (x, y, z)
 * coordinate space specified in double precision.
 *
 * @author Kai Fleischman
 */

public class Point {
    /**
     * X coordinate of this Point.
     */
    private double x;

    /**
     * Y coordinate of this Point.
     */
    private double y;

    /**
     * Z coordinate of this Point.
     */
    private double z;

    /**
     * The angle of this point in it's path of rotation.
     */
    private double angle;

    /**
     * The distance this point is from origin.
     */
    private double originDistance;

    /**
     * Constructs a NON-MOVING Point with X, Y, and Z
     * coordinates set to parameter specifications.
     *
     * @param x value to initialize X coordinate.
     * @param y value to initialize Y coordinate.
     * @param z value to initialize Z coordinate.
     */
    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Constructs a MOVING Point with X, Y, and Z
     * coordinates set to parameter specifications.
     *
     * @param x value to initialize X coordinate.
     * @param y value to initialize Y coordinate.
     * @param z value to initialize Z coordinate.
     * @param angle value to initialize angle.
     * @param oD value to initialize originDistance.
     */
    public Point(double x, double y, double z, double angle, double oD) {
        this(x, y, z);
        this.angle = angle;
        originDistance = oD;
    }

    /**
     * Constructs a MOVING Point with an origin
     * Point, angle of this Point's path, distance
     * from origin. This automates the creation
     * of X, Y, Z coordinates.
     *
     * @param origin origin of the plane this point
     * lies on.
     * @param angle value to initialize angle.
     * @param oD value to initialize originDistance.
     */
    public Point(Point origin, double angle, double oD) {
        this(oD * Math.cos(angle) + origin.x,
                origin.y - oD * Math.sin(angle),origin.z + oD * Math.sin(angle));
        this.angle = angle;
        originDistance = oD;
    }

    /**
     * Constructs a MOVING Point with an origin
     * Point, angle of this Point's path, distance
     * from origin. This automates the creation
     * of X, Y, Z coordinates.
     *
     * @param origin origin of the plane this point
     * lies on.
     * @param angle value to initialize angle.
     * @param oD value to initialize originDistance.
     */
    public Point(Point origin, double z, double angle, double oD) {
        this(oD * Math.cos(angle) + origin.x,
                origin.y - oD * Math.sin(angle),origin.z + z);
        this.angle = angle;
        originDistance = oD;
    }

    /**
     * Returns the X coordinate of this Point.
     *
     * @return the X coordinate of this Point.
     */
    public double getX() { return x; }

    /**
     * Sets the value of the X coordinate of this Point
     * to the specified value.
     *
     * @param x value to set X coordinate to.
     */
    public void setX(double x) { this.x = x; }

    /**
     * Returns the Y coordinate of this Point.
     *
     * @return the Y coordinate of this Point.
     */
    public double getY() { return y; }

    /**
     * Sets the value of the Y coordinate of this Point
     * to the specified value.
     *
     * @param y value to set Y coordinate to.
     */
    public void setY(double y) { this.y = y; }

    /**
     * Returns the Z coordinate of this Point.
     *
     * @return the Z coordinate of this Point.
     */
    public double getZ() { return z; }

    /**
     * Sets the value of the Z coordinate of this Point
     * to the specified value.
     *
     * @param z value to set Z coordinate to.
     */
    public void setZ(double z) { this.z = z; }

    /**
     * Returns the angle of this Point.
     *
     * @return the angle of this Point.
     */
    public double getAngle() { return angle; }

    /**
     * Sets the angle of this Point
     * to the angle plus a specified value, and
     * then changes the x and y coordinates of
     * this point based on the new angle.
     *
     * @param angle value to set angle to.
     */
    public void addAngle(double angle) {
        this.angle += angle;
        this.angle = this.angle > Math.PI * 2 ? this.angle - Math.PI * 2 : this.angle;
        x = originDistance * Math.cos(this.angle) + RubiksCube.ORIGIN.x;
        y = originDistance * Math.sin(this.angle) + RubiksCube.ORIGIN.y;
    }

    /**
     * Returns an array of all of a specified coordinate within the array of points.
     * Char x tells us to get all x coordinates, y all y coordinates, and z all z coordinates.
     *
     * @return an array of all rounded x coordinates within the array of points.
     */
    public static double[] getAll(Point[] points, char c) {
        double[] all = new double[points.length];
        int index = 0;

        for (Point p : points) {
            switch (c) {
                case 'x': all[index++] = p.x; break;
                case 'y': all[index++] = p.y; break;
                case 'z': all[index++] = p.z;
            }
        }

        return all;
    }

    /**
     * Returns an array of all of a specified coordinate within the array of points.
     * The coordinates are rounded. Char x tells us to get all x coordinates, y all
     * y coordinates, and z all z coordinates.
     *
     * @return an array of all rounded x coordinates within the array of points.
     */
    public static int[] getAllRounded(Point[] points, char c) {
        int[] roundAll = new int[points.length];
        int index = 0;

        for(double d : getAll(points, c))
            roundAll[index++] = (int) d;

        return roundAll;
    }

    /**
     * Returns this Point's distance from origin.
     *
     * @return this Point's distance from origin.
     */
    public double getOriginDistance() { return originDistance; }
}