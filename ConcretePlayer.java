public class ConcretePlayer implements Player{
    private int wins;
    private final boolean isDefender;

    public ConcretePlayer(boolean defender) {
        this.isDefender = defender;
        this.wins = 0;
    }
    @Override
    public boolean isPlayerOne() {
        return this.isDefender;
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    public void increaseWins() {
        this.wins++;
    }

}
