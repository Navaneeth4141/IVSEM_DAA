import java.util.*;
public class SherlockAndCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = sc.nextInt();
            long low = 0, high = 0;
            for (int i = 1; i < n; i++) {
                long newLow = Math.max(low, high + Math.abs(b[i - 1] - 1));
                long newHigh = Math.max(low + Math.abs(b[i] - 1), high);
                low = newLow;
                high = newHigh;
            }
            System.out.println(Math.max(low, high));
        }
        sc.close();
    }
}