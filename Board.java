
import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Write a description of class ticatactoe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private static int dimensions = 3;

    public static boolean boardFilled(JButton board[][]) {
      for (int i = 0; i < dimensions; i++) {
          for (int j = 0; j < dimensions; j++) {
              if (board[i][j].getText().equals("")) return false;
          }
      }
      return true;
    }

    public static int checkRows(JButton board[][], String startingPlayer) {
      String last = "";
      for (int i = 0; i < dimensions; i++) {
        for (int j = 0; j < dimensions; j++) {
          if (j == 0) {
            if (!board[i][j].getText().equals("")) {
              last = board[i][j].getText();
            }
            else {
              break;
            }
          }
          else if (!board[i][j].getText().equals(last)) {
            break;
          }
          else {
            if (j == dimensions-1) {
              if (last.equals(startingPlayer)) {
                return 1;
              }
              else {
                return 0;
              }
            }
          }
        }
      }
      return -1;
    }

    public static int checkColumns(JButton board[][], String startingPlayer) {
      String last = "";
      for (int i = 0; i < dimensions; i++) {
        for (int j = 0; j < dimensions; j++) {
          if (j == 0) {
            if (!board[i][j].getText().equals("")) {
              last = board[j][i].getText();
            }
            else {
              break;
            }
          }
          else if (!board[i][j].getText().equals(last)) {
            break;
          }
          else {
            if (j == dimensions-1) {
              if (last.equals(startingPlayer)) {
                return 1;
              }
              else {
                return 0;
              }
            }
          }
        }
      }
      return -1;
    }


    public static int checkDiag(JButton board[][], String startingPlayer) {
      String last = "";
      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (!board[i][i].getText().equals("")) {
            last = board[i][i].getText();
          }
          else {
            break;
          }
        }
        else if (!board[i][i].getText().equals(last)) {
          break;
        }
        else {
          if (i == dimensions-1) {
            if (last.equals(startingPlayer)) {
              return 1;
            }
            else {
              return 0;
            }
          }
        }
      }

      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (!board[i][board[i].length-i-1].getText().equals("")) {
            last = board[i][board[i].length-i-1].getText();
          }
          else {
            break;
          }
        }
        else if (!board[i][board[i].length-i-1].getText().equals(last)) {
          break;
        }
        else {
          if (i == dimensions-1) {
            if (last.equals(startingPlayer)) {
              return 1;
            }
            else {
              return 0;
            }
          }
        }
      }
      return -1;
    }
    /*
    public static boolean hasEnded() {

      if (boardFilled() || checkRows() || checkColumns() || checkDiag()) {
          return true;
      }
      else {
        return false;
      }
    }

    public static int[] checkWin() {

      // DIAGONAL

      int last = 6;
      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (board[i][i] != 0) {
            last = board[i][i];
          }
        }
        else if (board[i][i] != last) {
          last = board[i][i];
        }
        else {
          if (board[i][i] != 0) {
              for (int j = 0; j < dimensions; j++) {
                if (board[j][j] == 0) {
                   int[] ans = {j,j};
                   return ans;
                }
              }
          }
        }
      }

      //OTHER DIAGONAL

      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (board[i][board.length-1-i] != 0) {
            last = board[i][board.length-1-i];
          }
        }
        else if (board[i][board.length-1-i] != last) {
          last = board[i][board.length-1-i];
        }
        else {
          if (board[i][board.length-1-i] != 0) {
              for (int j = 0; j < dimensions; j++) {
                if (board[j][board.length-1-j] == 0) {
                   int[] ans = {j,board.length-1-j};
                   return ans;
                }
              }
          }
        }
      }

      last = 6;
      for (int i = 0; i < dimensions; i++) {
        for (int j = 0; j < dimensions; j++) {
          if (j == 0) {
            if (board[i][j] != 0) {
              last = board[i][j];
            }
          }
          else if (board[i][j] != last) {
            if (board[i][j] != 0) {
              last = board[i][j];
            }
          }
          else {
            if (board[i][j] != 0) {
              for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == 0) {
                  int[] ans = {i,k};
                  return ans;
                }
              }
            }
          }
        }
      }

      int[] fail = {-1,-1};
      return fail;
    }
    */
}
