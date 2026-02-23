public class SearchInMatrix {

    static void search(int[][] mat, int fr, int tr, int fc, int tc, int key) {
        if (fr > tr || fc > tc) return;
        int mr = (fr + tr) / 2;
        int mc = (fc + tc) / 2;
        if (mat[mr][mc] == key) {
            System.out.println("Element " + key + " found at (" + mr + ", " + mc + ")");
            return;
        }
        if (mat[mr][mc] > key) {
            search(mat, fr, mr - 1, fc, tc, key);
            search(mat, mr, tr, fc, mc - 1, key);
        } else {
            search(mat, mr + 1, tr, fc, tc, key);
            search(mat, fr, mr, mc + 1, tc, key);
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        int key = 50;
        search(mat, 0, 3, 0, 3, key);
    }
}