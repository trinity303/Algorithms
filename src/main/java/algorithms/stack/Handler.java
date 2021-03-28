package algorithms.stack;

public interface Handler {
    void handleOperand(int value);
    void handleOperationSign(String sign);
}
