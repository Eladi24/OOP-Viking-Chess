public class Pawn extends ConcretePiece{

    private int _eatCount = 0;


    public Pawn(ConcretePlayer player) {
        setPlayer(player);
    }

    public int getEatCount() {
        return this._eatCount;
    }

    public void increaseEat() {
        this._eatCount++;
    }


    @Override
    public String getType() {
        return "♟";
    }
}
