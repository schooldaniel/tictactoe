// ============================================================================
//    Taken and adapted from: http://programmingnotes.org/
// ============================================================================
import javax.swing.*;
import java.awt.*;

public class Logic
{

    private static boolean firstP = true;
    public static void getMove(int rowMove, int colMove, int move, Font font, JButton square[][],
    String startingPlayer)
    {   // gets the current move "X" or "O" for the user & displays to screen
        square[rowMove][colMove].setFont(font);

        //TODO: create logic to set which player made the move
        if (firstP) {
          square[rowMove][colMove].setText(startingPlayer);
        }
        else {
          if (startingPlayer.equals("O")) {
            square[rowMove][colMove].setText("X");
          }
          else {
            square[rowMove][colMove].setText("O");
          }
        }
        firstP = !firstP;

    }

    public static int checkWin(JButton square[][], String startingPlayer)
    {
        if (Board.boardFilled(square)) {
          return 2;
        }
        else if (Board.checkRows(square, startingPlayer) != -1) {
          return Board.checkRows(square, startingPlayer);
        }
        else if (Board.checkColumns(square, startingPlayer) != -1) {
          return Board.checkColumns(square, startingPlayer);
        }
        else if (Board.checkDiag(square, startingPlayer) != -1) {
          return Board.checkDiag(square, startingPlayer);
        }
        return -1;
    }

    public static void showGame(JPanel pnlSouth, JPanel pnlPlayingField)
    {   // shows the Playing Field
        pnlSouth.setLayout(new BorderLayout());
        pnlSouth.add(pnlPlayingField, BorderLayout.CENTER);
        pnlPlayingField.requestFocus();
    }

    public static void clearPanelSouth(JPanel pnlSouth, JPanel pnlTop,
    JPanel pnlNewGame, JPanel pnlPlayingField, JPanel pnlBottom, JPanel radioPanel)
    {   // clears any posible panels on screen
        pnlSouth.remove(pnlTop);
        pnlSouth.remove(pnlBottom);
        pnlSouth.remove(pnlPlayingField);
        pnlTop.remove(pnlNewGame);
        pnlSouth.remove(radioPanel);
    }
}
