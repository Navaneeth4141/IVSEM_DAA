import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static float dist(Point p1, Point p2) {
        return (float)Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y));
    }

    public static float bruteForce(Point[] P, int n) {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                if (dist(P[i], P[j]) < min)
                    min = dist(P[i], P[j]);
        return min;
    }

    public static float stripClosest(Point[] strip, int size, float d) {
        float min = d;
        Arrays.sort(strip, 0, size, Comparator.comparingInt(p -> p.y));
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size && (strip[j].y - strip[i].y) < min; j++)
                if (dist(strip[i], strip[j]) < min)
                    min = dist(strip[i], strip[j]);
        return min;
    }

    public static float closestUtil(Point[] P, int startIndex, int endIndex) {
        int n = endIndex - startIndex;
        if (n <= 3)
            return bruteForce(Arrays.copyOfRange(P, startIndex, endIndex), n);

        int mid = startIndex + n / 2;
        Point midPoint = P[mid];

        float dl = closestUtil(P, startIndex, mid);
        float dr = closestUtil(P, mid, endIndex);

        float d = Math.min(dl, dr);

        Point[] strip = new Point[n];
        int j = 0;
        for (int i = startIndex; i < endIndex; i++)
            if (Math.abs(P[i].x - midPoint.x) < d)
                strip[j++] = P[i];

        return Math.min(d, stripClosest(strip, j, d));
    }

    public static float closest(Point[] P, int n) {
        Arrays.sort(P, Comparator.comparingInt(p -> p.x));
        return closestUtil(P, 0, n);
    }
}

public class ClosestPoint {
    public static void main(String[] args) {
        Point[] P = {
            new Point(2, 3),
            new Point(12, 30),
            new Point(40, 50),
            new Point(5, 1),
            new Point(12, 10),
            new Point(3, 4)
        };

        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println("The smallest distance is " + df.format(Point.closest(P, P.length)));
    }
}
