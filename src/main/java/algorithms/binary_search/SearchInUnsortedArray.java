package algorithms.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchInUnsortedArray {

    private static int n;
    private static int desiredValue;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        prepareData();
        System.out.println(findDesiredValuePosition(0, n - 1));
    }

    private static void prepareData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        desiredValue = Integer.parseInt(reader.readLine());

        array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }
    }

    private static int findDesiredValuePosition(int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) >>> 1;

        if (array[mid] == desiredValue) return mid;

        if (array[left] <= array[mid]) {
            if (array[left] <= desiredValue && array[mid] >= desiredValue) {
                return findDesiredValuePosition(left, mid - 1);
            } else {
                return findDesiredValuePosition(mid + 1, right);
            }
        } else if (array[mid] < array[mid - 1] && array[mid] > array[mid + 1]) {
            if (desiredValue > array[mid]) {
                return findDesiredValuePosition(left, mid - 1);
            } else {
                return findDesiredValuePosition(mid + 1, right);
            }
        } else if (array[mid] <= desiredValue && array[right] >= desiredValue) {
            return findDesiredValuePosition(mid + 1, right);
        } else {
            return findDesiredValuePosition(left, mid - 1);
        }
    }
}