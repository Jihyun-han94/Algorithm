import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt(); // 1보다 크고 100보다 작다

       int[][] dp = new int[n+1][10];

       for(int i = 1; i <= 9; i++) {
        dp[1][i] = 1;
       }

       for(int i = 2; i <= n; i++) {
        for(int l = 0; l <= 9; l++) {
            if (l == 0) {
                dp[i][0] = dp[i-1][l+1] % 1000_000_000;
            }else if(l == 9) {
                dp[i][9] = dp[i-1][l-1] % 1000_000_000;
            }else {
                dp[i][l] = (dp[i-1][l-1] + dp[i-1][l+1]) % 1000_000_000;
            }
        }
       }
       long sum = 0;
       for(int i = 0; i <= 9; i++) {
            sum = (sum +dp[n][i]) % 1000_000_000;
       }
       System.out.println(sum);
    }
}