import java.util.*;

public class WordBreakBacktracking {
    static void wordBreak(int n, List<String> dict, String s) {
        wordBreakUtil(n, s, dict, "");
    }

    static void wordBreakUtil(int n, String s, List<String> dict, String ans) {
        if (s.length() == 0) {
            System.out.println(ans.trim());
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                wordBreakUtil(n, s.substring(i), dict, ans + prefix + " ");
            }
        }
    }

    public static void main(String args[]) {
        List<String> dict = Arrays.asList(
            "i","like","sam","sung","samsung","mobile",
            "ice","and","cream","icecream","man","go","mango"
        );

        String str1 = "ilikesamsungmobile";
        String str2 = "ilikeicecreamandmango";

        int n1 = str1.length();
        int n2 = str2.length();

        wordBreak(n1, dict, str1);
        System.out.println("\nSecond Test:");
        wordBreak(n2, dict, str2);
    }
}