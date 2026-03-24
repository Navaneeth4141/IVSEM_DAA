import java.util.*;

public class AllLCSLexicographical {
    static int[][] dp;
    static int lcslen;

    static int lcs(String s1, String s2, int n, int m) {
        dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }

    static void generate(String s1, String s2, int i, int j, String curr, Set<String> result) {
        if (curr.length() == lcslen) {
            result.add(curr);
            return;
        }
        if (i >= s1.length() || j >= s2.length()) return;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int x = i; x < s1.length(); x++) {
                if (s1.charAt(x) == ch) {
                    for (int y = j; y < s2.length(); y++) {
                        if (s2.charAt(y) == ch && dp[x + 1][y + 1] == lcslen - curr.length()) {
                            generate(s1, s2, x + 1, y + 1, curr + ch, result);
                            break;
                        }
                    }
                }
            }
        }
    }

    static void printAllLCSSorted(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        lcslen = lcs(s1, s2, n, m);
        Set<String> result = new TreeSet<>();
        generate(s1, s2, 0, 0, "", result);
        for (String str : result) System.out.println(str);
    }

    public static void main(String[] args) {
        String str1 = "abcabcaa", str2 = "acbacba";
        printAllLCSSorted(str1, str2);
    }
}