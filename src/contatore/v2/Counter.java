package contatore.v2;

public class Counter {
    private int counter;

    public synchronized void increment() {
        counter++;
    }

    public synchronized int getValue() {
        return counter;
    }
}
