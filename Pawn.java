public class Pawn extends ConcretePiece{

    private int eatCount;


    public Pawn(ConcretePlayer player) {
        setPlayer(player);
    }

    public int getEatCount() {
        return eatCount;
    }

    public void increaseEat() {
        eatCount++;
    }


    @Override
    public String getType() {
        return "♟";
    }
}
