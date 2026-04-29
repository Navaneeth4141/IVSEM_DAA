public class FittingShelves {
    static void minSpacePreferLarge(int wall, int m, int n) {
        int num_m = 0, num_n = 0, min_empty = wall;

        int p = wall / m, q = 0, rem = wall % m;
        num_m = p;
        num_n = q;
        min_empty = rem;

        for (q = 1; q * n <= wall; q++) {
            int remaining = wall - q * n;
            p = remaining / m;
            rem = remaining % m;

            if (rem < min_empty || (rem == min_empty && q > num_n)) {
                num_m = p;
                num_n = q;
                min_empty = rem;
            }
        }

        System.out.println(num_m + " " + num_n + " " + min_empty);
    }

    public static void main(String[] args) {
        int wall = 24, m = 3, n = 5;
        minSpacePreferLarge(wall, m, n);

        wall = 24;
        m = 4;
        n = 7;
        minSpacePreferLarge(wall, m, n);
    }
}