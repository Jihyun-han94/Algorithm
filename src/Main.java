import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] max = new int[n+2];
        int[] min = new int[n+2];
        int[] tmax = new int[n+2];
        int[] tmin = new int[n+2];
        int input = 0;

        max[0] = max[4] = 0;
        min[0] = min[4] = 1_000_000;

        
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= 3; j++) {
                input = sc.nextInt();
                tmax[j] = Math.max(max[j-1], Math.max(max[j], max[j+1])) + input;
                tmin[j]= Math.min(min[j-1], Math.min(min[j], min[j+1])) + input;
            }
            for(int k = 1; k <= 3; k++) {
                max[k] = tmax[k];
                min[k] = tmin[k];
            }

        }

        int maxVal = 0;
        int minVal = 1_000_000;
        for(int i = 1; i <= 3; i++) {
            maxVal = Math.max(maxVal, max[i]);
            minVal = Math.min(minVal, min[i]);
        }

        System.out.println(maxVal +" "+minVal);
    }
    }