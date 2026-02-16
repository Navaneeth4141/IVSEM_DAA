import java.util.*;

public class TP
{
static int size_of_grid, a, b, cnt = 0;
static int[][] arr = new int[128][128];


static void place(int x1, int y1, int x2, int y2, int x3, int y3)
{
    cnt++;
    arr[x1][y1] = cnt;
    arr[x2][y2] = cnt;
    arr[x3][y3] = cnt;
}

static void tile(int n, int x, int y)
{
    if (n == 2)
    {
        int c = ++cnt;
        for (int i = x; i < x + 2; i++)
            for (int j = y; j < y + 2; j++)
                if (arr[i][j] == 0)
                    arr[i][j] = c;
        return;
    }

    int t = cnt + 1;
    int s = n / 2;

    if (arr[x + s - 1][y + s - 1] != 0)
        tile(s, x, y);
    else
    {
        arr[x + s - 1][y + s - 1] = t;
        tile(s, x, y);
    }

    if (arr[x + s - 1][y + s] != 0)
        tile(s, x, y + s);
    else
    {
        arr[x + s - 1][y + s] = t;
        tile(s, x, y + s);
    }

    if (arr[x + s][y + s - 1] != 0)
        tile(s, x + s, y);
    else
    {
        arr[x + s][y + s - 1] = t;
        tile(s, x + s, y);
    }

    if (arr[x + s][y + s] != 0)
        tile(s, x + s, y + s);
    else
    {
        arr[x + s][y + s] = t;
        tile(s, x + s, y + s);
    }

    cnt = t;
}

public static void main(String[] args)
{
    size_of_grid = 8;
    a = 0;
    b = 0;
    arr[a][b] = -1;

    tile(size_of_grid, 0, 0);

    for (int i = 0; i < size_of_grid; i++)
    {
        for (int j = 0; j < size_of_grid; j++)
            System.out.print(arr[i][j] + " ");
        System.out.println();
    }
}


}
