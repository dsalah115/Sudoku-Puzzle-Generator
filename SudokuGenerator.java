public class SudokuGenerator
{
    public static int[][] board = new int[9][9];
    public static void main(String[] args)
    {
        testVal(0, 0, 1);
        
        printBoard();
    }
    
    public static void printBoard(){
        System.out.println(" -----------------------");
        for (int i = 0; i < board.length; i++){
            if (i % 3 == 0 && i != 0){
                System.out.println("|                       |");
            }
            for (int j = 0; j < board[0].length; j++){
                if (j == 0){
                    System.out.print("| ");
                }
                if (j % 3 == 0 && j != 0){
                    System.out.print("  ");
                }
                System.out.print(board[i][j] + " ");
                
                if (j == 8){
                    System.out.print("|");
                }
            }
            System.out.println();
        }
        System.out.println(" -----------------------");
    }
    
    public static boolean numInRow(int row, int num){
        for (int i = 0; i < board[0].length; i++){
            if (board[row][i] == num){
                return true;
            }
        }
        return false;
    }
    
    public static boolean numInCol(int col, int num){
        for (int i = 0; i < board.length; i++){
            if (board[i][col] == num){
                return true;
            }
        }
        return false;
    }
    
    public static boolean numInBox(int row, int col, int num){
        int[] pos = {(row / 3) * 3, (col / 3) * 3};
        for (int i = pos[0]; i < pos[0] + 3; i++){
            for (int j = pos[1]; j < pos[1] + 3; j++){
                if (board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
}
    
    
    public static boolean testVal(int row, int col, int val){
        if (row == 9){
            return true;
        }
        
        if (val > 9){
            board[row][col] = 0;
            if (col == 0){
                return testVal(row - 1, 8, board[row-1][8] + 1);
            }
            else{
                return testVal(row, col - 1, board[row][col-1] + 1);
            }
        }
        
        if (numInRow(row, val) || numInCol(col, val) || numInBox(row, col, val)){
            return testVal(row, col, val + 1);
        }
        
        else{
            board[row][col] = val;
            if (col == 8){
                if (testVal(row + 1, 0, 1)){
                    return true;
                }
            }
            else{
                if (testVal(row, col + 1, 1)){
                    return true;
                }
            }
        }
        
        return false;
    }

}