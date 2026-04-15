import java.util.ArrayList;
public class Sudoku{
    private int[][] sudo;
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
            list.set(r, temp);
        }
        fillBoard();
    }
    public void fillBoard() {
        solve(0, 0);
    }
    public void printBoard() {
        System.out.println("+-------+-------+-------+");
        for (int r =0;r < 9; r++) {
            System.out.print("| ");
            for (int c = 0; c < 9; c++) {
                System.out.print(sudo[r][c] + " ");
                if ((c + 1) % 3 == 0) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if ((r + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }
    public boolean solve(int row, int col) {
        if (row == 9){
            return true;
        }
        if (col == 9){
            return solve(row + 1,0);
        }
        if (sudo[row][col] != 0){
            return solve(row, col+ 1);
        }
        for (int k = 0; k < 9; k++) {
            int num = list.get(k);
            if (isSafe(row, col, num)) {
                sudo[row][col] =num;
                if (solve(row, col + 1)){
                    return true;
                }
                sudo[row][col] =0;
            }
        }
        return false;
    }
    public boolean isSafe(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (sudo[row][i] == num){
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (sudo[i][col] == num){
                return false;
            }
        }
        int boxRow = (row / 3) *3;
        int boxCol = (col / 3) * 3;
        for (int r = boxRow; r < boxRow + 3; r++) {
            for (int c = boxCol; c < boxCol + 3; c++) {
                if (sudo[r][c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
