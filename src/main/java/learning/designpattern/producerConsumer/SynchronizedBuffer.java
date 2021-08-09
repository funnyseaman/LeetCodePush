package learning.designpattern.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedBuffer extends Buffer {

    public static void main(String[] args) {
        SynchronizedBuffer buffer = new SynchronizedBuffer(0, 1);
        Producer producer = new Producer(buffer, 1);
        Consumer consumer = new Consumer(buffer, 1);
        producer.start();
        consumer.start();
    }

    private List<Integer> products = new ArrayList<>();
    private final int MIN;
    private final int MAX;

    public SynchronizedBuffer(int min, int max) {
        MIN = min;
        MAX = max;
    }

    public synchronized int get() {
        while (products.size() == MIN) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Integer i = products.remove(0);
        notifyAll();
        return i;
    }

    public synchronized void put(int product) {
        while (products.size() == MAX) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products.add(product);
        notifyAll();
    }
}
