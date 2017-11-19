import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RubiksCube extends Applet implements MouseListener, KeyListener {

    private Image backBuffer;
    private Graphics backG;

    private static final int APP_W = 800;
    private static final int APP_H = 800;
    static final Point ORIGIN = new Point(APP_W / 2, APP_H / 2, 0);

    private final int SIDE_LENGTH = (int) ((APP_W - 15) / (3.0 * Math.sqrt(3)));
    private final int CORNER_RAD = (int) ((3 * SIDE_LENGTH) / Math.sqrt(2));
    private final int INNER_RAD = CORNER_RAD / 3;
    //From origin
    private final int EDGE_RAD = (int) ((Math.sqrt(5) * SIDE_LENGTH) / (Math.sqrt(2)));
    private Point[][] pointArrays = new Point[4][1]; //{corners,edges1,edges2,iCorners};
    private Face primary;
    private CenterPiece[] pieces = new CenterPiece[9];
    private Sticker[] stickers = new Sticker[9];
    private Point[][] currStick = new Point[9][4];

    @Override
    public void init() {
        /*System.out.println(CORNER_HYP);
        System.out.println(INNER_HYP);
        System.out.println(EDGE_HYP);*/
        backBuffer = createImage(getSize().width, getSize().height);
        backG = backBuffer.getGraphics();
        addMouseListener(this);
        addKeyListener(this);
        Point[] corners = new Point[4];
        Point[] edges1 = new Point[4];
        Point[] edges2 = new Point[4];
        Point[] iCorners = new Point[4];
        for (int point = 0; point < 4; point++) {
            corners[point] = new Point(ORIGIN,
                    (Math.PI / 4.0) + (Math.PI * (point)) / 2.0, CORNER_RAD);
            edges1[point] = new Point(ORIGIN,
                    Math.atan(1.0 / 3.0) + (Math.PI * (point)) / 2.0, EDGE_RAD);
            edges2[point] = new Point(ORIGIN,
                    Math.atan(3.0) + (Math.PI * (point)) / 2.0, EDGE_RAD);
            iCorners[point] = new Point(ORIGIN,
                    (Math.PI / 4.0) + (Math.PI * (point)) / 2.0, INNER_RAD);
        }
        pointArrays[0] = corners;
        pointArrays[1] = edges1;
        pointArrays[2] = edges2;
        pointArrays[3] = iCorners;

        currStick[0][0] = pointArrays[0][0];
        currStick[0][1] = pointArrays[1][0];
        currStick[0][2] = pointArrays[3][0];
        currStick[0][3] = pointArrays[2][0];
        stickers[0] = new Sticker(currStick[0], "BLUE");

        currStick[1][0] = pointArrays[0][1];
        currStick[1][1] = pointArrays[1][1];
        currStick[1][2] = pointArrays[3][1];
        currStick[1][3] = pointArrays[2][1];
        stickers[1] = new Sticker(currStick[1], "BLUE");

        currStick[2][0] = pointArrays[0][2];
        currStick[2][1] = pointArrays[2][2];
        currStick[2][2] = pointArrays[3][2];
        currStick[2][3] = pointArrays[1][2];
        stickers[2] = new Sticker(currStick[2], "BLUE");

        currStick[3][0] = pointArrays[0][3];
        currStick[3][1] = pointArrays[2][3];
        currStick[3][2] = pointArrays[3][3];
        currStick[3][3] = pointArrays[1][3];
        stickers[3] = new Sticker(currStick[3], "BLUE");

        currStick[4][0] = pointArrays[1][1];
        currStick[4][1] = pointArrays[2][0];
        currStick[4][2] = pointArrays[3][0];
        currStick[4][3] = pointArrays[3][1];
        stickers[4] = new Sticker(currStick[4], "BLUE");

        currStick[5][0] = pointArrays[1][2];
        currStick[5][1] = pointArrays[2][1];
        currStick[5][2] = pointArrays[3][1];
        currStick[5][3] = pointArrays[3][2];
        stickers[5] = new Sticker(currStick[5], "BLUE");

        currStick[6][0] = pointArrays[1][3];
        currStick[6][1] = pointArrays[2][2];
        currStick[6][2] = pointArrays[3][2];
        currStick[6][3] = pointArrays[3][3];
        stickers[6] = new Sticker(currStick[6], "BLUE");

        currStick[7][0] = pointArrays[1][0];
        currStick[7][1] = pointArrays[2][3];
        currStick[7][2] = pointArrays[3][3];
        currStick[7][3] = pointArrays[3][0];
        stickers[7] = new Sticker(currStick[7], "BLUE");

        currStick[8][0] = pointArrays[3][0];
        currStick[8][1] = pointArrays[3][1];
        currStick[8][2] = pointArrays[3][2];
        currStick[8][3] = pointArrays[3][3];
        stickers[8] = new Sticker(currStick[8], "BLUE");

        int index = 0;

        for (Sticker s : stickers) {
            pieces[index++] = new CenterPiece(s);
        }

        primary = new Face(pieces, "BLUE");

    }

    public void paint(Graphics g) {
        update(g);
    }

    public void update(Graphics g) {
        //int random = (int) (Math.random() * 256);
        backG.setColor(new Color(140, 140, 140));
        backG.fillRect(0, 0, APP_W, APP_H);
        primary.draw(backG);
        backG.fillRect(0, 0, 1, 1);

        for (Point[] points : pointArrays)
            for (Point point : points) point.addAngle(Math.PI * 0 / 180);
        g.drawImage(backBuffer, 0, 0, this);
        repaint();
    }

/*
    public void randomizePoints(Point[][] pointArray) {
        int counter = 0;
        int rand = 0;
        for (Point[] points : pointArray) {
            for (Point point : points) {
                backG.fillOval((int) point.getX(), (int) point.getY(), 5, 5);
                point.setX(Math.random()*APP_W);
                point.setY(Math.random()*APP_H);
                //System.out.println("X: " + point.getX() + ", Y: " + point.getY());
            }
            counter++;
        }
    }
*/

    private void cubeBuilder() {
        //8 corners on a cube, so 8 corner points
        Point[] cornerPoints = new Point[8];
        //24 points that construct all 12 edges of the cube (2 points per edge)
        Point[] edgePoints = new Point[24];
        //24 points that construct the 6 faces of the cube that aren't on corners or edge (4 per face)
        Point[] facePoints = new Point[24];
        calculatePoints(cornerPoints, edgePoints, facePoints);
    }

    private void calculatePoints(Point[] cP, Point[] eP, Point[] fP) {
        //cornerPoints
        double[] angles = {Math.PI / 4.0, 7.0 * Math.PI / 4.0, 5.0 * Math.PI / 4.0, 3.0 * Math.PI / 4.0};
        for (int corner = 0; corner < 4; corner++)
            cP[corner] = new Point(ORIGIN, Math.sin(angles[0]) * CORNER_RAD, angles[corner], CORNER_RAD);
        for (int corner = 0; corner < 4; corner++)
            cP[corner + 4] = new Point(ORIGIN, Math.sin(angles[1]) * CORNER_RAD, angles[corner], CORNER_RAD);

        ///////////////////////////////////////////////////////

    }

    /**
     * Invoked when a key has been typed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key typed event.
     *
     * @param e Object detailing the event
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Invoked when a key has been pressed.
     * See the class description for {@link KeyEvent} for a definition of
     * a key pressed event.
     *
     * @param e Object detailing the event
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Invoked when a key has been released.
     * See the class description for {@link KeyEvent} for a definition of
     * a key released event.
     *
     * @param e Object detailing the event
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e Object detailing the event
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e Object detailing the event
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e Object detailing the event
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e Object detailing the event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e Object detailing the event
     */
    @Override
    public void mouseExited(MouseEvent e) {
    }
}