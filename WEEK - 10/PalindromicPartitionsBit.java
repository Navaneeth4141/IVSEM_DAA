import java.util.*;

public class PalindromicPartitionsBit {
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static void generate(String s, int mask) {
        List<String> parts = new ArrayList<>();
        int last = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if ((mask & (1 << i)) != 0) {
                parts.add(s.substring(last, i + 1));
                last = i + 1;
            }
        }
        parts.add(s.substring(last));

        for (String p : parts) {
            if (!isPalindrome(p)) return;
        }

        for (String p : parts) System.out.print(p + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "nitin";
        int n = s.length();
        int total = 1 << (n - 1);

        for (int mask = 0; mask < total; mask++) {
            generate(s, mask);
        }
    }
}