class RD {

    static char last_removed;

    static String removeUtil(String str) {
        if (str.length() == 0 || str.length() == 1)
            return str;

        if (str.charAt(0) == str.charAt(1)) {
            last_removed = str.charAt(0);
            int i = 1;
            while (i < str.length() && str.charAt(i) == str.charAt(0))
                i++;
            return removeUtil(str.substring(i));
        }

        String rem_str = removeUtil(str.substring(1));

        if (rem_str.length() != 0 && rem_str.charAt(0) == str.charAt(0)) {
            last_removed = str.charAt(0);
            return rem_str.substring(1);
        }

        if (rem_str.length() == 0 && last_removed == str.charAt(0))
            return rem_str;

        return str.charAt(0) + rem_str;
    }

    static String remove(String str) {
        last_removed = '\0';
        return removeUtil(str);
    }

    public static void main(String args[]) {
        System.out.println(remove("azxxzy"));
        System.out.println(remove("caaabbbaacdddd"));
        System.out.println(remove("acaaabbbacdddd"));
    }
}
