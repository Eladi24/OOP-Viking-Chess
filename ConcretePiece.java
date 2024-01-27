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

    public void setPlayer(ConcretePlayer player) {
        this._player = player;
    }

    public ArrayList<Position> getPositionsHistory() {
        return this._positionsHistory;
    }
    public void addPos(Position position) {
        this._positionsHistory.add(position);
    }
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }
    public int getMoveNum() {
        return this._positionsHistory.size();
    }
    public int getSquares() {
        return this._squares;
    }
    public void setSquares(int delta){
        this._squares += delta;
    }
    public static int getIntPart(String name) {
        String number = name.replaceAll("\\D+", "");
        return Integer.parseInt(number);
    }


    @Override
    public abstract String getType();
}
