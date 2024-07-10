import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//물품의 수
        int K = sc.nextInt(); //버틸 수 있는 무게
       
        int[] dp = new int[K+1];
        
        for (int i = 0; i < N; i++) {
            int W = sc.nextInt(); //물건의 무게
            int V = sc.nextInt(); //물건의 가치
        
            for(int j = K; j >= W; j--) {
                dp[j] = Math.max(dp[j - W] + V, dp[j]);
            }
        }

        System.out.println(dp[K]);
    }
   
}