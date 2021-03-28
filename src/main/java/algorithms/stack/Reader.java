package algorithms.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {

    private static String regex = "-?[1-9]\\d*|0";

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void read(Handler handler) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (token.matches(regex)) {
                handler.handleOperand(Integer.parseInt(token));

                continue;
            }

            handler.handleOperationSign(token);
        }
    }
}
