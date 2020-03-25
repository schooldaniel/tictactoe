import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class ticatactoe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private int[][] board;
    private int dimensions = 4;
    Scanner input = new Scanner(System.in);

    public boolean hasFriend() {
        System.out.println("Do you have friends?");
        String x = input.nextLine().toLowerCase();

        if (x == "y" || x == "yes") {
            return true;
        }
        else {
            System.out.println("wow ok");
            return false;
        }
    }

    public void boardDim() {
        System.out.println("What number of rows and columns would you like?");
        Integer x = input.nextInt();

        dimensions = x;
        board = new int[dimensions][dimensions];
        for (int i = 0; i < dimensions; i++) {
          for (int j = 0; j < dimensions; j++) {
            board[i][j] = 0;
          }
        }
    }

    public boolean boardFilled() {
      for (int i = 0; i < dimensions; i++) {
          for (int j = 0; j < dimensions; j++) {
              if (board[i][j] == 0) return false;
          }
      }
      return true;
    }

    public boolean checkRows() {
      int last = 6;
      for (int i = 0; i < dimensions; i++) {
        System.out.println(i);
        for (int j = 0; j < dimensions; j++) {
          if (j == 0) {
            if (board[i][j] != 0) {
              last = board[i][j];
            }
            else {
              break;
            }
          }
          else if (board[i][j] != last) {
            break;
          }
          else {
            if (j == dimensions-1) {
              return true;
            }
          }
        }
      }
      return false;
    }
    public boolean checkColumns() {
      int last = 6;
      for (int i = 0; i < dimensions; i++) {
        for (int j = 0; j < dimensions; j++) {
          if (j == 0) {
            if (board[j][i] != 0) {
              last = board[j][i];
            }
            else {
              break;
            }
          }
          else if (board[j][i] != last) {
            break;
          }
          else {
            if (j == dimensions-1) {
              return true;
            }
          }
        }
      }
      return false;
    }
    public boolean checkDiag() {
      int last = 6;
      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (board[i][i] != 0) {
            last = board[i][i];
          }
          else {
            break;
          }
        }
        else if (board[i][i] != last) {
          break;
        }
        else {
          if (i == dimensions-1) {
            return true;
          }
        }
      }

      for (int i = 0; i < dimensions; i++) {
        if (i == 0) {
          if (board[i][board[i].length-i-1] != 0) {
            last = board[i][board[i].length-i-1];
          }
          else {
            break;
          }
        }
        else if (board[i][board[i].length-i-1] != last) {
          break;
        }
        else {
          if (i == dimensions-1) {
            return true;
          }
        }
      }
      return false;
    }
    public boolean hasEnded() {

      if (boardFilled() || checkRows() || checkColumns() || checkDiag()) {
          return true;
      }
      else {
        return false;
      }
    }

    public int[] checkWin() {

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
    public void displayBoard() {
        for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j] == 0) {
                  System.out.print("█ ");
                }
                else if (board[i][j] == 1) {
                    System.out.print("X ");
                }
                else if (board[i][j] == 2) {
                    System.out.print("O ");
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void promptTurn(int playerNum) {
        System.out.println("\nENTER X");
        Integer x = input.nextInt();
        System.out.println("ENTER Y");
        Integer y = input.nextInt();
        if (board[x-1][y-1] == 0) {
            board[x-1][y-1] = playerNum;
        }
        else {
            promptTurn(playerNum);
        }
    }

    public void CompTurn() {
      boolean foundIt = false;
      int[] winning = checkWin();
      if (winning[0] != -1) {
        board[winning[0]][winning[1]] = 1;
      }
      else {
          for (int i = 0; i < dimensions; i++) {
            for (int j = 0; j < dimensions; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = 1;
                    return;
                }
            }
          }
      }
    }


}
