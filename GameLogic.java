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


    // this function initialize the board with pieces for each player at a starting point
    private void init() {
        this._king = new King(this._defender);
        this._defenders = new ArrayList<Pawn>();
        this._attackers = new ArrayList<Pawn>();
        this._current = this._attacker;
        this._currentKingPos = new Position(7, 7);
        for (int i = 0; i < _attackersNums; i++) {
            this._attackers.add(new Pawn(this._attacker));
        }

        for (int i = 0; i < _defenderNums; i++) {
            this._defenders.add(new Pawn(this._defender));
        }
        this._board = new Position[11][11];
        for (int i = 0; i < getBoardSize() ; i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                this._board[i][j] = new Position(i, j);
            }
        }
        int i = 0, j = 3, k = 0 , n = 7;
        // initialize attackers
        while (j>= 3 && j<8 ) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].setPieceSteppedOn();
            this._board[i][j].increamnetStepedOn();
            if (n == 13) {
                n = 15;
            }
            this._attackers.get(k).setName("A" + n);
            n += 2;
            j++;
            k++;
        }

        this._board[1][5].setPiece(this._attackers.get(k));
        this._board[1][5].getPiece().addPos(new Position(1, 5));
        this._board[1][5].increamnetStepedOn();
        this._board[1][5].setPieceSteppedOn();
        this._attackers.get(k).setName("A12");
        k++;

         j = 0;
         i = 3;
         n = 1;
         while (i >= 3 && i < 8) {
             this._board[i][j].setPiece(this._attackers.get(k));
             this._board[i][j].getPiece().addPos(new Position(i, j));
             this._board[i][j].increamnetStepedOn();
             this._board[i][j].setPieceSteppedOn();
             this._attackers.get(k).setName("A" + n);
             i++;
             k++;
             n++;
         }

        this._board[5][1].setPiece(this._attackers.get(k));
        this._board[5][1].getPiece().addPos(new Position(5, 1));
        this._board[5][1].increamnetStepedOn();
        this._board[5][1].setPieceSteppedOn();
         this._attackers.get(k).setName("A6");
         k++;

         i = 10;
         j = 3;
         n = 8;
         while (j >= 3 && j < 8) {
             this._board[i][j].setPiece(this._attackers.get(k));
             this._board[i][j].getPiece().addPos(new Position(i, j));
             this._board[i][j].increamnetStepedOn();
             this._board[i][j].setPieceSteppedOn();
             if (n == 12) {
                n = 14;
             }
             this._attackers.get(k).setName("A" + n);
             n += 2;
             j++;
             k++;
         }

        this._board[9][5].setPiece(this._attackers.get(k));
        this._board[9][5].getPiece().addPos(new Position(9, 5));
        this._board[9][5].increamnetStepedOn();
        this._board[9][5].setPieceSteppedOn();
        this._attackers.get(k).setName("A13");
        k++;

         i = 3;
         j = 10;
         n = 20;
        while (i >= 3 && i < 8) {
            this._board[i][j].setPiece(this._attackers.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].increamnetStepedOn();
            this._board[i][j].setPieceSteppedOn();
            this._attackers.get(k).setName("A" + n);
            i++;
            k++;
            n++;
        }

        this._board[5][9].setPiece(this._attackers.get(k));
        this._board[5][9].getPiece().addPos(new Position(5, 9));
        this._board[5][9].increamnetStepedOn();
        this._board[5][9].setPieceSteppedOn();
        this._attackers.get(k).setName("A19");

        // initialize defenders
        k = 0;
        n = 2;
        this._board[5][3].setPiece(this._defenders.get(k));
        this._board[5][3].getPiece().addPos(new Position(5, 3));
        this._board[5][3].increamnetStepedOn();
        this._board[5][3].setPieceSteppedOn();
        this._defenders.get(k).setName("D1");
        k++;

        i = 4;
        j = 4;
        while (i >= 4 && i < 7) {
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].increamnetStepedOn();
            this._board[i][j].setPieceSteppedOn();
            this._defenders.get(k).setName("D" + n);
            i++;
            k++;
            n++;
        }

        i = 3;
        j = 5;
        while (i >= 3 && i < 8) {
            if ( i == 5) {
                this._board[i][j].setPiece(this._king);
                this._board[i][j].getPiece().addPos(new Position(i, j));
                this._board[i][j].increamnetStepedOn();
                this._board[i][j].setPieceSteppedOn();
                //this._defenders.get(k).setName("K7");
                this._king.setName("K7");

                i++;
                n++;
            }
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].increamnetStepedOn();
            this._board[i][j].setPieceSteppedOn();
            this._defenders.get(k).setName("D" + n);
            n++;
            i++;
            k++;
        }

        i = 4;
        j = 6;
        while (i >= 4 && i < 7) {
            this._board[i][j].setPiece(this._defenders.get(k));
            this._board[i][j].getPiece().addPos(new Position(i, j));
            this._board[i][j].increamnetStepedOn();
            this._board[i][j].setPieceSteppedOn();
            this._defenders.get(k).setName("D" +n);
            i++;
            k++;
            n++;
        }
        this._board[5][7].setPiece(this._defenders.get(k));
        this._board[5][7].getPiece().addPos(new Position(i, j));
        this._board[5][7].increamnetStepedOn();
        this._board[5][7].setPieceSteppedOn();
        this._defenders.get(k).setName("D13");



    }
    @Override
    public boolean move(Position a, Position b) {

        Piece piece = getPieceAtPosition(a);
        int currX = a.getX(), currY = a.getY(), destX = b.getX(), destY = b.getY();
        // if the piece is not current's player
        if (!piece.getOwner().equals(this._current)) {
            return false;
        }
        if (!isValidMove((ConcretePiece) piece,a, b)) {
            return false;
        }


        this._board[destX][destY].setPiece((ConcretePiece) piece);
        this._board[currX][currY].setPiece(null);
//        if (!(piece instanceof King)) {
//            isCaptured(b);
//
//        }
        if (!(piece instanceof King) && isCaptured(b)) {
            Pawn pawn = (Pawn) piece;
            pawn.increaseEat();
        }
        if (piece instanceof King) {
            _currentKingPos = b;
        }
        ((ConcretePiece) piece).addPos(b);
        if (currX == destX) {
            int dy = Math.abs(currY - destY);
            ((ConcretePiece) piece).setSquares(dy);
        } else if (destY == currY) {
            int dx = Math.abs(currX - destX);
            ((ConcretePiece) piece).setSquares(dx);
        }
        this._board[destX][destY].increamnetStepedOn();
        for (String str : this._board[destX][destY].getPieceSteppedOn()) {
            if (str.equals(((ConcretePiece) piece).getName())) {
                break;
            }
            this._board[destX][destY].getPieceSteppedOn().add(str);
        }
        changeTurn();
        return true;
    }

