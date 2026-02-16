import java.util.Random;

public class SSP {

    static StringBuilder add_more_char(StringBuilder str, int need) {
        String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@$!%*?&";
        Random r = new Random();
        for (int i = 0; i < need; i++)
            str.insert(r.nextInt(str.length() + 1), all.charAt(r.nextInt(all.length())));
        return str;
    }

    static StringBuilder suggester(int l, int u, int d, int s, StringBuilder str) {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String special = "@$!%*?&";
        Random r = new Random();

        if (u == 0) str.insert(r.nextInt(str.length() + 1), upper.charAt(r.nextInt(upper.length())));
        if (l == 0) str.insert(r.nextInt(str.length() + 1), lower.charAt(r.nextInt(lower.length())));
        if (d == 0) str.insert(r.nextInt(str.length() + 1), digit.charAt(r.nextInt(digit.length())));
        if (s == 0) str.insert(r.nextInt(str.length() + 1), special.charAt(r.nextInt(special.length())));

        return str;
    }

    static void generate_password(int n, StringBuilder p) {
        int l = 0, u = 0, d = 0, s = 0;

        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (Character.isLowerCase(c)) l = 1;
            else if (Character.isUpperCase(c)) u = 1;
            else if (Character.isDigit(c)) d = 1;
            else s = 1;
        }

        if (n >= 8 && l == 1 && u == 1 && d == 1 && s == 1) {
            System.out.println("Your Password is Strong");
            return;
        }

        System.out.println("Suggested Password");

        for (int i = 0; i < 8; i++) {
            StringBuilder temp = new StringBuilder(p);
            temp = suggester(l, u, d, s, temp);
            if (temp.length() < 8)
                temp = add_more_char(temp, 8 - temp.length());
            System.out.println(temp);
        }
    }

    public static void main(String[] args) {
        StringBuilder input_String = new StringBuilder("keshav123");
        generate_password(input_String.length(), input_String);
    }
}
