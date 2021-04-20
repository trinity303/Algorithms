package algorithms.hashing;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Find two identical hashes calculated by Horner's method for strings
 *
 * Result:
 * oldmhqwsemhjpfswbbmomgy
 * wvhznshtqergkbklrgazixg
 */
public class CalculateSameHash {

    private static final int Q = 1000;
    private static final long R = 123987123;
    private static final byte STRING_SIZE = 23;
    private static final byte LOWER_LIMIT = 97;
    private static final byte UPPER_LIMIT = 122;

    public static void main(String[] args) {
        Set<Long> hashes = new HashSet<>();
        while (true) {
            String randomString = getRandomString();
            long hash = getHashCode(randomString);
            if (hashes.contains(hash)) {
                System.out.println("SAME HASH: " + hash);
                System.out.println("SAME STRING: " + randomString);

                return;
            }
            System.out.println("String: " + randomString + ", hash: " + hash);
            hashes.add(hash);
        }
    }

    private static long getHashCode(String s) {
        long hashVal = 0;
        for (int i = 0; i < s.length(); i++) {
            int letter = s.charAt(i);
            hashVal = (hashVal * Q + letter) % R;
        }

        return hashVal;
    }

    static String getRandomString() {
        Random random = new Random();

        StringBuilder r = new StringBuilder(STRING_SIZE);
        for (int i = 0; i < STRING_SIZE; i++) {
            int nextRandomChar = LOWER_LIMIT
                    + (int) (random.nextFloat()
                    * (UPPER_LIMIT - LOWER_LIMIT + 1));

            r.append((char) nextRandomChar);
        }

        return r.toString();
    }
}