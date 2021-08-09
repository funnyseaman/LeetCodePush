package learning.designpattern.producerConsumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBuffer extends Buffer {

    public static void main(String[] args) {
        LockBuffer buffer = new LockBuffer(0, 1);
        Producer producer = new Producer(buffer, 1);
        Consumer consumer = new Consumer(buffer, 1);
        producer.start();
        consumer.start();
    }

    private Lock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private List<Integer> products = new ArrayList<>();
    private final int MIN;
    private final int MAX;

    public LockBuffer(int min, int max) {
        MIN = min;
        MAX = max;
    }

    public int get() {
        lock.lock();
        try {
            if (products.size() == MIN) {
                notEmpty.await();
            }
            int product = products.remove(0);
            notFull.signal();
            return product;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return -1;
    }

    public void put(int product) {
        lock.lock();
        try {
            if (products.size() == MAX) {
                notFull.await();
            }
            products.add(product);
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
