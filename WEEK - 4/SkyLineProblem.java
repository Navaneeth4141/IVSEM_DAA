import java.util.*;

class Building {
    int left, ht, right;
    Building(int l, int h, int r) {
        left = l;
        ht = h;
        right = r;
    }
}

class Strip {
    int left, ht;
    Strip(int l, int h) {
        left = l;
        ht = h;
    }
}

class SkyLine {
    List<Strip> arr = new ArrayList<>();
    void append(Strip st) {
        if (arr.size() > 0) {
            Strip last = arr.get(arr.size() - 1);
            if (last.ht == st.ht) return;
            if (last.left == st.left) {
                last.ht = Math.max(last.ht, st.ht);
                return;
            }
        }
        arr.add(st);
    }

    SkyLine merge(SkyLine other) {
        SkyLine res = new SkyLine();
        int h1 = 0, h2 = 0, i = 0, j = 0;
        while (i < arr.size() && j < other.arr.size()) {
            if (arr.get(i).left < other.arr.get(j).left) {
                int x = arr.get(i).left;
                h1 = arr.get(i).ht;
                res.append(new Strip(x, Math.max(h1, h2)));
                i++;
            } else {
                int x = other.arr.get(j).left;
                h2 = other.arr.get(j).ht;
                res.append(new Strip(x, Math.max(h1, h2)));
                j++;
            }
        }
        while (i < arr.size()) res.append(arr.get(i++));
        while (j < other.arr.size()) res.append(other.arr.get(j++));
        return res;
    }

    void printSkyline() {
        for (Strip s : arr)
            System.out.print("{ " + s.left + ", " + s.ht + " } ");
    }
}

public class SkylineProblem {
    static SkyLine findSkyline(Building[] arr, int l, int h) {
        if (l == h) {
            SkyLine res = new SkyLine();
            res.append(new Strip(arr[l].left, arr[l].ht));
            res.append(new Strip(arr[l].right, 0));
            return res;
        }
        int mid = (l + h) / 2;
        SkyLine left = findSkyline(arr, l, mid);
        SkyLine right = findSkyline(arr, mid + 1, h);
        return left.merge(right);
    }

    public static void main(String[] args) {
        Building[] arr = {
            new Building(1, 11, 5), new Building(2, 6, 7),
            new Building(3, 13, 9), new Building(12, 7, 16),
            new Building(14, 3, 25), new Building(19, 18, 22),
            new Building(23, 13, 29), new Building(24, 4, 28)
        };
        SkyLine res = findSkyline(arr, 0, arr.length - 1);
        res.printSkyline();
    }
}