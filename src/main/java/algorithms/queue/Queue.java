package algorithms.queue;

public interface Queue<T> {
    T get();

    void put(T value);

    int size();
}
