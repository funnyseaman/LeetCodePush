package learning.thread.printByOrder;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedPrinter extends Thread {
    public static void main(String[] args) {
        AtomicInteger synObj = new AtomicInteger(0);
        SynchronizedPrinter printerA = new SynchronizedPrinter(synObj, "A", 0);
        SynchronizedPrinter printerB = new SynchronizedPrinter(synObj, "B", 1);
        SynchronizedPrinter printerC = new SynchronizedPrinter(synObj, "C", 2);
        printerA.start();
        printerB.start();
        printerC.start();
    }

    private AtomicInteger synObj;
    private String name;
    private int flag;

    private int count = 0;
    private final int MAX_COUNT = 3;

    public SynchronizedPrinter(AtomicInteger synObj, String name, int flag) {
        this.synObj = synObj;
        this.name = name;
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (synObj) {
                if (synObj.get() % 3 == flag) {
                    synObj.incrementAndGet();
                    System.out.println(name);
                    synObj.notifyAll();
                    count++;
                    if (count == MAX_COUNT) {
                        break;
                    }
                } else {
                    try {
                        synObj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
