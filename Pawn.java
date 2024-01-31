public class Pawn extends ConcretePiece{

    private int _eatCount = 0;


    public Pawn(ConcretePlayer player) {
        setPlayer(player);
    }

    /**
     * This method returns the count of times eating has occurred.
     *
     * @return The count of times eating has occurred.
     */
    public int getEatCount() {
        return this._eatCount;
    }

    /**
     * This method increments the count of times eating has occurred by pawn.
     */
    public void increaseEat() {
        this._eatCount++;
    }


    @Override
    public String getType() {
        return "♟";
    }
}
