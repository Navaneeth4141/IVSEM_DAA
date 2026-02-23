import java.util.*;
public class OptimalStorageOnTapes {
    static void findOrderMRT(int[] L, int n) {
        Arrays.sort(L);
        System.out.print("Optimal order in which programs are to be stored is: ");
        for(int i = 0; i < n; i++) System.out.print(L[i] + " ");
        double MRT = 0;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += L[i];
            MRT += sum;
        }
        MRT /= n;
        System.out.println("\nMinimum Retrieval Time of this order is " + MRT);
    }
    public static void main(String[] args) {
        int[] L = {2, 5, 4};
        findOrderMRT(L, L.length);
    }
}