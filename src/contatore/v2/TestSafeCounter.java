package contatore.v2;

import java.util.Locale;
public class TestSafeCounter {
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Counter counter = new Counter();

        int incrementValue1 = 200_000_000;
        int incrementValue2 = 100_000_000;

        Incrementer incrementer1 =
                new Incrementer(counter, incrementValue1);

        Incrementer incrementer2 =
                new Incrementer(counter, incrementValue2);

        incrementer1.start();
        incrementer2.start();

        incrementer1.join();
        incrementer2.join();

        int counterValue = counter.getValue();

        long timeElapsed = System.currentTimeMillis() - startTime;

        System.out.format(Locale.ITALIAN, "SUM VALUE: %,d - SHOULD BE: %,d\n",
                counterValue,
                (incrementValue1 + incrementValue2));

        int difference = incrementValue1 + incrementValue2 - counterValue;

        double percent = ((0.0 + difference) /
                (incrementValue1 + incrementValue2)) * 100;

        System.out.format(Locale.ITALIAN,
                "DEFFERENCE: %,d - DIFF: %f %%\n", difference, percent);

        System.out.format(Locale.ITALIAN,
                "FINISHED Counter SAFE, elapsed time: %,d ms\n",
                timeElapsed);
    }
}