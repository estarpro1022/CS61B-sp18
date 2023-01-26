import java.util.Arrays;

public class Sort {
    public static void sort(String[] input) {
        sort(input, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSmallestIndex(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    public static int findSmallestIndex(String[] input, int start) {
        int smallestIndex = start;
        for (int i = start; i < input.length; i++) {
            int cmp = input[i].compareTo(input[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
