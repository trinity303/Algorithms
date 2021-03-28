package algorithms.factorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Factorization {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        factorization(n);
    }

    private static void factorization(int n) {
        if (n == 2) {
            System.out.println(2);

            return;
        }

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                System.out.print(i + " ");
                n = n / i;
            }
        }

        if (n > 2) System.out.print(n);
    }
}
