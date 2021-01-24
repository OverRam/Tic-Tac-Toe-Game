package tictactoe;

import java.util.Scanner;

public class Grid {
    private  final String[][] grid = {{" ", " ", " "}, {" ", " ", " "}, {" ", " ", " "}};
    private  final Scanner sc = new Scanner(System.in);
    private  boolean winO = false;
    private  boolean winX = false;
    private  int baseToChangeChar = 1;
    private  String XO = "X";

    public  void run() {
        boolean isNoWin = true;
        printGrid();
        while ((isNoWin)) {
                input();
                changeChar();
                if (checkWin("X")) {
                    winX = true;
                    isNoWin = false;
                } else {
                    if (!checkEmptyCellsToPlay()) {
                        isNoWin = false;
                    } else {
                    printGrid();
                    input();
                    if (checkWin("O")) {
                        winO = true;
                        isNoWin = false;
                    }
                    printGrid();
                    changeChar();
                }
            }
        }
        printGrid();
        System.out.println(printWin());
        sc.close();
    }

    private  void changeChar() {
        baseToChangeChar++;
        XO = baseToChangeChar % 2 == 0 ? "O" : "X";
    }

    private  void input() {
        int i;
        int j;
        System.out.print("Enter the coordinates: ");
        try {
            i = Integer.parseInt(sc.next());
            j = Integer.parseInt(sc.next());
            chekEmptyCell(i, j);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            input();
        }
    }

    private  void chekEmptyCell(int i, int j) {
        if (i > 3 || j > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            input();
        } else if (grid[i - 1][j - 1].equals("X") || grid[i - 1][j - 1].equals("O")) {
            System.out.println("This cell is occupied! Choose another one!");
            input();
        } else {
            grid[i - 1][j - 1] = XO;
        }
    }

    public  String run(String s) {   //to tests
        testFillGrid(s);
        winO = checkWin("O");
        winX = checkWin("X");
        return printWin();
    }

    private  String printWin() {
        if (checkImpossible()) {
            return "Impossible";
        } else if (winO) {
            return "O wins";
        } else if (winX) {
            return "X wins";
        } else if (checkEmptyCellsToPlay()) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private  boolean checkImpossible() {
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("X")) {
                    ++countX;
                } else if (grid[i][j].equals("O")) {
                    ++countO;
                }
            }
        }
        if (countX + 1 < countO || countO < countX - 1) {
            return true;
        }
        return winO && winX;
    }

    private  boolean checkEmptyCellsToPlay() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals(" ")) {
                    return true;
                }
            }
        }
        return false;
    }

    private  boolean checkWin(String s) {
        int countVertical = 0;
        int countHorizontal = 0;
        int cross = 0;
        int backCross = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (s.equals(grid[j][i])) {   //vertical check
                    ++countVertical;
                    if (countVertical == 3) {
                        return true;
                    }
                }
            }
            countVertical = 0;

            for (int j = 0; j < 3; j++) {
                if (s.equals(grid[i][j])) {   //horizontal check
                    ++countHorizontal;
                    if (countHorizontal == 3) {
                        return true;
                    }
                }
            }
            countHorizontal = 0;

            if (s.equals(grid[i][i])) {   //cross check
                ++cross;
                if (cross == 3) {
                    return true;
                }
            }

            if (s.equals(grid[i][2 - i])) {   //back cross check
                ++backCross;
                if (backCross == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    private  void printGrid() {
        System.out.println("---------");
        for (String[] r : grid) {
            System.out.print("| ");
            for (String e : r) {
                System.out.print(e + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    private  void testFillGrid(String s) {
        for (int i = 0, counter = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, counter++) {
                grid[i][j] = String.valueOf(s.charAt(counter));
            }
        }
    }
}