import java.util.*;
public class StockMaximize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] prices = new long[n];
            for(int i=0;i<n;i++) prices[i]=sc.nextLong();
            long maxSoFar = 0, profit = 0;
            for(int i=n-1;i>=0;i--){
                if(prices[i] > maxSoFar) maxSoFar = prices[i];
                else profit += (maxSoFar - prices[i]);
            }
            System.out.println(profit);
        }
        sc.close();
    }
}