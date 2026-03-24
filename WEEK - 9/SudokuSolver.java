import java.util.*;

public class SudokuSolver {
    static boolean isSafe(int[][] board,int row,int col,int num){
        for(int d=0;d<9;d++) if(board[row][d]==num) return false;
        for(int r=0;r<9;r++) if(board[r][col]==num) return false;
        int sr=row-row%3,sc=col-col%3;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(board[i+sr][j+sc]==num) return false;
        return true;
    }

    static boolean solveSudoku(int[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    for(int num=1;num<=9;num++){
                        if(isSafe(board,i,j,num)){
                            board[i][j]=num;
                            if(solveSudoku(board)) return true;
                            board[i][j]=0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    static void print(int[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] board={
            {3,0,6,5,0,8,4,0,0},
            {5,2,0,0,0,0,0,0,0},
            {0,8,7,0,0,0,0,3,1},
            {0,0,3,0,1,0,0,8,0},
            {9,0,0,8,6,3,0,0,5},
            {0,5,0,0,9,0,6,0,0},
            {1,3,0,0,0,0,2,5,0},
            {0,0,0,0,0,0,0,7,4},
            {0,0,5,2,0,6,3,0,0}
        };

        if(solveSudoku(board)) print(board);
        else System.out.println("No solution");
    }
}