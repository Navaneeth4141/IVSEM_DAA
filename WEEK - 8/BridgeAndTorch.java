import java.util.*;
public class BridgeAndTorch {
    static int findTime(int[] arr, int n) {
        Arrays.sort(arr);
        int res = 0;
        int i = n - 1;
        while (i > 2) {
            int option1 = arr[0] + 2 * arr[1] + arr[i];
            int option2 = 2 * arr[0] + arr[i] + arr[i - 1];
            res += Math.min(option1, option2);
            i -= 2;
        }
        if (i == 2) res += arr[0] + arr[1] + arr[2];
        else if (i == 1) res += arr[1];
        else if (i == 0) res += arr[0];
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(findTime(arr, n));
        sc.close();
    }
}