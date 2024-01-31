import java.util.ArrayList;
import java.util.List;

public abstract class ConcretePiece implements Piece{

    protected ConcretePlayer _player;
    protected ArrayList<Position> _positionsHistory;
    protected String _name;
    private int _squares = 0;


    public ConcretePiece() {
        this._positionsHistory = new ArrayList<>();
    }
    @Override
    public Player getOwner() {
        return this._player;
    }

    /**
     * This method sets the player for the current game context.
     *
     * @param player The ConcretePlayer object representing the player to be set.
     */
    public void setPlayer(ConcretePlayer player) {
        this._player = player;
    }

    /**
     * This method returns the history of positions in the game.
     *
     * @return An ArrayList of Position objects representing the history of positions.
     */
    public ArrayList<Position> getPositionsHistory() {
        return this._positionsHistory;
    }

    /**
     * This method adds a new position to the positions' history.
     *
     * @param position The position to be added to the history.
     */
    public void addPos(Position position) {
        this._positionsHistory.add(position);
    }

    /**
     * This method returns the name of the object.
     *
     * @return The name of the object.
     */
    public String getName() {
        return this._name;
    }

    /**
     * This method sets the name of the object.
     *
     * @param name The new name to be set for the object.
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * This method returns the number of moves made.
     *
     * @return The size of the positions history, which represents the number of moves made.
     */
    public int getMoveNum() {
        return this._positionsHistory.size();
    }

    /**
     * This method returns the number of squares stepped on.
     *
     * @return The number of squares.
     */
    public int getSquares() {
        return this._squares;
    }

    /**
     * This method increments the number of squares by a given delta.
     *
     * @param delta The amount by which the number of squares should be incremented.
     */
    public void setSquares(int delta){
        this._squares += delta;
    }

    /**
     * This method extracts the integer part from a string.
     *
     * @param name The string from which the integer part should be extracted.
     * @return The integer part of the string.
     */
    public static int getIntPart(String name) {
        String number = name.replaceAll("\\D+", "");
        return Integer.parseInt(number);
    }


    @Override
    public abstract String getType();
}
