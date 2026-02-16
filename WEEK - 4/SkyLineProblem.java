import java.util.*;

class Building {
int left, ht, right;
public Building(int left, int ht, int right) {
this.left = left;
this.ht = ht;
this.right = right;
}
}

class Strip {
int left, ht;
public Strip(int left, int ht) {
this.left = left;
this.ht = ht;
}
}

class SkyLine {
List<Strip> arr;
int capacity, n;

public SkyLine(int cap) {
    this.arr = new ArrayList<>();
    this.capacity = cap;
    this.n = 0;
}

public int count() {
    return this.n;
}

public void append(Strip st) {
    if (n > 0 && arr.get(n - 1).ht == st.ht)
        return;
    if (n > 0 && arr.get(n - 1).left == st.left) {
        arr.get(n - 1).ht = Math.max(arr.get(n - 1).ht, st.ht);
        return;
    }
    arr.add(st);
    n++;
}

public SkyLine merge(SkyLine other) {
    SkyLine res = new SkyLine(this.n + other.n);
    int h1 = 0, h2 = 0;
    int i = 0, j = 0;

    while (i < this.n && j < other.n) {
        if (this.arr.get(i).left < other.arr.get(j).left) {
            int x = this.arr.get(i).left;
            h1 = this.arr.get(i).ht;
            int maxh = Math.max(h1, h2);
            res.append(new Strip(x, maxh));
            i++;
        } else {
            int x = other.arr.get(j).left;
            h2 = other.arr.get(j).ht;
            int maxh = Math.max(h1, h2);
            res.append(new Strip(x, maxh));
            j++;
        }
    }

    while (i < this.n) {
        res.append(this.arr.get(i));
        i++;
    }

    while (j < other.n) {
        res.append(other.arr.get(j));
        j++;
    }

    return res;
}

public void printSkyline() {
    for (Strip st : arr)
        System.out.print("{ " + st.left + ", " + st.ht + " } ");
}

}

public class SkylineProblem {

public static SkyLine findSkyline(Building[] arr, int l, int h) {
    if (l == h) {
        SkyLine res = new SkyLine(2);
        res.append(new Strip(arr[l].left, arr[l].ht));
        res.append(new Strip(arr[l].right, 0));
        return res;
    }

    int mid = (l + h) / 2;
    SkyLine sl = findSkyline(arr, l, mid);
    SkyLine sr = findSkyline(arr, mid + 1, h);

    return sl.merge(sr);
}

public static void main(String[] args) {
    Building[] arr = {
            new Building(1, 11, 5),
            new Building(2, 6, 7),
            new Building(3, 13, 9),
            new Building(12, 7, 16),
            new Building(14, 3, 25),
            new Building(19, 18, 22),
            new Building(23, 13, 29),
            new Building(24, 4, 28)
    };

    SkyLine res = findSkyline(arr, 0, arr.length - 1);
    res.printSkyline();
}

}
