public class SudokuGenerator
{
    public static int[][] board = new int[9][9];
    public static void main(String[] args)
    {
        testVal(0, 0);
        
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

  
    
        
    public static boolean testVal(int row, int col){

        if (row == 9){
            return true;
        }
    
        int start = (int)(Math.random() * 9) + 1;
    
        for (int i = 0; i < 9; i++) {
    
            int num = (start + i - 1) % 9 + 1;
    
            if (!numInRow(row, num) && !numInCol(col, num) && !numInBox(row, col, num)) {
    
                board[row][col] = num;
    
                boolean next;
                if (col == 8) {
                    next = testVal(row + 1, 0);
                } else {
                    next = testVal(row, col + 1);
                }
    
                if (next){
                    return true;
                }
                
                board[row][col] = 0; 
            }
        }
    
        return false;
    }

}
