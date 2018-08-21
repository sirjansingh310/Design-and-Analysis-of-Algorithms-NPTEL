import java.util.*;
class mainclass{
    public static void printSolution(int board[][],int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean canBePlaced(int board[][],int row,int col,int n){
             for(int i=0;i<col;i++){
                 if(board[row][i]==1)
                   return false;
             }
             // Check upper diagonal on left side, right side diag is not visited
           for (int i=row,  j=col; i>=0 && j>=0; i--, j--){
             if (board[i][j]==1)
               return false;
           }
 
           //Check lower diagonal on left side 
             for (int i=row,j=col; j>=0 && i<n; i++, j--){
                   if (board[i][j]==1)
                    return false;
             }
             return true;
    }
    public static boolean nqueens(int board[][],int col,int n){
        if(col>=n)// we placed all our nqueens, base case
        return true;
        for(int i=0;i<n;i++){
            if(canBePlaced(board,i,col,n))
            {
                board[i][col] = 1;
                if(nqueens(board,col+1,n))// checking if rec call is true, we return it else reset board value
                     return true;
                else
                    board[i][col] = 0;
                
            }
        }
        return false;/// backtrack
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int board[][] = new int[n][n];
        if(nqueens(board,0,n))
           printSolution(board,n);
        else
          System.out.println("Not possible");
    }
}
