import java.awt.*;

/**
 * A plane constructed from four points
 * connected into a square.
 *
 * @author Kai Fleischman
 */

public class Sticker {
    /**
     * All the points of this Sticker. Index 0 =
     * upperRight, 1 = lowerRight, 2 = lowerLeft,
     * 3 = upperLeft.
     */
    private Point[] corners;

    /**
     * Color name of this Sticker.
     */
    private String stickerColor;

    /**
     * Constructs a Sticker with corners and color
     * set to parameter specifications.
     *
     * @param corners Array of points to initialize the corners of this sticker.
     * @param stickerColor Color to initialize sticker color.
     * @throws IllegalArgumentException if any Point or String parameter is null.
     */
    public Sticker(Point[] corners, String stickerColor) {
        Project.checkNull(corners, "corners");
        Project.checkNull(stickerColor, "stickerColor");
        for (Point p : corners)
            Project.checkNull(p, "Element of corners");

        this.corners = corners;
        this.stickerColor = stickerColor;
    }

    /**
     * Returns the lower left point of this Sticker.
     *
     * @return the lower left point of this Sticker.
     */
    public Point getLowerLeft() { return corners[2]; }

    /**
     * Returns the upper left point of this Sticker.
     *
     * @return the upper left point of this Sticker.
     */
    public Point getUpperLeft() { return corners[3]; }

    /**
     * Returns the upper right point of this Sticker.
     *
     * @return the upper right point of this Sticker.
     */
    public Point getUpperRight() { return corners[0]; }

    /**
     * Returns the lower right point of this Sticker.
     *
     * @return the lower right point of this Sticker.
     */
    public Point getLowerRight() { return corners[1]; }

    /**
     * Returns all points of this sticker.
     *
     * @return all points of this sticker.
     */
    public Point[] getCorners() { return corners; }

    /**
     * Sets the value of the lower left point to the
     * specified value.
     *
     * @param lowerLeft value to set lower left point to.
     */
    public void setLowerLeft(Point lowerLeft) { corners[2] = lowerLeft; }

    /**
     * Sets the value of the upper left point to the
     * specified value.
     *
     * @param upperLeft value to set upper left point to.
     */
    public void setUpperLeft(Point upperLeft) { corners[3] = upperLeft; }

    /**
     * Sets the value of the upper right point to the
     * specified value.
     *
     * @param upperRight value to set upper right point to.
     */
    public void setUpperRight(Point upperRight) { corners[0] = upperRight; }

    /**
     * Sets the value of the lower right point to the
     * specified value.
     *
     * @param lowerRight value to set lower right point to.
     */
    public void setLowerRight(Point lowerRight) { corners[1] = lowerRight; }

    /**
     * Returns the color of this Sticker.
     *
     * @return the color of this Sticker.
     */
    public String getStickerColor() { return stickerColor; }

    /**
     * Displays a graphical representation of this object.
     *
     * @param g The graphics environment being used.
     */
    public void draw(Graphics g) {
        int[] xPoints = Point.getAllRounded(corners, 'x');
        int[] yPoints = Point.getAllRounded(corners, 'y');

        g.setColor(Cube.getColor(stickerColor));
        g.fillPolygon(xPoints, yPoints, corners.length);

        g.setColor(Cube.getColor("BLACK"));
        g.drawPolygon(xPoints, yPoints, corners.length);
    }
}