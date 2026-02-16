import java.util.*;

public class ReservoirSampling {

    static void selectKItems(int stream[], int n, int k) {
        int reservoir[] = new int[k];

        for (int i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random rand = new Random();

        for (int i = k; i < n; i++) {
            int j = rand.nextInt(i + 1);
            if (j < k)
                reservoir[j] = stream[i];
        }

        System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);
    }
}
