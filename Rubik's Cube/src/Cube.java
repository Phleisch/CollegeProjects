import java.awt.*;

/**
 * A cube constructed from six contiguous
 * faces all of different colors.
 *
 * @author Kai Fleischman
 */

public class Cube {
    /**
     * The official color Black for all Cube objects.
     */
    public static final Color BLACK = new Color(0,0,0);

    /**
     * The official color Blue for all Cube objects.
     */
    public static final Color BLUE = new Color(0,0,255);

    /**
     * The official color Green for all Cube objects.
     */
    public static final Color GREEN = new Color(0,128,0);

    /**
     * The official color Orange for all Cube objects.
     */
    public static final Color ORANGE = new Color(255,165,0);

    /**
     * The official color Red for all Cube objects.
     */
    public static final Color RED = new Color(255,0,0);

    /**
     * The official color White for all Cube objects.
     */
    public static final Color WHITE = new Color(255,255,255);

    /**
     * The official color Yellow for all Cube objects.
     */
    public static final Color YELLOW = new Color(255,255,0);

    /**
     * Array of faces that make up this Cube.
     */
    private Face[] faces;

    public static final int CUBE_SIZE = 3;

    /**
     * 3D array of CenterPieces that will be the native data structure for the Cube object.
     * Unless the cube is manipulate on the Z-axis, only the top layer of elements will be
     * displayed, since they overlay all other elements. This is more efficient. Otherwise, if
     * you can see more than one face of the cube at a time, elements will be given a priority,
     * such that higher priority elements will be displayed last, to paint over other elements.
     */
    private CenterPiece[][][] model;

    /**
     * Constructs a Cube with faces set to parameter
     * specifications.
     *
     * @param faces Face array to initialize face array.
     * @throws IllegalArgumentException if any faces is null of
     * if an element of faces is null.
     */
    public Cube(Face[] faces) {
        Project.checkNull(faces, "faces");
        for (Face face : faces)
            Project.checkNull(face, "element of faces");
        this.faces = faces;
    }

    /**
     * Returns the array of faces for this Cube.
     *
     * @return the array of faces for this Cube.
     */
    public Face[] getFaces() { return faces; }

    /**
     * Returns the color equivalent to the passed String.
     *
     * @return the the color equivalent to the passed String.
     * @param color The color being asked for.
     */
    public static Color getColor(String color) {
        Project.checkNull(color, "color");

        switch(color) {
            case "BLACK":   return BLACK;
            case "BLUE":    return BLUE;
            case "GREEN":   return GREEN;
            case "ORANGE":  return ORANGE;
            case "RED":     return RED;
            case "WHITE":   return WHITE;
            case "YELLOW":  return YELLOW;
        }

        return BLACK;
    }
}