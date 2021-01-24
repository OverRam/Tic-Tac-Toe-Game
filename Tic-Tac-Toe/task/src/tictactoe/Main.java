package tictactoe;

public class Main {
    public static void main(String[] args) {
        Grid.run();
//        test();
    }

    static void test() {
        System.out.println(Grid.run("XXXOO__O_").equals("X wins"));
        System.out.println(Grid.run("XOXOXOXXO").equals("X wins"));
        System.out.println(Grid.run("XOOOXOXXO").equals("O wins"));
        System.out.println(Grid.run("XOXOOXXXO").equals("Draw"));
        System.out.println(Grid.run("XO_OOX_X_").equals("Game not finished"));
        System.out.println(Grid.run("XO_XO_XOX").equals("Impossible"));
        System.out.println(Grid.run("_O_X__X_X").equals("Impossible"));
        System.out.println(Grid.run("_OOOO_X_X").equals("Impossible"));
    }
}
