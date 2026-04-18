import java.util.ArrayList;
import java.util.Collections;
public class Sudoku {
    private int[][]sudo;
    private ArrayList<Integer> list;
    public static void main(String[] args) {
        Sudoku sudok = new Sudoku();
        sudok.printBoard();
    }
    public Sudoku() {
        sudo =new int[9][9];
        list = new ArrayList<>();
        for(int i = 1; i <= 9; i++) {
            list.add(i);
        }
        for (int i = 0; i < 9; i++) {
            int r = (int) (Math.random() * 9);
            int temp = list.get(i);
            list.set(i, list.get(r));
            list.set(r,temp);
        }
        fillBoard();
    }
    public void fillBoard() {
        pathfinder(0, 0); 
    }
    public void printBoard() {
        System.out.println("+-------+-------+-------+");
        for (int r = 0; r < 9; r++) {
            System.out.print("| ");
            for (int c = 0; c < 9; c++) {
                System.out.print(sudo[r][c] + " ");
                if ((c + 1)% 3== 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((r + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }
    public boolean pathfinder(int r,int c) {
        if (c == 9){
            return true;
        }
        if (r == 9) {
            return pathfinder(0, c + 1);
        }

        if (sudo[r][c] != 0) {
            return pathfinder(r + 1, c);
        }
        ArrayList<Integer> values = new ArrayList<>(); 
        for (int i = 1; i <= 9; i++) {
            values.add(i);
        }
        Collections.shuffle(values);
        int index = 0;
        while (index < 9) {
            int val= values.get(index);

            if (isSafe(r,c, val)) {
                sudo[r][c] = val;
                if (pathfinder(r + 1, c)) {
                    return true;
                }
                sudo[r][c] = 0;
            }
            index++;
        }
        return false;
    }
    public boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudo[row][i] == num) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (sudo[i][col] == num) {
                return false;
            }
        }
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (sudo[r][c] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}
