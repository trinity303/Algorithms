package algorithms.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class TwoBicycles {

    private static int n;
    private static int[] array;
    private static int sum;

    public static void main(String[] args) throws IOException {
        prepareData();

        if (sum > array[n - 1]) {
            System.out.println(-1 + " " + -1);

            return;
        }

        int start = 0;
        int end = n - 1;

        System.out.println(find(start, end, sum) + " " + find(start, end, sum * 2));
    }

    private static void prepareData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        array = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        sum = Integer.parseInt(reader.readLine());
    }

    private static int find(int start, int end, int sum) {
        if (start == end) {
            int mid = (start + end) / 2;

            return (array[mid] < sum ? -1 : mid + 1);
        }

        int mid = (start + end) / 2;
        return (array[mid] < sum) ? find(mid + 1, end, sum) : find(start, mid, sum);
    }
}
