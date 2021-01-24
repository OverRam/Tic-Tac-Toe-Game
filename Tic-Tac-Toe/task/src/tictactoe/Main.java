package tictactoe;

public class Main {
    public static void main(String[] args) {
        var TicTac = new Grid();
        TicTac.run();
//      test();
    }

    static void test() {
        var grid = new Grid();
        System.out.println(grid.run("XXXOO__O_").equals("X wins"));
        System.out.println(grid.run("XOXOXOXXO").equals("X wins"));
        System.out.println(grid.run("XOOOXOXXO").equals("O wins"));
        System.out.println(grid.run("XOXOOXXXO").equals("Draw"));
        System.out.println(grid.run("XO_OOX_X_").equals("Game not finished"));
        System.out.println(grid.run("XO_XO_XOX").equals("Impossible"));
        System.out.println(grid.run("_O_X__X_X").equals("Impossible"));
        System.out.println(grid.run("_OOOO_X_X").equals("Impossible"));
    }
}
