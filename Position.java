import java.util.ArrayList;

/**
 * This class represents a position on a game board.
 */
public class Position {
    private int _x;
    private int _y;
    private ConcretePiece _piece;
    private int _steppedOn = 0;
    private ArrayList<String> _pieceSteppedOn;

    public Position(int x, int y) {
        this._x = x;
        this._y = y;
        this._pieceSteppedOn =new ArrayList<>();

    }

    /**
     * Getter for the x-coordinate.
     *
     * @return The x-coordinate of the position.
     */
    public int getX() {
        return this._x;
    }

    /**
     * Getter for the y-coordinate.
     *
     * @return The y-coordinate of the position.
     */
    public int getY() {
        return this._y;
    }

    /**
     * Setter for the x-coordinate.
     *
     * @param x The new x-coordinate of the position.
     */
    public void setX(int x) {
        this._x = x;
    }

    /**
     * Setter for the y-coordinate.
     *
     * @param y The new y-coordinate of the position.
     */
    public void setY(int y) {
        this._y = y;
    }

    /**
     * Getter for the piece at the position.
     *
     * @return The piece at the position.
     */
    public ConcretePiece getPiece() {
        return this._piece;
    }

    /**
     * Setter for the piece at the position.
     *
     * @param piece The new piece to be placed at the position.
     */
    public void setPiece(ConcretePiece piece) {
        this._piece = piece;
    }

    /**
     * Converts the position to a string representation.
     *
     * @return A string representation of the position.
     */
    public String toString (){
       return "(" + this._x +"," + " " + this._y +")";
    }

    /**
     * Getter for the pieces that have stepped on the position.
     *
     * @return An ArrayList of the names of the pieces that have stepped on the position.
     */
    public ArrayList<String> getPieceSteppedOn() {
        return this._pieceSteppedOn;
    }

    /**
     * Adds the name of the current piece to the list of pieces that have stepped on the position.
     */
    public void setPieceSteppedOn() {
            this._pieceSteppedOn.add(this._piece.getName());

    }

    /**
     * Getter for the count of times the position has been stepped on.
     *
     * @return The count of times the position has been stepped on.
     */
    public int getStepOnCount() {
        return this._steppedOn;
    }

    /**
     * Increments the count of times the position has been stepped on.
     */
    public void incrementSteppedOn(){
        this._steppedOn++;
    }

}
