public class King extends ConcretePiece{
    public King (ConcretePlayer player) {
        setPlayer(player);
    }
    @Override
    public String getType() {
        return "♚";
    }
}
