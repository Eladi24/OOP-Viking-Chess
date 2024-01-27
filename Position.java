import java.util.ArrayList;

public class Position {
    private int _x;
    private int _y;
    private ConcretePiece _piece;
    private int _stepedOn = 0;
    private ArrayList<String> _pieceSteppedOn;

    public Position(int x, int y) {
        this._x = x;
        this._y = y;
        this._pieceSteppedOn =new ArrayList<>();

    }

    public int getX() {
        return this._x;
    }

    public int getY() {
        return this._y;
    }

    public void setX(int x) {
        this._x = x;
    }

    public void setY(int y) {
        this._y = y;
    }

    public ConcretePiece getPiece() {
        return this._piece;
    }

    public void setPiece(ConcretePiece piece) {
        this._piece = piece;
    }
    public String toString (){
       return "(" + this._x +"," + " " + this._y +")";
    }
    public ArrayList<String> getPieceSteppedOn() {
        return this._pieceSteppedOn;
    }
    public void setPieceSteppedOn() {
        this._pieceSteppedOn.add(this._piece.getName());
    }

    public int getStepOnCount() {
        return this._stepedOn;
    }

    public void increamnetStepedOn(){
        this._stepedOn++;
    }

    public boolean isEmpty(Position a) {
        return false;
    }
}
