package tictactoe;

import java.util.Scanner;

public class Grid {
    private static final String[][] grid = new String[3][3];
    private static boolean winO = false;
    private static boolean winX = false;

    public static void run() {
        System.out.println("Enter cells: ");
        firstFillGrid();
        winO = checkWin("O");
        winX = checkWin("X");
        printGrid();
        System.out.println(printWin());
    }

    public static String run(String s) {   //to tests
        firstFillGrid(s);
        winO = checkWin("O");
        winX = checkWin("X");
        return printWin();
    }

    private static String printWin() {
        if (checkImpossible()) {
            return "Impossible";
        } else if (winO) {
            return "O wins";
        } else if (winX) {
            return "X wins";
        } else if (checkEmpty()) {
            return "Game not finished";
        } else {
            return "Draw";
        }
    }

    private static boolean checkImpossible() {
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

    private static boolean checkEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j].equals("_")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean checkWin(String s) {
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

    private static void printGrid() {
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

    private static void firstFillGrid() {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        for (int i = 0, counter = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, counter++) {
                grid[i][j] = String.valueOf(string.charAt(counter));
            }
        }
    }

    private static void firstFillGrid(String s) {
        for (int i = 0, counter = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++, counter++) {
                grid[i][j] = String.valueOf(s.charAt(counter));
            }
        }
    }
}


