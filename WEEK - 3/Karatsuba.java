public class Karatsuba {

    static int get_size(long value) {
        int count = 0;
        while (value != 0) {
            count++;
            value /= 10;
        }
        return count;
    }

    static long karatsuba(long X, long Y) {
        if (X < 10 && Y < 10)
            return X * Y;

        int size1 = get_size(X);
        int size2 = get_size(Y);
        int n = Math.max(size1, size2);
        int half = n / 2;

        long power = (long)Math.pow(10, half);

        long X1 = X / power;
        long X2 = X % power;
        long Y1 = Y / power;
        long Y2 = Y % power;

        long U = karatsuba(X1, Y1);
        long V = karatsuba(X2, Y2);
        long W = karatsuba(X1 + X2, Y1 + Y2);

        long Z = W - U - V;

        return (long)(Math.pow(10, 2 * half) * U + Math.pow(10, half) * Z + V);
    }

    public static void main(String args[]) {
        long x = 145623;
        long y = 653324;
        System.out.print("The final product is: ");
        long product = karatsuba(x, y);
        System.out.println(product);
    }
}
