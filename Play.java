
/**
 * Write a description of class Play here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Play
{
    public static void main (String args[]) {
        Board board = new Board();

        boolean hasFriends = board.hasFriend();
        board.boardDim();
        while (true) {
            board.displayBoard();
            board.promptTurn(2);
            if (board.hasEnded()) {
              board.displayBoard();
              break;
            }
            board.displayBoard();
            board.CompTurn();
        }
    }
}
