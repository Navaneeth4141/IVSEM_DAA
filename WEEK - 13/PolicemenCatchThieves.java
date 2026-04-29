import java.util.*;

class PolicemenCatchThieves {
    static int policeThief(char arr[], int n, int k) {
        List<Integer> pol = new ArrayList<>();
        List<Integer> thi = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P') pol.add(i);
            else thi.add(i);
        }

        int i = 0, j = 0, res = 0;

        while (i < pol.size() && j < thi.size()) {
            if (Math.abs(pol.get(i) - thi.get(j)) <= k) {
                res++;
                i++;
                j++;
            } else if (pol.get(i) < thi.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char arr1[] = { 'P', 'T', 'T', 'P', 'T' };
        int n = arr1.length;
        int k = 2;
        System.out.println("Maximum thieves caught: " + policeThief(arr1, n, k));

        char arr2[] = { 'T', 'T', 'P', 'P', 'T', 'P' };
        n = arr2.length;
        k = 2;
        System.out.println("Maximum thieves caught: " + policeThief(arr2, n, k));

        char arr3[] = { 'P', 'T', 'P', 'T', 'T', 'P' };
        n = arr3.length;
        k = 3;
        System.out.println("Maximum thieves caught: " + policeThief(arr3, n, k));
    }
}