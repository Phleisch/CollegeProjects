import java.awt.*;

/**
 * A plane constructed from nine contiguous
 * Pieces, initially with Stickers of the same
 * color facing outward.
 *
 * @author Kai Fleischman
 */

public class Face {
    /**
     * A matrix of pieces which
     * construct this Face.
     */
    private CenterPiece[][] pieces;

    /**
     * The color name of this Face.
     */
    private String faceColor;

    /**
     * Constructs a Face with pieces and color
     * set to parameter specification.
     *
     * @param pieces Matrix to initialize pieces.
     * @param faceColor Color to initialize face color.
     * @throws IllegalArgumentException if any parameter
     * is null.
     */
    public Face(CenterPiece[][] pieces, String faceColor) {
        Project.checkNull(pieces, "pieces");
        Project.checkNull(faceColor, "faceColor");
        this.pieces = pieces;
        this.faceColor = faceColor;
    }

    public Face(CenterPiece[] pieces, String faceColor) {
        Project.checkNull(pieces, "pieces");
        Project.checkNull(faceColor, "faceColor");
        this.pieces = new CenterPiece[3][3];
        int index = 0;

        for(CenterPiece p : pieces)
            this.pieces[index/3][index++%3] = p;
        this.faceColor = faceColor;
    }

    /**
     * Displays a graphical representation of this object.
     *
     * @param g The graphics environment being used.
     */
    public void draw(Graphics g) {
        for(CenterPiece[] pArray : pieces)
            for(CenterPiece p : pArray)
                p.draw(g);
    }

    /**
     * Returns the matrix of pieces for this Face.
     *
     * @return the matrix of pieces for this Face.
     */
    public CenterPiece[][] getPieces() { return pieces; }

    /**
     * Returns the color name of this Face.
     *
     * @return the color name of this Face.
     */
    public String getFaceColor() { return faceColor; }
}