import java.util.HashMap;

class HT {

    static int countQuadruples(int arr1[], int arr2[], int arr3[], int arr4[], int n, int x) {
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = arr1[i] + arr2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = arr3[i] + arr4[j];
                if (map.containsKey(x - sum)) {
                    count += map.get(x - sum);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 4, 5, 6};
        int arr2[] = {2, 3, 7, 8};
        int arr3[] = {1, 4, 6, 10};
        int arr4[] = {2, 4, 7, 8};

        int n = arr1.length;
        int x = 30;

        System.out.println("Count = " + countQuadruples(arr1, arr2, arr3, arr4, n, x));
    }
}