//    private boolean isValidMove(ConcretePiece piece,Position a, Position b) {
//        int currX = a.getX(), currY = a.getY(), destX = b.getX(), destY = b.getY();
//
//        if (!(piece instanceof King) && ((destX == 0 && destY == 0) || (destX == 10 && destY == 0)
//                || (destX == 10 && destY == 10) || (destX == 0 && destY == 10))) {
//            return false;
//        }
//        // checks if the piece can move horizontally, if another piece is blocking, returns false
//        if ((currY == destY) && (currX != destX)) {
//            int min = Math.min(currX + 1, destX);
//            int max = Math.max(currX - 1, destX);
//            for (int i = min + 1; i <= max ; i++) {
//                if (this._board[i][currY].getPiece() != null) {
//                    return false;
//                }
//            }
//            // checks if the piece can move vertically, if another piece is blocking, returns false
//        } else if ((currX == destX) && (currY != destY)) {
//            int min = Math.min(currY + 1, destY);
//            int max = Math.max(currY - 1, destY);
//            for (int i = min; i <= max; i++) {
//                if ((this._board[currX][i].getPiece() != null)) {
//                    return false;
//                }
//            }
//        } else {
//            return false;
//        }
//        return true;
//    }
private boolean isValidMove(ConcretePiece piece,Position a, Position b) {
    int currX = a.getX(), currY = a.getY(), destX = b.getX(), destY = b.getY();

    if (!(piece instanceof King) && (destX == 0 && destY == 0) || (destX == 10 && destY == 0)
            || (destX == 10 && destY == 10) || (destX == 0 && destY == 10)) {
        return false;
    }
    // checks if the piece can move horizontally, if another piece is blocking, returns false
    // case 1: currX is smaller than destX
    if ((currY == destY) && (currX < destX)) {
        for (int i = currX + 1; i <= destX ; i++) {
            if (this._board[i][currY].getPiece() != null) {
                return false;
            }
        }
        // checks if the piece can move vertically, if another piece is blocking, returns false
        // case 1: currY is smaller than destY
    } else if ((currY == destY) && (currX > destX)) {
        for (int i = currX -1; i >= destX ; i--) {
            if (this._board[i][currY].getPiece() != null) {
                return false;
            }
        }
    } else if ((currX == destX) && (currY < destY)) {
        for (int i = currY + 1; i <= destY; i++) {
            if ((this._board[currX][i].getPiece() != null)) {
                return false;
            }
        }

    } else if ((currX == destX) && (currY > destY)) {
        for (int i = currY -1 ; i >= destY; i--) {
            if ((this._board[currX][i].getPiece() != null)) {
                return false;
            }
        }
    } else {
        return false;
    }
    return true;
}


    private boolean isCaptured(Position position) {
        int x  = position.getX(), y = position.getY();

        if ((x== 1) && (this._board[x - 1][y].getPiece() != null)
                && !(this._board[x - 1][y].getPiece().getOwner().equals(this._current))
        &&!(this._board[x - 1][y].getPiece() instanceof King)) {
            this._board[x - 1][y].setPiece(null);
            return true;
        }

        if ((x== 9) && (this._board[x + 1][y].getPiece() != null)
                && !(this._board[x + 1][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x + 1][y].getPiece() instanceof King)) {
            this._board[x + 1][y].setPiece(null);
            return true;
        }

        if ((y== 1) && (this._board[x][y - 1].getPiece() != null)
                && !(this._board[x][y - 1].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y - 1].getPiece() instanceof King)) {
            this._board[x][y - 1].setPiece(null);
            return true;
        }

        if ((y == 9) && (this._board[x][y + 1].getPiece() != null)
                && !(this._board[x][y + 1].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y + 1].getPiece() instanceof King)) {
            this._board[x][y + 1].setPiece(null);
            return true;
        }

        if ((x <= 8) && (this._board[x+1][y].getPiece() != null)
                && !(this._board[x+1][y].getPiece().getOwner().equals(this._current))
                && (this._board[x + 2][y] .getPiece() != null) &&
                (this._board[x+2][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x + 1][y].getPiece() instanceof King)) {
            this._board[x+1][y].setPiece(null);
            return true;
        }

        if ((x >= 2) && (this._board[x-1][y].getPiece() != null)
                && !(this._board[x-1][y].getPiece().getOwner().equals(this._current))
                && (this._board[x - 2][y] .getPiece() != null) &&
                (this._board[x-2][y].getPiece().getOwner().equals(this._current))
                &&!(this._board[x - 1][y].getPiece() instanceof King)) {
            this._board[x-1][y].setPiece(null);
            return true;
        }

        if ((y <= 8) && (this._board[x][y + 1].getPiece() != null)
                && !(this._board[x][y + 1].getPiece().getOwner().equals(this._current))
                && (this._board[x][y + 2].getPiece() != null) &&
                (this._board[x][y + 2].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y + 1].getPiece() instanceof King)) {
            this._board[x][y + 1].setPiece(null);
            return true;
        }

        if ((y >= 2 )&& (this._board[x][y - 1].getPiece() != null) &&
                !(this._board[x][y - 1].getPiece().getOwner().equals(this._current))
                && (this._board[x][y - 2] .getPiece() != null) &&
                (this._board[x][y - 2].getPiece().getOwner().equals(this._current))
                &&!(this._board[x][y - 1].getPiece() instanceof King)) {
            this._board[x][y - 1].setPiece(null);
            return true;
        }

        return false;
    }

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
        ArrayList<ConcretePiece> wining = new ArrayList<>();
        ArrayList<ConcretePiece> losing = new ArrayList<>();
        ArrayList<Pawn> winingByKills = new ArrayList<>();
        ArrayList<Pawn> losingByKills = new ArrayList<>();





        // king is at one of the board corners
        if (isKingAtEdge()) {
            wining = new ArrayList<>(this._defenders);
            wining.add(this._king);
            losing = new ArrayList<>(this._attackers);
            printHistoryMove(wining, losing);

            winingByKills = new ArrayList<>(this._defenders);
            losingByKills = new ArrayList<>(this._attackers);
            printKillSum(winingByKills, losingByKills);
            printSquareHistory(wining, losing);
            return true;
        }

        // king has been eaten
        // TODO: if king is surrounded from any place on the board, then the game is over

        if  (isKingCaptured(this._currentKingPos)) {
            wining = new ArrayList<>(this._attackers);
            losing = new ArrayList<>(_defenders);
            losing.add(this._king);
            printHistoryMove(wining, losing);

            winingByKills = new ArrayList<>(this._attackers);
            losingByKills = new ArrayList<>(this._defenders);
            printKillSum(winingByKills, losingByKills);
            printSquareHistory(wining, losing);
            return true;
        }
        return false;
    }

    private boolean isKingAtEdge() {
        Position topLeft = new Position(0,0);
        Position topRight = new Position(0, 10);
        Position bottomLeft = new Position(10, 0);
        Position bottomRight = new Position(10, 10);
        return (getPieceAtPosition(topLeft) instanceof King) || (getPieceAtPosition(topRight) instanceof King)
                || (getPieceAtPosition(bottomRight) instanceof King) || (getPieceAtPosition(bottomLeft) instanceof King);
    }



    private boolean isKingCaptured(Position position) {
        int x = position.getX(), y = position.getY();

        // Check if the piece at the given position is a King
        if (!(this._board[x][y].getPiece() instanceof King)) {
            return false;
        }

        // Check if the King is surrounded on all four sides or three sides and a wall
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
            this._board[x][y].setPiece(null);
            return true;
        }

        return false;
    }





    private boolean isEmptyNeighbor(Position position) {
        int x = position.getX(), y = position.getY();
        return this._board[x + 1][y].getPiece() == null || this._board[x][y + 1].getPiece() == null
                || this._board[x - 1][y].getPiece() == null || this._board[x][y - 1].getPiece() == null;
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


    private void printHistoryMove(List<ConcretePiece> wining, List<ConcretePiece> losing) {
        wining.sort(new CompareByStep());
        losing.sort(new CompareByStep());
        for (ConcretePiece piece : wining) {
            if (piece.getMoveNum() == 1){
                continue;
            } else {
                System.out.println(piece.getName() + ":" + piece.getPositionsHistory().toString());
            }
        }
        for (ConcretePiece piece : losing) {
            if (piece.getMoveNum() == 1){
                continue;
            } else {
                System.out.println(piece.getName() + ":" + piece.getPositionsHistory().toString());
            }
        }
        System.out.println("*".repeat(75));

    }

    private void printKillSum(List<Pawn> wining, List<Pawn> losing) {
        ArrayList<Pawn> combinedPawns = new ArrayList<>(wining);
        combinedPawns.addAll(losing);
        combinedPawns.sort(comparatorByNameKill);
        for (Pawn pawn : combinedPawns) {
            if (pawn.getEatCount() < 1) {
                continue;
            } else {
                System.out.println(pawn.getName() + ":" + pawn.getEatCount() + " kills");
            }
        }
        System.out.println("*".repeat(75));
    }

    private void printSquareHistory(ArrayList<ConcretePiece> wining, ArrayList<ConcretePiece> losing) {
        ArrayList<ConcretePiece> combined = new ArrayList<>(wining);
        combined.addAll(losing);
        combined.sort(comparatorBySquares);
        for (ConcretePiece piece : combined) {
            if (piece.getSquares() < 1) {
                continue;
            } else {
                System.out.println(piece.getName() + ":" + piece.getSquares() + " squares");
            }
        }
        System.out.println("*".repeat(75));
    }

    private void printPositionHistory() {

        // Convert the 2D array to a list
        List<Position> positionList = new ArrayList<>();
        for (Position[] row : this._board) {
            positionList.addAll(Arrays.asList(row));
        }
        positionList.sort(comparatorByPosition);
    }

     class CompareByStep implements Comparator<ConcretePiece> {

        @Override
        public int compare(ConcretePiece p1, ConcretePiece p2) {

            return Integer.compare(p1.getMoveNum(), p2.getMoveNum());
        }
    }
    Comparator<Pawn>
            comparatorByKills = (Pawn p1, Pawn p2) -> {
        return Integer.compare(p2.getEatCount(), p1.getEatCount());
    };

//    Comparator<Pawn>
//    comparatorByNameKill = (Pawn p1, Pawn p2) -> {
//      if (p1.getEatCount() == p2.getEatCount()) {
//          return Integer.compare(ConcretePiece.getIntPart(p1.getName()), ConcretePiece.getIntPart(p2.getName()));
//      }
//          return Integer.compare(p1.getOwner().getWins(), p2.getOwner().getWins());
//
//    };

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

    Comparator<Position> comparatorByPosition = (Position p1, Position p2) -> {
        int positionComparison = Integer.compare(p2.getStepOnCount(), p1.getStepOnCount());

        if (positionComparison != 0) {
            return positionComparison;
        }
        int xComparison = Integer.compare(p1.getX(), p2.getX());
        int yComparison = Integer.compare(p1.getY(), p2.getY());
        if (xComparison != 0) {
            return xComparison;
        }
        return yComparison;

    };
}
