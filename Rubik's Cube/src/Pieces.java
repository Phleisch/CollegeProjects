import java.awt.*;

/**
 * An individual block of a Rubik's Cube
 * formed by one Sticker.
 *
 * @author Kai Fleischman
 */

class CenterPiece {
    /**
     * The Sticker that is native to a Face
     * because it is the same color as the Face.
     */
    private Sticker local;

    /**
     * Constructs a CenterPiece with local
     * Sticker set to parameter specifications.
     *
     * @param local Sticker to initialize local.
     * @throws IllegalArgumentException if any
     * Sticker parameter is null.
     */
    public CenterPiece(Sticker local) {
        Project.checkNull(local, "local");
        this.local = local;
    }

    /**
     * Displays a graphical representation of this object.
     *
     * @param g The graphics environment being used.
     */
    public void draw(Graphics g) {
        local.draw(g);
    }

    /**
     * Returns the local Sticker of this piece.
     *
     * @return the local Sticker of this piece.
     */
    public Sticker getLocal() { return local; }
}


/**
 * An individual block of a Rubik's Cube
 * formed by two Stickers.
 *
 * @author Kai Fleischman
 */

class EdgePiece extends CenterPiece {
    /**
     * The Sticker that is below local if
     * local is on the XY plane, and below
     * is on the XZ plane, and the Y coordinate
     * of the lower left Point of local is >=
     * the Y coordinate of any Point of below.
     */
    private Sticker below;

    /**
     * Constructs an EdgePiece with Stickers
     * set to parameter specifications.
     *
     * @param local Sticker to initialize local.
     * @param below Sticker to initialize below.
     * @throws IllegalArgumentException if any
     * Sticker parameter is null.
     */
    public EdgePiece(Sticker local, Sticker below) {
        super(local);
        Project.checkNull(below, "below");
        this.below = below;
    }

    /**
     * Returns the Sticker below the local Sticker
     * of this piece.
     *
     * @return the Sticker below the local Sticker
     * of this piece.
     */
    public Sticker getBelow() { return below; }
}


/**
 * An individual block of a Rubik's Cube
 * formed by three Stickers.
 *
 * @author Kai Fleischman
 */

class CornerPiece extends EdgePiece {
    /**
     * The Sticker that is left of local if
     * local is on the XY plane, and left
     * is on the YZ plane, and the X coordinate
     * of the lower left Point of local is >=
     * the X coordinate of any Point of left.
     */
    private Sticker left;

    /**
     * Constructs a CornerPiece with Stickers
     * set to parameter specifications.
     *
     * @param local Sticker to initialize local.
     * @param below Sticker to initialize below.
     * @param left Sticker to initialize left.
     * @throws IllegalArgumentException if any
     * Sticker parameter is null.
     */
    public CornerPiece(Sticker local, Sticker below, Sticker left) {
        super(local, below);
        Project.checkNull(left, "left");
        this.left = left;
    }

    /**
     * Returns the Sticker to the left of the
     * local Sticker of this piece.
     *
     * @return the Sticker to the left of the
     * local Sticker of this piece.
     */
    public Sticker getLeft() { return left; }
}