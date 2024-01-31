import java.util.*;

public class GameLogic implements PlayableLogic{

    private ConcretePlayer _defender;
    private ConcretePlayer _attacker;
    private ConcretePlayer _current;
    private King _king;
    private List<Pawn> _defenders;
    private List<Pawn> _attackers;
    private Position[][] _board;
    private Position _currentKingPos;
    private int _attackersNums = 24;
    private int _defenderNums = 12;
    private final int _BOARD_SIZE = 11;

    public GameLogic() {
        this._defender = new ConcretePlayer(true);
        this._attacker = new ConcretePlayer(false);
        // calls a helper method
        init();
    }


    /**
     * This method initializes the game by setting up the pieces and the game board.
     * It also places the pieces (both attackers and defenders) at their initial positions.
     *
     * The steps are as follows:
     * 1. Initialize the pieces (both attackers and defenders).
     * 2. Set up the game board with a specific size.
     * 3. Place the attacker pieces on the board at their initial positions.
     * 4. Place the defender pieces on the board at their initial positions.
     */
    private void init() {
        initializePieces();
        initializeBoard();
        placeAttackers();
        placeDefenders();
    }


    /**
     * This method initializes the pieces for the game.
     * It sets up the king, defenders, and attackers, and assigns the current player.
     * It also sets the initial position of the king.
     */
    private void initializePieces() {
        // Create the king and assign it to the defender
        this._king = new King(this._defender);
        this._currentKingPos = new Position(7, 7);
        // Initialize the defenders and attackers lists.
        this._defenders = new ArrayList<Pawn>();
        this._attackers = new ArrayList<Pawn>();
        // Set the current player to the attacker
        this._current = this._attacker;

        // Create the attacker pieces and add them to the attackers list
        for (int i = 0; i < _attackersNums; i++) {
            this._attackers.add(new Pawn(this._attacker));
        }

        // Create the defender pieces and add them to the defenders list
        for (int i = 0; i < _defenderNums; i++) {
            this._defenders.add(new Pawn(this._defender));
        }
    }


