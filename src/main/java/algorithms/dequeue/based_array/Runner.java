package algorithms.dequeue.based_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import algorithms.dequeue.Dequeue;

class Runner {

    private static final String PUSH_FRONT = "push_front";
    private static final String PUSH_BACK = "push_back";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";

    private static final BufferedReader mReader = new BufferedReader(new InputStreamReader(System.in));

    private static Dequeue dequeue;

    public static void main(String[] args) throws IOException {
        int commandSize = readInt();
        dequeue = new CyclicArrayDequeue(readInt());

        readCommand(commandSize);
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(mReader.readLine());
    }

    public static void readCommand(int size) throws IOException {
        StringTokenizer tokenizer;

        for (int i = 0; i < size; i++) {
            tokenizer = new StringTokenizer(mReader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case PUSH_FRONT -> dequeue.pushFront(Short.parseShort(tokenizer.nextToken()));
                case PUSH_BACK -> dequeue.pushBack(Short.parseShort(tokenizer.nextToken()));
                case POP_FRONT -> dequeue.popFront();
                case POP_BACK -> dequeue.popBack();
            }
        }
    }
}
