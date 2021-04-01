package algorithms.queue.based_linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithms.queue.Queue;

class Runner {

    private static final String GET = "get";
    private static final String PUT = "put";
    private static final String SIZE = "size";

    private static final Queue<Integer> queue = new LinkedQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandSize = Integer.parseInt(reader.readLine());

        for (int i = 0; i < commandSize; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            handleCommand(command, tokenizer);
        }
    }

    private static void handleCommand(String command, StringTokenizer tokenizer) {
        switch (command) {
            case GET -> {
                Integer value = queue.get();
                System.out.println((value == null) ? "error" : value);
            }
            case PUT -> queue.put(Integer.parseInt(tokenizer.nextToken()));
            case SIZE -> System.out.println(queue.size());
        }
    }
}
