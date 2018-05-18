import java.util.*;
public class DominoSolitaire {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int mat[][]=new int[2][n];
	    for(int i=0;i<2;i++){
	        for(int j=0;j<n;j++){
	            mat[i][j]=sc.nextInt();
	        }
	    }
		int dp[]=new int[n+1];
		Arrays.fill(dp,0);
		dp[n-1]=Math.abs(mat[0][n-1]-mat[1][n-1]);
		for(int i=n-2;i>=0;i--){
		    dp[i]=Math.max(Math.abs(mat[0][i]-mat[1][i])+dp[i+1],Math.abs(mat[0][i]-mat[0][i+1])+Math.abs(mat[1][i]-mat[1][i+1])+dp[i+2]);
		}
		System.out.println(dp[0]);
	}
}