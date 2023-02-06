package contatore.v3;

import java.util.concurrent.atomic.AtomicInteger;
public class Counter {
    private AtomicInteger counter = new AtomicInteger();

    public void increment() {
        counter.incrementAndGet();
    }

    public int getValue() {
        return counter.get();
    }
}