    /**
     * This method initializes the game board.
     * It sets up the board with a specific size and creates a new Position object for each cell on the board.
     */
    private void initializeBoard() {
        // Create a new 2D array of Position objects with the size of the board
        this._board = new Position[11][11];

        // Iterate over each cell of the board
        for (int i = 0; i < getBoardSize() ; i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                //  For each cell, create a new Position object with the current coordinates and assign it to the cell
                this._board[i][j] = new Position(i, j);
            }
        }
    }


    /**
     *  This method places the attacker pieces on the game board at their initial positions.
     *  It also sets the names of the attacker pieces and updates the board state accordingly.
     */
    private void placeAttackers() {
        int i = 0, j = 3, k = 0 , n = 7;
        // initialize attackers
        while (j>= 3 && j<8 ) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();
            if (n == 13) {
                n = 15;
            }
            this._attackers.get(k).setName("A" + n);
            this._board[i][j].setPieceSteppedOn();

            n += 2;
            j++;
            k++;
        }

        // Place an attacker on (1,5)
        this._board[1][5].setPiece(this._attackers.get(k));
        this._board[1][5].getPiece().addPos(new Position(1, 5));
        this._board[1][5].incrementSteppedOn();

        this._attackers.get(k).setName("A12");
        this._board[1][5].setPieceSteppedOn();
        k++;

        // Place attackers on the left column
        j = 0;
        i = 3;
        n = 1;
        while (i >= 3 && i < 8) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            this._attackers.get(k).setName("A" + n);
            this._board[i][j].setPieceSteppedOn();
            i++;
            k++;
            n++;
        }

        // Place an attacker on (5,1)
        this._board[5][1].setPiece(this._attackers.get(k));
        this._board[5][1].getPiece().addPos(new Position(5, 1));
        this._board[5][1].incrementSteppedOn();

        this._attackers.get(k).setName("A6");
        this._board[5][1].setPieceSteppedOn();
        k++;

        // Place attackers on the bottom row
        i = 10;
        j = 3;
        n = 8;
        while (j >= 3 && j < 8) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            if (n == 12) {
                n = 14;
            }
            this._attackers.get(k).setName("A" + n);
            this._board[i][j].setPieceSteppedOn();
            n += 2;
            j++;
            k++;
        }

        // Place an attacker on (9,5)
        this._board[9][5].setPiece(this._attackers.get(k));
        this._board[9][5].getPiece().addPos(new Position(9, 5));
        this._board[9][5].incrementSteppedOn();

        this._attackers.get(k).setName("A13");
        this._board[9][5].setPieceSteppedOn();
        k++;

        // Place attackers on the right column
        i = 3;
        j = 10;
        n = 20;
        while (i >= 3 && i < 8) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            this._attackers.get(k).setName("A" + n);
            this._board[i][j].setPieceSteppedOn();
            i++;
            k++;
            n++;
        }

        // Place an attacker on (5,9)
        this._board[5][9].setPiece(this._attackers.get(k));
        this._board[5][9].getPiece().addPos(new Position(5, 9));
        this._board[5][9].incrementSteppedOn();

        this._attackers.get(k).setName("A19");
        this._board[5][9].setPieceSteppedOn();
    }


    /**
     * This method places the defender pieces on the game board at their initial positions.
     * It also sets the names of the defender pieces and updates the board state accordingly.
     */
    private void placeDefenders() {
        // Place a defender at position (5,3)
        int k = 0 , n = 2;
        this._board[5][3].setPiece(this._defenders.get(k));
        this._board[5][3].getPiece().addPos(new Position(5, 3));
        this._board[5][3].incrementSteppedOn();

        this._defenders.get(k).setName("D1");
        this._board[5][3].setPieceSteppedOn();
        k++;

        int i = 4 , j = 4;

        // Place defenders at positions from (4,4) to (6,4)
        while (i >= 4 && i < 7) {
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            this._defenders.get(k).setName("D" + n);
            this._board[i][j].setPieceSteppedOn();
            i++;
            k++;
            n++;
        }

        // Place defenders at positions from (3,5) to (7,5), excluding (5,5)
        i = 3;
        j = 5;
        while (i >= 3 && i < 8) {

            // Place the king at position (5,5)
            if ( i == 5) {
                this._board[i][j].setPiece(this._king);
                this._board[i][j].getPiece().addPos(new Position(i, j));
                this._board[i][j].incrementSteppedOn();

                //this._defenders.get(k).setName("K7");
                this._king.setName("K7");
                this._board[i][j].setPieceSteppedOn();

                i++;
                n++;
            }
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            this._defenders.get(k).setName("D" + n);
            this._board[i][j].setPieceSteppedOn();
            n++;
            i++;
            k++;
        }

        // Place defenders at positions from (4,6) to (6,6)
        i = 4;
        j = 6;
        while (i >= 4 && i < 7) {
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].incrementSteppedOn();

            this._defenders.get(k).setName("D" +n);
            this._board[i][j].setPieceSteppedOn();
            i++;
            k++;
            n++;
        }

        // Place a defender at position (5,7)
        this._board[5][7].setPiece(this._defenders.get(k));
        this._board[5][7].getPiece().addPos(new Position(5, 7));
        this._board[5][7].incrementSteppedOn();

        this._defenders.get(k).setName("D13");
        this._board[5][7].setPieceSteppedOn();
    }


    @Override
    public boolean move(Position a, Position b) {
        // Get the piece at the current position
        Piece piece = getPieceAtPosition(a);
        int currX = a.getX(), currY = a.getY(), destX = b.getX(), destY = b.getY();

        // Check if the piece belongs to the current player
        if (!piece.getOwner().equals(this._current)) {
            return false;
        }

        // Check if the move is valid
        if (!isValidMove((ConcretePiece) piece,a, b)) {
            return false;
        }

        // Move the piece to the new position
        this._board[destX][destY].setPiece((ConcretePiece) piece);
        this._board[currX][currY].setPiece(null);

        // If the piece is a Pawn ,and if it captures another piece, increase its eat count
        if (!(piece instanceof King)) {
            Pawn pawn = (Pawn) piece;
            isCaptured(b,pawn);
        }

        // If the piece is a King, update the current King's position
        if (piece instanceof King) {
            _currentKingPos = b;
        }

        // Add the new position to the piece's position history
        ((ConcretePiece) piece).addPos(b);

        // Update the number of squares the piece has moved
        if (currX == destX) {
            int dy = Math.abs(currY - destY);
            ((ConcretePiece) piece).setSquares(dy);
        } else if (destY == currY) {
            int dx = Math.abs(currX - destX);
            ((ConcretePiece) piece).setSquares(dx);
        }

        // Increment the number of times a piece has stepped on the destination square
        this._board[destX][destY].incrementSteppedOn();
        // Check if the piece's name is already in the list of pieces that have stepped on the square
        boolean isPresent = false;
        for (String str : this._board[destX][destY].getPieceSteppedOn()) {
            if (str != null && str.equals(((ConcretePiece) piece).getName())) {
                isPresent = true;
                break;
            }

        }

        // If the piece's name is not in the list, add it
        if (!isPresent && ((ConcretePiece) piece).getName() != null) {
            this._board[destX][destY].getPieceSteppedOn().add(((ConcretePiece) piece).getName());
        }

        // Check if the game is finished
        boolean gameOver = isGameFinished();
        if (gameOver) {
            // If the game is over, print the move history, kill sum, square history, and position history
            // The specific lists of winning and losing pieces depend on whether the King is at the edge or surrounded
            ArrayList<ConcretePiece> wining = new ArrayList<>();
            ArrayList<ConcretePiece> losing = new ArrayList<>();
            ArrayList<Pawn> winingByKills = new ArrayList<>();
            ArrayList<Pawn> losingByKills = new ArrayList<>();

            if (isKingAtEdge()) {
                wining = new ArrayList<>(this._defenders);
                wining.add(this._king);
                losing = new ArrayList<>(this._attackers);
                printHistoryMove(wining, losing);

                winingByKills = new ArrayList<>(this._defenders);
                losingByKills = new ArrayList<>(this._attackers);
                printKillSum(winingByKills, losingByKills);
                printSquareHistory(wining, losing);
                printPositionHistory();
            }
            else if (isKingCaptured(this._currentKingPos)) {
                wining = new ArrayList<>(this._attackers);
                losing = new ArrayList<>(_defenders);
                losing.add(this._king);
                printHistoryMove(wining, losing);

                winingByKills = new ArrayList<>(this._attackers);
                losingByKills = new ArrayList<>(this._defenders);
                printKillSum(winingByKills, losingByKills);
                printSquareHistory(wining, losing);
                printPositionHistory();
            }
        }

        // Change the turn to the other player
        changeTurn();
        // The move was successful
        return true;
    }


    /**
     * This method checks if a move from position 'a' to position 'b' is valid for a given piece.
     * @param piece the ConcretePiece that is to be moved.
     * @param a the current position of the piece.
     * @param b the destination position of the piece.
     * @return true if the move is valid, false otherwise.
     */
    private boolean isValidMove(ConcretePiece piece,Position a, Position b) {
        int currX = a.getX(), currY = a.getY(), destX = b.getX(), destY = b.getY();

        // Check if the piece is not a King and the destination is a corner, otherwise return false
        if (!(piece instanceof King) && ((destX == 0 && destY == 0) || (destX == 10 && destY == 0)
                || (destX == 10 && destY == 10) || (destX == 0 && destY == 10))) {
            return false;
        }
        // checks if the piece can move horizontally, if another piece is blocking, returns false
        if ((currY == destY) && (currX != destX)) {
            int min = Math.min(currX + 1, destX);
            int max = Math.max(currX - 1, destX);
            for (int i = min; i <= max ; i++) {
                if (this._board[i][currY].getPiece() != null) {
                    return false;
                }
            }
            // checks if the piece can move vertically, if another piece is blocking, returns false
        } else if ((currX == destX) && (currY != destY)) {
            int min = Math.min(currY + 1, destY);
            int max = Math.max(currY - 1, destY);
            for (int i = min; i <= max; i++) {
                if ((this._board[currX][i].getPiece() != null)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    /**
     * This method checks if a pawn is capturing another opponent's pawn at a given position.
     * @param position the current position of the pawn.
     * @param pawn the pawn that is being moved.
     */
    private void isCaptured(Position position, Pawn pawn) {
        int x  = position.getX(), y = position.getY();
        boolean captured = false;

        // Check if the pawn is at the top edge of the board and there is an opponent's piece above it
        if ((x== 1) && (this._board[x - 1][y].getPiece() != null)
                && !(this._board[x - 1][y].getPiece().getOwner().equals(this._current))
        &&!(this._board[x - 1][y].getPiece() instanceof King)) {
            this._board[x - 1][y].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn is at the bottom edge of the board and there is an opponent's piece below it
        if ((x== 9) && (this._board[x + 1][y].getPiece() != null)
                && !(this._board[x + 1][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x + 1][y].getPiece() instanceof King)) {
            this._board[x + 1][y].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn is at the left edge of the board and there is an opponent's piece to its left
        if ((y== 1) && (this._board[x][y - 1].getPiece() != null)
                && !(this._board[x][y - 1].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y - 1].getPiece() instanceof King)) {
            this._board[x][y - 1].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn is at the right edge of the board and there is an opponent's piece to its right
        if ((y == 9) && (this._board[x][y + 1].getPiece() != null)
                && !(this._board[x][y + 1].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y + 1].getPiece() instanceof King)) {
            this._board[x][y + 1].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn can capture an opponent's piece to its right
        if ((x <= 8) && (this._board[x+1][y].getPiece() != null)
                && !(this._board[x+1][y].getPiece().getOwner().equals(this._current))
                && (this._board[x + 2][y] .getPiece() != null) &&
                (this._board[x+2][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x + 1][y].getPiece() instanceof King)) {
            this._board[x+1][y].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn can capture an opponent's piece to its left
        if ((x >= 2) && (this._board[x-1][y].getPiece() != null)
                && !(this._board[x-1][y].getPiece().getOwner().equals(this._current))
                && (this._board[x - 2][y] .getPiece() != null) &&
                (this._board[x-2][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x - 1][y].getPiece() instanceof King)) {
            this._board[x-1][y].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn can capture an opponent's piece above it
        if ((y <= 8) && (this._board[x][y + 1].getPiece() != null)
                && !(this._board[x][y + 1].getPiece().getOwner().equals(this._current))
                && (this._board[x][y + 2].getPiece() != null) &&
                (this._board[x][y + 2].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y + 1].getPiece() instanceof King)) {
            this._board[x][y + 1].setPiece(null);

            pawn.increaseEat();
        }

        // Check if the pawn can capture an opponent's piece below it
        if ((y >= 2 )&& (this._board[x][y - 1].getPiece() != null) &&
                !(this._board[x][y - 1].getPiece().getOwner().equals(this._current))
                && (this._board[x][y - 2] .getPiece() != null) &&
                (this._board[x][y - 2].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y - 1].getPiece() instanceof King)) {
            this._board[x][y - 1].setPiece(null);

            pawn.increaseEat();
        }
    }



    /**
     * Changes the turn from the current player to the other player.
     * If the current player is the defender, the turn is changed to the attacker.
     * If the current player is the attacker, the turn is changed to the defender.
     */
    private void changeTurn() {
        if (this._current == this._defender) {
            this._current = this._attacker;
        }
        else {
            this._current = this._defender;
        }
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        int x = position.getX(), y = position.getY();
        return this._board[x][y].getPiece();
    }

    @Override
    public Player getFirstPlayer() {
        return this._defender;
    }

    @Override
    public Player getSecondPlayer() {
        return this._attacker;
    }

    @Override
    public boolean isGameFinished() {

        // king is at one of the board corners, the defender won
        if (isKingAtEdge()) {

            return true;
        }

        // king has been eaten, the attacker won

        return isKingCaptured(this._currentKingPos);
    }

    /**
     * This method checks if a King piece is located at any of the four corners of the game board.
     * The corners are defined as the top-left, top-right, bottom-left, and bottom-right positions.
     *
     * @return true if a King is located at any of the four corners, false otherwise.
     */
    private boolean isKingAtEdge() {
        Position topLeft = new Position(0,0);
        Position topRight = new Position(0, 10);
        Position bottomLeft = new Position(10, 0);
        Position bottomRight = new Position(10, 10);
        return (getPieceAtPosition(topLeft) instanceof King) || (getPieceAtPosition(topRight) instanceof King)
                || (getPieceAtPosition(bottomRight) instanceof King) || (getPieceAtPosition(bottomLeft) instanceof King);
    }


    /**
     * Checks if the King at a given position is captured.
     *
     * @param position The position of the King on the board.
     * @return true if the King is captured, false otherwise.
     */
    private boolean isKingCaptured(Position position) {
        int x = position.getX(), y = position.getY();

        // Check if the piece at the given position is a King
        if (!(this._board[x][y].getPiece() instanceof King)) {
            return false;
        }

        // Check if the King is surrounded on all four sides or three sides and a wall
        // This is done by checking the pieces on all four sides of the King
        // If all the pieces are not null, not owned by the defender, and the King is not at the edge of the board,
        // or if the King is at the edge of the board and is surrounded on the other three sides,
        // then the King is captured
        if ((x > 0 && x < 10 && y > 0 && y < 10 &&
                this._board[x - 1][y].getPiece() != null &&
                !(this._board[x - 1][y].getPiece().getOwner().equals(this._defender)) &&
                this._board[x + 1][y].getPiece() != null &&
                !(this._board[x + 1][y].getPiece().getOwner().equals(this._defender)) &&
                this._board[x][y - 1].getPiece() != null &&
                !(this._board[x][y - 1].getPiece().getOwner().equals(this._defender)) &&
                this._board[x][y + 1].getPiece() != null &&
                !(this._board[x][y + 1].getPiece().getOwner().equals(this._defender))) ||
                (x == 0 &&
                        this._board[x + 1][y].getPiece() != null &&
                        !(this._board[x + 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y - 1].getPiece() != null &&
                        !(this._board[x][y - 1].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y + 1].getPiece() != null &&
                        !(this._board[x][y + 1].getPiece().getOwner().equals(this._defender))) ||
                (x == 10 &&
                        this._board[x - 1][y].getPiece() != null &&
                        !(this._board[x - 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y - 1].getPiece() != null &&
                        !(this._board[x][y - 1].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y + 1].getPiece() != null &&
                        !(this._board[x][y + 1].getPiece().getOwner().equals(this._defender))) ||
                (y == 0 &&
                        this._board[x - 1][y].getPiece() != null &&
                        !(this._board[x - 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x + 1][y].getPiece() != null &&
                        !(this._board[x + 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y + 1].getPiece() != null &&
                        !(this._board[x][y + 1].getPiece().getOwner().equals(this._defender))) ||
                (y == 10 &&
                        this._board[x - 1][y].getPiece() != null &&
                        !(this._board[x - 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x + 1][y].getPiece() != null &&
                        !(this._board[x + 1][y].getPiece().getOwner().equals(this._defender)) &&
                        this._board[x][y - 1].getPiece() != null &&
                        !(this._board[x][y - 1].getPiece().getOwner().equals(this._defender)))) {
            return true;
        }

        return false;
    }



    @Override
    public boolean isSecondPlayerTurn() {
        return this._current == this._attacker;
    }

    @Override
    public void reset() {
        init();
    }

    @Override
    public void undoLastMove() {
    }

    @Override
    public int getBoardSize() {
        return this._BOARD_SIZE;
    }


    /**
     * Prints the move history of each piece in the game.
     *
     * @param wining A list of pieces from the winning side.
     * @param losing A list of pieces from the losing side.
     */
    private void printHistoryMove(List<ConcretePiece> wining, List<ConcretePiece> losing) {
        // Sort the pieces by the number of steps they have taken
        wining.sort(new CompareByStep());
        losing.sort(new CompareByStep());

        // Print the move history for each piece from the winning side
        for (ConcretePiece piece : wining) {
            // Skip pieces that have only moved once
            if (piece.getMoveNum() == 1){
                continue;
            } else {
                System.out.println(piece.getName() + ": " + piece.getPositionsHistory().toString());
            }
        }

        // Print the move history for each piece from the losing side
        for (ConcretePiece piece : losing) {
            // Skip pieces that have only moved once
            if (piece.getMoveNum() == 1){
                continue;
            } else {
                System.out.println(piece.getName() + ": " + piece.getPositionsHistory().toString());
            }
        }
        // Print a separator line
        System.out.println("*".repeat(75));
    }


    /**
     * Prints the number of kills for each Pawn in the game.
     *
     * @param wining A list of Pawns from the winning side.
     * @param losing A list of Pawns from the losing side.
     */
    private void printKillSum(List<Pawn> wining, List<Pawn> losing) {
        // Combine the lists of Pawns from the winning and losing sides
        ArrayList<Pawn> combinedPawns = new ArrayList<>(wining);
        combinedPawns.addAll(losing);
        // Sort the combined list of Pawns by the number of kills
        combinedPawns.sort(comparatorByNameKill);

        // Print the number of kills for each Pawn
        for (Pawn pawn : combinedPawns) {
            // Skip Pawns that have not made any kills
            if (pawn.getEatCount() < 1) {
                // Print a separator line
                continue;
            } else {
                System.out.println(pawn.getName() + ": " + pawn.getEatCount() + " kills");
            }
        }
        System.out.println("*".repeat(75));
    }


    /**
     * Prints the number of squares each piece has moved.
     *
     * @param wining A list of pieces from the winning side.
     * @param losing A list of pieces from the losing side.
     */
    private void printSquareHistory(ArrayList<ConcretePiece> wining, ArrayList<ConcretePiece> losing) {
        // Combine the lists of pieces from the winning and losing sides
        ArrayList<ConcretePiece> combined = new ArrayList<>(wining);
        combined.addAll(losing);
        // Sort the combined list of pieces by the number of squares they have moved
        combined.sort(comparatorBySquares);

        // Print the number of squares each piece has moved
        for (ConcretePiece piece : combined) {
            // Skip pieces that have not moved
            if (piece.getSquares() < 1) {
                continue;
            } else {
                System.out.println(piece.getName() + ": " + piece.getSquares() + " squares");
            }
        }

        // Print a separator line
        System.out.println("*".repeat(75));
    }


    /**
     * Prints the history of pieces that have stepped on each position on the board.
     *
     * This method converts the 2D array of positions to a list, sorts the list,
     * and then prints the number of pieces that have stepped on each position.
     */
    private void printPositionHistory() {

        // Convert the 2D array to a list
        List<Position> positionList = new ArrayList<>();

        for (Position[] row : this._board) {
            positionList.addAll(Arrays.asList(row));
        }

        // Sort the list of positions
        positionList.sort(comparatorByPosition);

        // Print the number of pieces that have stepped on each position
        for (Position pos : positionList) {
            // Skip positions that have been stepped on by only one piece
            if (pos.getPieceSteppedOn().size() <= 1) {
                continue;
            } else {
                System.out.println(pos.toString() + pos.getStepOnCount() + " pieces");
            }
        }

        // Print a separator line
        System.out.println("*".repeat(75));
    }


    /**
     * This class implements the Comparator interface to compare two ConcretePiece objects based on their move numbers.
     * If the move numbers are equal, it compares the integer parts of their names.
     */
     class CompareByStep implements Comparator<ConcretePiece> {

        /**
         * Compares two ConcretePiece objects.
         *
         * @param p1 The first ConcretePiece object.
         * @param p2 The second ConcretePiece object.
         * @return A negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
         */
        @Override
        public int compare(ConcretePiece p1, ConcretePiece p2) {
            // Compare the move numbers of the two pieces
            int moveComparison = Integer.compare(p1.getMoveNum(), p2.getMoveNum());

            // If the move numbers are not equal, return the result of the comparison
            if (moveComparison != 0) {
                return moveComparison;
            }

            // If the move numbers are equal, compare the integer parts of the names of the two pieces
            return Integer.compare(ConcretePiece.getIntPart(p1.getName()), ConcretePiece.getIntPart(p2.getName()));
        }
    }



    /**
     * This comparator is used to compare two Pawn objects based on their kill count, name, and number of wins.
     * The comparison is performed in the following order:
     *
     * 1. **Kill Count (Descending Order)**: The Pawn with more kills is considered greater.
     *    If both Pawns have the same number of kills, the comparison proceeds to the next criterion.
     *
     * 2. **Integer Part of Name (Ascending Order)**: The Pawn with a smaller integer part in its name is considered greater.
     *    If both Pawns have the same integer part in their names, the comparison proceeds to the next criterion.
     *
     * 3. **Number of Wins (Descending Order)**: The Pawn whose owner has more wins is considered greater.
     *
     * @param p1 the first Pawn to be compared.
     * @param p2 the second Pawn to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    Comparator<Pawn> comparatorByNameKill = (Pawn p1, Pawn p2) -> {
        // Compare by kill count in descending order
        int killComparison = Integer.compare(p2.getEatCount(), p1.getEatCount());
        if (killComparison != 0) {
            return killComparison;
        }

        // If kill count is equal, compare by the integer part of the name in ascending order
        int nameComparison = Integer.compare(ConcretePiece.getIntPart(p1.getName()), ConcretePiece.getIntPart(p2.getName()));
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If the integer part of the name is also equal, compare by the number of wins in descending order
        return Integer.compare(p2.getOwner().getWins(), p1.getOwner().getWins());
    };


    /**
     * This comparator is used to compare two ConcretePiece objects based on their square count, name, and number of wins.
     * The comparison is performed in the following order:
     *
     * 1. **Square Count (Descending Order)**: The ConcretePiece with more squares is considered greater.
     *    If both ConcretePieces have the same number of squares, the comparison proceeds to the next criterion.
     *
     * 2. **Integer Part of Name (Ascending Order)**: The ConcretePiece with a smaller integer part in its name is considered greater.
     *    If both ConcretePieces have the same integer part in their names, the comparison proceeds to the next criterion.
     *
     * 3. **Number of Wins (Descending Order)**: The ConcretePiece whose owner has more wins is considered greater.
     *
     * @param p1 the first ConcretePiece to be compared.
     * @param p2 the second ConcretePiece to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    Comparator<ConcretePiece> comparatorBySquares = (ConcretePiece p1, ConcretePiece p2) -> {
        // Compare by square count in descending order
        int squaresComparison = Integer.compare(p2.getSquares(), p1.getSquares());
        if (squaresComparison != 0) {
            return squaresComparison;
        }

        // If square count is equal, compare by the integer part of the name in ascending order
        int nameComparison = Integer.compare(ConcretePiece.getIntPart(p1.getName()), ConcretePiece.getIntPart(p2.getName()));
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If the integer part of the name is also equal, compare by the number of wins in descending order
        return Integer.compare(p2.getOwner().getWins(), p1.getOwner().getWins());

    };


    /**
     * This comparator is used to compare two Position objects based on their step count and coordinates.
     * The comparison is performed in the following order:
     *
     * 1. **Step Count (Descending Order)**: The Position with more steps is considered greater.
     *    If both positions have the same number of steps, the comparison proceeds to the next criterion.
     *
     * 2. **X Coordinate (Ascending Order)**: The Position with a smaller X coordinate is considered greater.
     *    If both positions have the same X coordinate, the comparison proceeds to the next criterion.
     *
     * 3. **Y Coordinate (Ascending Order)**: The Position with a smaller Y coordinate is considered greater.
     *
     * @param p1 the first Position to be compared.
     * @param p2 the second Position to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than the second.
     */
    Comparator<Position> comparatorByPosition = (Position p1, Position p2) -> {
        // Compare by step count in descending order
        int positionComparison = Integer.compare(p2.getStepOnCount(), p1.getStepOnCount());

        if (positionComparison != 0) {
            return positionComparison;
        }

        // If step count is equal, compare by the X coordinate in ascending order
        int xComparison = Integer.compare(p1.getX(), p2.getX());
        int yComparison = Integer.compare(p1.getY(), p2.getY());

        if (xComparison != 0) {
            return xComparison;
        }

        // If the X coordinate is also equal, compare by the Y coordinate in ascending order
        return yComparison;
    };
}
