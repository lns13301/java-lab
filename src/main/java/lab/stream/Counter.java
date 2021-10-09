package lab.stream;

public class Counter implements Runnable {

    private int value = 0;

    public Counter() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            value += 1;
        }
    }

    @Override
    public String toString() {
        return "Counter{ " +
            "value = " + value +
            " }";
    }
}
